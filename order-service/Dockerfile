FROM eclipse-temurin:21-alpine AS build

RUN apk add --no-cache maven

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine

# Set the workdir
WORKDIR /app

# Copy artifacts from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port
EXPOSE 8881

# Execute the command
ENTRYPOINT ["java", "-jar", "app.jar"]