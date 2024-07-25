# How To Run Backend

The backend directory contains two .yml configuration files: `application.yml` and `application-dev.yml`.

- `application.yml` contains the general configuration information for the project.
- `application-dev.yml` specifies the port number (5005) on which the project will run.

  ## If there is a port conflict, enter the appropriate port in 'application-dev.yml' file !

Therefore, we need to set up the Spring Boot environment settings before running the application.

## 1) Build and Run

The application runs with Java 19 SDK and uses `com.weather.LiveWeatherApplication` as the main class. We need to specify the active profile as `dev` to run the application.

Steps:

### 1. Download and install Java 19 SDK.
### 2. Navigate to the root directory of the `Live-Weather` project.
### 3. Run the application with the following command:
   ```sh
   ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
   ```

## 2) Project Structure

The project has a main (root) Maven module named `Live-Weather`. Within this Maven structure, there are two submodules: `persistence` and `services`.

- **Persistence Module**:
  - Contains the attributes of the data retrieved from the Current Weather page, i.e., the objects to be used in the application from the returned JSON expression.

- **Service Module**:
  - **Model (DTO)**: Contains Data Transfer Objects (DTO).
  - **Config (RestTemplate)**: Contains RestTemplate configurations.
  - **Service**: Contains the `WeatherService` interface and the `WeatherServiceImpl` class.
  - **Controller**: Contains the `WeatherController` class.

Additionally, the `resources` folder within the `services` module contains the `application.yml` and `application-dev.yml` files.

## Additional Notes

- To ensure all dependencies are loaded, run the `./mvnw clean install` command in the root directory of the project.
- Make sure the configuration files are set up correctly. Running `mvn clean install` from the root will also clean and install the submodules in one go.
