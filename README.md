# Bidea Project

### How to use the application:
* Create a database "bidea" in PostSQL and password is "changeme" is not neccesary create tables because the application will do it
  ![alt text](https://media.discordapp.net/attachments/1144732753938620460/1265786141039263774/image.png?ex=66a2c6b5&is=66a17535&hm=b4c1a4c73be0781e4f0777e1a84b8e311ec8885174bb3dc8988c9db238bee48e&=&format=webp&quality=lossless&width=748&height=1118)
* In case you want to use another name and password have to change it in properties
  ![alt text](https://media.discordapp.net/attachments/1144732753938620460/1265786826527080530/image.png?ex=66a2c758&is=66a175d8&hm=086daf9620bb5fb366fa7a5c2398bec12e9037594911da6e0221e5bec59d7a4f&=&format=webp&quality=lossless&width=2160&height=1022)
* Then have to use neccesary URL "http://localhost:8080/bidea/book" to use POST in PostMan
### PostMan
* Status 200
  {
  "id": "16664081-1",
  "name": "Piero",
  "lastname": "Martinez",
  "age": 26,
  "phoneNumber": "662911222",
  "startDate": "2024-07-21",
  "endDate": "2024-07-21",
  "houseId": "266212",
  "discountCode": "D0661923"
  }
  ![alt text](https://media.discordapp.net/attachments/1144732753938620460/1265783631541174433/image.png?ex=66a2c45e&is=66a172de&hm=fc692c55f259576adc0865e6a0634ec855710f439360fd96cd5d9057abe2356e&=&format=webp&quality=lossless&width=1768&height=1118)
* Status 400
  {
  "id": "16664081-1",
  "name": "Piero",
  "lastname": "Martinez",
  "age": 26,
  "phoneNumber": "662911222",
  "startDate": "2024-07-21",
  "endDate": "2024-07-21",
  "houseId": "266212",
  "discountCode": ""
  }
  ![alt text](https://media.discordapp.net/attachments/1144732753938620460/1265784415913775104/image.png?ex=66a2c519&is=66a17399&hm=ad23e604d7d9b568d6b744bf51b69e79906014c7d3a2175dbe9d475417b22c83&=&format=webp&quality=lossless&width=1648&height=1118)
### PostgreSQL
* Also you can add new rows in DB the table is book_request
    You can use following query "select * from book_request"
  ![alt_text](https://media.discordapp.net/attachments/1144732753938620460/1265788580866031771/image.png?ex=66a2c8fa&is=66a1777a&hm=1cdb3cae8c83c3270199753df891db1309864cf2577c962c889bac2f5ea11660&=&format=webp&quality=lossless&width=2160&height=994)