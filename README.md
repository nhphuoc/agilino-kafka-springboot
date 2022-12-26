# Getting Started

[Agilino Vietnam](https://agilino.vn) is a software development company based in Can Tho.

For our today`s exercise we want to implement a food delivery service called "Agilino Food".

Follow the hints in the java files and make the unit tests run successful.

## Running the project

### Connecting to kafka 

After all your unit tests pass run the application connecting to our server.

* Connect to our Kafka available during workshop: 

* start kafka locally with docker

```bash
docker-compose up -d
```


### Starting spring project

```bash
./gradlew bootRun
```

### Using curl to send messages
Use curl to send a HTTP POST message in JSON format:
```bash
curl -XPOST -H "content-type: application/json" http://localhost:8080/kafka/send -d "{\"name\":\"adam\"}"
```

## Further reading

### Running your own kafka 

When running at home we encourage you to use the docker-compose image to run kafka from docker.

If your laptop has not enough space and RAM to run docker you can run kafka on the cloud.

In our exercise we provided a public Kafka Server. This is just for demo.
Kafka should in an internal network between your backend services not reachable from outside.

For the sake of the demo we are using [nginx streams with docker](https://github.com/sarwarbhuiyan/kafka-nginx-reverseproxy).

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.1/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.1/gradle-plugin/reference/html/#build-image)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

