package com.tsmc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.tsmc.dto.ActivityRequest;
import com.tsmc.dto.ActivityResponse;
import com.tsmc.dto.PrizeInfo;
import com.tsmc.entity.PrizeDetail;
import com.tsmc.entity.PrizeEmployees;
import com.tsmc.entity.TsmcActivity;
import com.tsmc.repo.TsmcActivityRepository;

@Service
public class TsmcActivityService {
	private static final Logger logger = LoggerFactory.getLogger(TsmcActivityService.class);

	private HttpHeaders headers;

	@Autowired
	private TsmcActivityRepository activityRepo;

	@Autowired
	private PrizeDetailService prizeDetailService;

	@Autowired
	private PrizeEmployeesService prizeEmployeesService;

	@PostConstruct
	private void instantiate() {
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	}

	public List<ActivityResponse> fetchTsmcActivityList() {
		return activityRepo.findAll().stream().map(e -> {
			ActivityResponse response = new ActivityResponse(e.getOid());
			response.setName(e.getActivityName());
			response.setCurrentIndex(e.getCurrentIndex());

			List<PrizeInfo> detail = prizeDetailService.fetchPrizeDetail(e.getOid()).stream().map(e1 -> {
				PrizeInfo info = new PrizeInfo(e1.getOid(), e1.getPrize(), String.valueOf(e1.getQuota()));
				Optional<PrizeEmployees> awardedUser = prizeEmployeesService.findByActyIdAndPrizeId(e.getOid(),
						e1.getOid());
				if (awardedUser.isPresent()) {
					info.setList(awardedUser.get().getEmplsId());
				} else {
					info.setList("");
				}
				return info;
			}).collect(Collectors.toList());

			response.setInfo(detail);
			response.setPrizeCount(e.getPrizeCount());
			response.setRandomList(e.getRandomList());
			response.setUsersCount(e.getUsersCount());

			return response;
		}).collect(Collectors.toList());

	}

	public HashMap<String, Object> fetchTsmcActivity(final String activityOid) {
		try {

			Optional<TsmcActivity> activity = activityRepo.findById(activityOid);
			logger.debug("activity = [{}]", activity);

			List<PrizeDetail> detail = prizeDetailService.fetchPrizeDetail(activity.get().getOid());
			HashMap<String, Object> result = new HashMap<>();
			result.put("activityOid", activity.get().getOid());
			result.put("usersCount", activity.get().getUsersCount());
			result.put("prizeCount", activity.get().getPrizeCount());
			result.put("name", activity.get().getActivityName());

			List<Map<String, Object>> detailInfo = detail.stream().map(e -> {

				Map<String, Object> prizeInfo = new HashMap<>();
				prizeInfo.put("prizeOid", e.getOid());
				prizeInfo.put("prize", Integer.valueOf(e.getPrize()));
				prizeInfo.put("quota", Integer.valueOf(e.getQuota()));

				String list = "";
				Optional<PrizeEmployees> prizeEmployees = prizeEmployeesService
						.findByActyIdAndPrizeId(activity.get().getOid(), e.getOid());
				if (prizeEmployees.isPresent()) {
					list = prizeEmployeesService.findByActyIdAndPrizeId(activity.get().getOid(), e.getOid()).get()
							.getEmplsId();
				}
				prizeInfo.put("list", list);
				return prizeInfo;

			}).collect(Collectors.toList());
			result.put("info", detailInfo);
			result.put("randomList", activity.get().getRandomList());
			result.put("currentIndex", activity.get().getCurrentIndex());
			return result;

		} catch (NoSuchElementException ex) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Empty record");
		}

	}

	public List<TsmcActivity> findByYear(final String year) {
		return activityRepo.findByYear(year);
	}

	public TsmcActivity createTsmcActivity(final ActivityRequest activityReq) {

		if (Integer.valueOf(activityReq.getPrizeCount()) < 1 || Integer.valueOf(activityReq.getUsersCount()) < 1) {
			throw new HttpClientErrorException(HttpStatus.FORBIDDEN,
					"Prize count and users count both cannot smaller than 1.");
		}

		if (!this.activityRepo.findByActivityName(activityReq.getName()).isPresent()) {
			TsmcActivity activity = this.convertToEntity(activityReq);

			return activityRepo.save(activity);
		} else {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Already has the same activity name, please change name");
		}

	}

	public TsmcActivity updateTsmcActivity(final String activityId, final String index) {
		TsmcActivity activity = this.activityRepo.findById(activityId).get();
		activity.setCurrentIndex(index);
		return activityRepo.save(activity);
	}

	private TsmcActivity convertToEntity(final ActivityRequest req) {
		TsmcActivity activity = new TsmcActivity();
		activity.setOid(UUID.randomUUID().toString());
		activity.setActivityName(req.getName());
		activity.setYear("2022");
		activity.setMonth("12");
		activity.setDay("31");
		activity.setUsersCount(req.getUsersCount());
		activity.setPrizeCount(req.getPrizeCount());
		activity.setRandomList(
				randomList(Integer.parseInt(req.getUsersCount())).toString().replace("[", "").replace("]", ""));
		activity.setCurrentIndex(String.valueOf(-1));
		return activity;
	}

	private List<Integer> randomList(Integer usersCount) {
		List<Integer> rangeList = IntStream.rangeClosed(1, usersCount).boxed().collect(Collectors.toList());
		return shuffleFisherYates(rangeList, usersCount);
	}

	private static List<Integer> shuffleFisherYates(List<Integer> list, int n) {
		List<Integer> result = new ArrayList<>();
		result = list;
		{
			// Creating object for Random class
			Random rd = new Random();

			// Starting from the last element and swapping one by one.
			for (int i = n - 1; i > 0; i--) {

				// Pick a random index from 0 to i
				int j = rd.nextInt(i + 1);

				// Swap array[i] with the element at random index
				int temp = result.get(i);
				result.set(i, result.get(j));
				result.set(j, temp);
			}
			// random generated list
			return result;
		}
	}

}
