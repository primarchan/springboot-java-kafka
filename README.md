# 대용량 비동기 프로세스를 위한 Kafka 활용 프로젝트

## TECH STACK
- Java 8
- Gradle
- Spring Boot 2.7.14
- Spring for Apache Kafka
- IntelliJ IDEA

## INSTALLATION
- Zookeeper 실행
    - `bin/zookeeper-server-start.sh config/zookeeper.properties`
- Kafka 실행
    - `bin/kafka-server-start.sh config/server.properties`
- Topic 생성
    - `bin/kafka-topics.sh --create --topic {Topic명} --bootstrap-server localhost:9092 --partitions 3`

## REFERENCE
- Spring Kafka [링크 클릭](https://spring.io/projects/spring-kafka)
- Spring Initializer [링크 클릭](https://start.spring.io)

## RESULT