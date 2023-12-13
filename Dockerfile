FROM openjdk:21-oracle
WORKDIR /app
EXPOSE 8888
COPY target/fashionBlog-0.0.1-SNAPSHOT.jar /app/
RUN bash -c 'touch /app/fashionBlog-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java", "-jar","/app/fashionBlog-0.0.1-SNAPSHOT.jar"]














#FROM openjdk:21-oracle
#LABEL authors="naz.net"
#ADD target/fashionBlog-0.0.1-SNAPSHOT.jar fashionBlog.jar
#EXPOSE 8089
#EXPOSE 5432
#ENTRYPOINT ["java", "-jar", "fashionBlog.jar"]



#
#FROM openjdk:21-oracle
#ARG JAR_FILE=target/*.jar
#COPY target/fashionblog-postgresql-docker.jar fashionblog-postgresql-docker.jar
#EXPOSE:3000
#ENTRYPOINT ["java", "-jar", "/fashionblog-postgresql-docker.jar"]