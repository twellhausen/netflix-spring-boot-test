# netflix-spring-boot-test

Here, you can find some code that shows the integration of the Netflix libraries Eureka, Ribbon and Hystrix with Spring Boot.
There are two different scenarios: with and without Eureka as central service registry.

## Start tests without Eureka

Execute each of the following lines in a separate terminal:

```
./gradlew bootRun -p bar-service-standalone -Dserver.port=8081
./gradlew bootRun -p bar-service-standalone -Dserver.port=8082
./gradlew bootRun -p bar-service-standalone -Dserver.port=8083
./gradlew bootRun -p foo-service-standalone
curl http://localhost:8080/message
```

See what happens if you fetch the message multiple times. Try to terminate and restart any of the bar services.

## Start tests with Eureka

Execute each of the following lines in a separate terminal:

```
./gradlew bootRun -p eureka-server
./gradlew bootRun -p bar-service-eureka -Dserver.port=8081
./gradlew bootRun -p bar-service-eureka -Dserver.port=8082
./gradlew bootRun -p bar-service-eureka -Dserver.port=8083
./gradlew bootRun -p foo-service-eureka
curl http://localhost:8080/message
```

See what happens if you fetch the message multiple times. Try to terminate and restart any of the bar services.
Have a look at <http://localhost:8761/>.

## Simulate high load

Execute the following line in a separate terminal:

```
./gradlew run -p test-client
```

See what happens at <http://localhost:8080/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8080%2Fhystrix.stream>.

## More information

More to come... 
