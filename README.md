Example of using Vavr(Javaslang) in Spring JPA

This project demostrates how to configure Vavr and Spring JPA.  
Important part of it is that Spring Boot version (and therefore Spring JPA version) must be up to date.  
  
- **Sample usage is shown in `PersonRepositoryIntegrationTest`**  
- **"jackson-vavr" configuration is shown in `SpringDataMongoVavrApplication` and tested in `MainControllerIntegrationTest`**  

  
Other details:  
- Also shown how to configure separate folder for integration tests in Gradle and combine it with `test` phase  
- `PersonRepositoryIntegrationTest` shows also how to create emmbeded MongoDB for test purposes
