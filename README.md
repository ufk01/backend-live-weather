
# How to Run Backend

The backend directory contains two `.yml` configuration files:

- `application.yml`: General configuration information for the project.
- `application-dev.yml`: Specifies the port number (5005) on which the project will run. If there is a port conflict, update the port in this file.

Before running the application, ensure that the Spring Boot environment settings are correctly configured.

## 1) Requirements

- **IntelliJ IDEA** (strongly recommended)
- **Maven** (included with IntelliJ IDEA)
- **Java 19 SDK**

## 2) Build and Run

### Steps:

1. **Download and Install Java 19 SDK**:
   Ensure that Java 19 SDK is installed on your system.

2. **Configure the Application**:
   - The application uses `Java 19 SDK`, and the `services` module contains the main class `com.weather.LiveWeatherApplication`.
   - Specify the active profile as `dev` to run the application.

3. **Run the Application**:
   - You can run the application either by using the run button in IntelliJ IDEA or by running the `Main` class directly.

## 3) Project Structure

The project has a root Maven module named `Live-Weather`, which includes the following submodules:

- **Persistence Module**:
  - Contains data attributes for the Current Weather page, representing objects used in the application from the JSON response.

- **Service Module**:
  - **Model (DTO)**: Contains Data Transfer Objects (DTOs).
  - **Config**: Contains RestTemplate configurations.
  - **Service**: Contains the `WeatherService` interface and the `WeatherServiceImpl` class.
  - **Controller**: Contains the `WeatherController` class.

Additionally, the `resources` folder within the `services` module contains the `application.yml` and `application-dev.yml` files.

## Additional Notes

- Ensure that the configuration files are set up correctly. Running `mvn clean install` from the root directory will also clean and install the submodules.
