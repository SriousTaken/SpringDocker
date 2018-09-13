cd src_spring1
./mvnw package && java -jar -jar target/gs-spring-boot-docker-0.1.0.jar
cp target/gs-spring-boot-docker-0.1.0.jar ../Docker1/docker.jar
cd ..
cd src_spring2
./mvnw package && java -jar -jar target/gs-spring-boot-docker-0.1.0.jar
cp target/gs-spring-boot-docker-0.1.0.jar ../Docker2/docker.jar


