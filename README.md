# 高鐵訂票系統範例
### 系統架構及功能簡介
此系統模擬高鐵訂票的各項動作，查詢、訂票、退票......等。
我們的架構以 Command design pattern 為基礎，以 Server 跟 Client 的互動作為運作機制。
以下為我們的架構圖：
![N|Solid](/img/sturcture.png)

Server 為伺服器端，Client 為客戶端，他們會以許多種不同的 object 來溝通(姑且先統稱他們為message object，雖然他們彼此沒有繼承關係)。

當 Client 接收到使用者的指令後，會以 socket 傳送一個 message object 給 Server，Server 會新增一個 thread，再根據他接收到哪一種指令(i.e message 為哪一種 class)來做相對應的處理。

Client端以GUI呈現，主要為四大功能:訂票、退票、查詢、搜尋。

1.訂票: 
此功能在 Booking 內，供使用者選擇起訖站、車廂種類、座位喜好、出發時間、是否要來回票以及各票種的張數。選完後按下 Search Car 按鈕，Client 端便會傳一個 SearchCar物件給 Server，而 Server 會回傳一個 Available 物件給 Client，其內包含一個 Car 的 linked list，即為各車種資訊。接著頁面會跳出許多符合使用者要求的車次供使用者挑選，使用者選完後輸入 CarID 並按下 Confirm 鍵，Server 端便會更改 database，並完成訂票。

2.退票:
此系統的退票功能是與查詢相連接，在查詢自己的訂票紀錄後若按下 cancel 鍵，即為退票。

3.查詢:
查詢分兩種，一種是輸入 userID 來查詢自己的訂單資訊(起訖站、到達時間...等)，另外一種為忘記自己的訂位代號，則輸入 userID、起訖站、carID、date 來查詢自己的訂位代號。

4.搜尋:
此系統提供 SearchDaily 的功能，使用者只要輸入欲搜尋的 date，Server 端便會找出當日所有車次提供給使用者參考，內容包含 carID 跟各站的出發時間。
### 系統架構及功能簡介
* GUI 套件(jdatepicker-1.3.4 )
* MySQL 套件(mysql-connector-java-8.0.11)
* json parser 套件(https://github.com/fangyidong/json-simple/tree/master/src/main/java/org/json/simple)

