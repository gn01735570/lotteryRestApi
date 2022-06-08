# lotteryRestApi
此次抽籤採用Fisher–Yates shuffle algorithm，主要作法和邏輯為:

1. 將加入抽獎的總人員名單(ex: 總人數為 n)，從最後一位人員開始依序向前，random選取陣列範圍index position的數字做交換
2. 最後一位人員swap結束後，Remove，last index element，輪到倒數第二位人員，random選取陣列範圍index position的數字做交換位置，依序輪到倒數第三位依照相同方法交換位置...
3. 故所有名單人員位置，完整洗牌過，所得到的數列
4. 相當於n個人抽籤，跟名單先後順序無關，每個人抽到某個元素的機率是相等的

資料圖片參考來源(https://sebhastian.com/fisher-yates-shuffle-javascript/)
![image](https://user-images.githubusercontent.com/72732535/172505074-1c60f06b-573b-4b7f-906d-8421f37ea99c.png)
![image](https://user-images.githubusercontent.com/72732535/172505195-65627abf-495c-4201-93b9-368901e03bc9.png)


lotteryRestApi實作
![image](https://user-images.githubusercontent.com/72732535/172470594-1304022a-afb8-4b32-9788-aa6353b5935d.png)


資料儲存: 以三張Table 儲存抽獎活動 (TSMC_ACTY)、活動獎項(TSMC_ACTY_PRIZE_DETL)、中獎人員名單(TSMC_PRIZE_EMPLS)

- TSMC_ACTY

![image](https://user-images.githubusercontent.com/72732535/172450211-5a8a8864-fb6f-4c36-9775-c62e8acb6648.png)


- TSMC_ACTY_PRIZE_DETL

![image](https://user-images.githubusercontent.com/72732535/172060486-805b7147-9145-4e48-bb8c-1538479a951d.png)




- TSMC_PRIZE_EMPLS

![image](https://user-images.githubusercontent.com/72732535/172060262-4c244310-258d-4196-b019-739f00fba54a.png)
