# Fravega Challenge
> Challenge de fravega

## Servicio Get Node

> Obtiene el Nodo con la sucursal y el punto de retiro

### Request

`GET /?id=1`

```
curl -i -H 'Accept: application/json' http://localhost:8080/
```

### Response
```
HttpStatus: 200 OK
Content-Type: application/json

{
    "branch": {
        "address": "1111",
        "dateAttention": "2021-02-12 00:00:00.0",
        "latitude": "-12",
        "longitude": "-10"
    },
    "pickupPoint": null
}

{
    "branch": null,
    "pickupPoint": {
        "capacity": 10,
        "latitude": "-12",
        "longitude": "-10"
    }
}
```
## Servicio de add Branch

> Guarda una nueva sucursal

### Request

`POST /branch`

```
curl -i -H 'Accept: application/json' -d 'address=colombres1234&dateAttention=2021-02-12&latitude=-30%longitude=50' http://localhost:8080/branch
```

### Response
```
HttpStatus: 201 CREATED
Content-Type: text/plain

El id creado es: 2
```

## Servicio de update Branch

> Actualiza una sucursal

### Request

`PUT /branch?id=1`

```
curl -i -H 'Accept: application/json' -X PUT -d 'address=colombres1234&dateAttention=2021-02-12&latitude=-30%longitude=50' http://localhost:8080/branch?=1
```

### Response
```
HttpStatus: 200 OK
Content-Type: application/json
```

## Servicio de delete Branch

> Borra una sucursal

### Request

`DELETE /branch?id=1`

```
curl -i -H 'Accept: application/json' -X DELETE http://localhost:8080/branch?=1
```

### Response
```
HttpStatus: 200 OK
Content-Type: application/json
```

## Servicio de add PickupPoint

> Guarda un nuevo Punto de Retiro

### Request

`POST /pickupPoint`

```
curl -i -H 'Accept: application/json' -d 'capacity=10&latitude=-30%longitude=50' http://localhost:8080/pickupPoint
```

### Response
```
HttpStatus: 201 CREATED
Content-Type: text/plain

El id creado es: 2
```

## Servicio de update PickupPoint

> Actualiza un Punto de Retiro

### Request

`PUT /pickupPoint?id=1`

```
curl -i -H 'Accept: application/json' -X PUT -d 'capacity=10&latitude=-30%longitude=50' http://localhost:8080/pickupPoint?=1
```

### Response
```
HttpStatus: 200 OK
Content-Type: application/json
```

## Servicio de delete PickupPoint

> Borra un Punto de Retiro

### Request

`DELETE /pickupPoint?id=1`

```
curl -i -H 'Accept: application/json' -X DELETE http://localhost:8080/pickupPoint?=1
```

### Response
```
HttpStatus: 200 OK
Content-Type: application/json
```

## Dependencias
* Spring 2.5.4
* Swagger 2 3.0.0
* Actuator
* H2

## Url de Swagger
```
http://localhost:8080/swagger-ui.html#
```

## Url de Health Check
```
http://localhost:8080/actuactor/health
```

## Ejecucion de proyecto
```
mvn clean install
java -jar fravegaChallenge.jar
```