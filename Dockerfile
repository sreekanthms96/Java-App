FROM openjdk:17
WORKDIR /app

# Copy source files
COPY AttendanceApp.java .
COPY mysql-connector-java.jar .

# Compile Java code
RUN javac -cp .:mysql-connector-java.jar AttendanceApp.java

# Run app
CMD ["java", "-cp", ".:mysql-connector-java.jar", "AttendanceApp"]
