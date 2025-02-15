# Welcome to the assignment of Dennis Rosenbaum

This project is a simple REST API that allows you to get and check trivia questions. The API provides the following endpoints:
- /questions?count=1 (GET) - Returns a list of trivia questions. The count parameter (optional) specifies the number of questions to return.
- /questions/{questionId}/answers/{answerId} (GET) - Checks if the answer with the specified question and answer combination is correct. An API key must be added (to the apiKey query) to ensure private access.
- /checkanswers (POST) - Same functionality as the previous endpoint, deprecated but still available as per specification

For all endpoints, check out the swagger documentation: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Production
For the live swagger documentation, see [https://quad-assignment-gqbafbdwdpgnaxgy.westeurope-01.azurewebsites.net/swagger-ui/index.html](https://quad-assignment-gqbafbdwdpgnaxgy.westeurope-01.azurewebsites.net/swagger-ui/index.html)

## Start the project
1. Start of by cloning the project to your local machine.
2. Add a file to the root directory of the project called `application.properties` with the content below.
3. Install dependencies by executing `mvn clean install`
4. Run the project by executing `mvn spring-boot:run` in the root directory of the project. The application will be available at `http://localhost:8080`.

## application.properties
```
azure.table.storage.connection_string=DefaultEndpointsProtocol=https;AccountName=quadassignment;AccountKey=RwJjNQKGw9EiE8KiCfmMYMgn2xu6Zt5FIbfhsRDXpnAfjMJg0zNBiE1+6N/chPFtDMvFEOM4bXjR+AStcOKOUA==;EndpointSuffix=core.windows.net
api_key=8ppmMQ5l07RhMXxg9xOzBXd3HIT10XKd1N01S
```
shhh... don't tell anyone about the keys

## Run unit tests
To run the unit tests, execute `mvn test` in the root directory of the project.
