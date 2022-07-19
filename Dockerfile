FROM greyfoxit/alpine-openjdk8

ADD crm-proxy-webapp/target/Spring-boot-docker.jar spring-boot-docker.jar

ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=persistence","/spring-boot-docker.jar"]

VOLUME  logs

EXPOSE 9012