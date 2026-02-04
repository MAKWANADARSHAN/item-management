# Step 1: Base image (Java installed OS)
FROM eclipse-temurin:17-jdk

# Step 2: Set working directory inside container
WORKDIR /app

# Step 3: Copy Maven wrapper & pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Step 4: Give permission to mvnw
RUN chmod +x mvnw

# Step 5: Download dependencies (faster builds)
RUN ./mvnw dependency:go-offline

# Step 6: Copy source code
COPY src src

# Step 7: Build Spring Boot JAR
RUN ./mvnw clean package -DskipTests

# Step 8: Expose application port
EXPOSE 8080

# Step 9: Run the application
CMD ["java", "-jar", "target/itemmanagement-0.0.1-SNAPSHOT.jar"]
