# QRCODE Generator

### tools:
- linux
- intellij
- java 17
- gradle
- spring data
- spring web
- lombok
- postgresql
- zxing

## Run Project

clone the project:
```bash
git clone git@github.com:bianavic/qrcode-generator.git
```

navigate to application directory
```bash
cd qrcode-generator
```
build application
```bash
./gradlew build
```
run the application
```bash
sudo docker-compose up
```
stop the application
```bash
sudo docker-compose down
```

## Generate QRCode
while project is up

1- make a post-request with your Wi-Fi name and password

2- make a get-request: it will generate the qrcode png file at resources directory

<img src="src/main/resources/qrcodes/test1-QRCODE.png" width="200" height="200">


## Client

| API ROUTE		                | DESCRIPTION                   | STATUS |
|:--------------------------------|:------------------------------|:-------|
| [POST] v1/wifi                  | Add a new wifi                | 200    |
| [GET] v1/wifi/{id}              | Retrieve wifi by ID           | 200    |
| [GET] v1/wifi	               | Retrieve all registered wifis | 200    |


#### add wifi
```bash
curl --location 'http://localhost:9090/v1/wifi' \
--header 'Content-Type: application/json' \
--data '{
    "wifiName": "test",
    "wifiPassword": "test123"
}'
```
###### 200 OK
``` json
{"id":1,"wifiName":"test","wifiPassword":"test123"}
```

#### get all registered wifi
```bash
curl --location 'http://localhost:9090/v1/wifi' \
--data ''
```
###### 200 OK
``` json
[
    {
        "id": 1,
        "wifiName": "test",
        "wifiPassword": "test123"
    }
]
```

#### get wifi by ID
```bash
curl --location 'http://localhost:9090/v1/wifi/1' \
--data ''
```
###### 200 OK
``` json
{
    "id": 1,
    "wifiName": "test",
    "wifiPassword": "test123"
}
```


