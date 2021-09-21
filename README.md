## Build project

To build the project, simply run
```
./gradlew build
```

## Start project

To start the project, simply run
```
./gradlew bootRun
```

Once the service started, the endpoint will be available at `localhost:8081`, so you can make request to the service endpoint

```
Mandatory string input
	X-string and XX-string
	X denotes rule number
	
	Invalid rule number will throw 400 Bad Request
```

```json
GET localhost:8081/reply/11-helloworld

{
    message: "helloword"
}
```

## Run Tests

To Run tests, run them as JUnit Test cases