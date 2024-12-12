# container 1
# name the first container "builder"
FROM eclipse-temurin:23-noble AS builder

WORKDIR /src

# copy files 
COPY mvnw .
COPY pom.xml .

COPY .mvn .mvn
COPY src /src/

# make mvnw executable 
RUN chmod a+x mvnw && ./mvnw package -Dmaven.test.skip=true
# eventmanagement-0.0.1-SNAPSHOT.jar


# container 2
FROM eclipse-temurin:23-jre-noble

WORKDIR /app

# copy from builder container and rename to app.jar
COPY --from=builder /src/target/eventmanagement-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=8080

EXPOSE ${PORT}

ENTRYPOINT SERVER_PORT=${PORT} java -jar app.jar