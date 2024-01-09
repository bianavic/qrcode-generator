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

## How To
gitclone
build
run - postgres config

post
get -> 
visualizar qrcode:
faça o get, o qrcode é gerado como png na pasta src/main/resources/qrcodes
scanear

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
###### 200 CREATED
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


