# Java Application 에서 Kafka Application 구현 실습 프로젝트

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
    - `bin/kafka-topics.sh --create --topic topic5 --bootstrap-server localhost:9092 --partitions 3`

## REFERENCE
- Spring Kafka [링크 클릭](https://spring.io/projects/spring-kafka)
- Spring Initializer [링크 클릭](https://start.spring.io)

## RESULT