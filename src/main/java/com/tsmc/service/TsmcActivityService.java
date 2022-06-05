package com.tsmc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

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
import com.tsmc.entity.PrizeDetail;
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

	public Object fetchTsmcActivity(final String activityName, final String year, final String month,
			final String day) {
		try {
			TsmcActivity activity = activityRepo.fetchByActivityNameAndActivityDate(activityName, year, month, day).get();

			logger.debug("activity = [{}]", activity);

			List<PrizeDetail> detail = prizeDetailService.fetchPrizeDetail(activity.getOid());
			HashMap<String, Object> result = new HashMap<>();
			result.put("activityOid", activity.getOid());
			result.put("usersCount", activity.getUsersCount());
			result.put("prizeCount", activity.getPrizeCount());

			List<Map<String, Object>> detailInfo = detail.stream().map(e -> {

				Map<String, Object> prizeInfo = new HashMap<>();
				prizeInfo.put("prizeOid", e.getOid());
				prizeInfo.put("prize", e.getPrize());
				prizeInfo.put("quota", e.getQuota());
				String list = "";

				if (prizeEmployeesService.findByActyIdAndPrizeId(activity.getOid(), e.getOid()) != null) {
					list = prizeEmployeesService.findByActyIdAndPrizeId(activity.getOid(), e.getOid()).getEmplsId();
				}
				prizeInfo.put("list", list);
				return prizeInfo;

			}).collect(Collectors.toList());
			result.put("info", detailInfo);
			return result;
			
		} catch (NoSuchElementException ex) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Empty record");
		}

	}

	public List<TsmcActivity> findByYear(final String year) {
		return activityRepo.findByYear(year);
	}

	public TsmcActivity createTsmcActivity(final ActivityRequest activityReq) {
		TsmcActivity activity = this.convertToEntity(activityReq);

		return activityRepo.save(activity);
	}

	private TsmcActivity convertToEntity(final ActivityRequest req) {
		TsmcActivity activity = new TsmcActivity();
		activity.setOid(UUID.randomUUID().toString());
		activity.setActivityName(req.getName());
		activity.setYear(req.getYear());
		activity.setMonth(req.getMonth());
		activity.setDay(req.getDay());
		activity.setUsersCount(req.getUsersCount());
		activity.setPrizeCount(req.getPrizeCount());

		return activity;
	}

}
