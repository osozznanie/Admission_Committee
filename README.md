# Admissions Committee System

This repository contains the code for the Admissions Committee System, a Java-based project for managing the admissions process in an educational institution.

## Updates

### September 25, 2023

#### Added Domain and Dao Layers

In this update, we've introduced the Domain and Dao layers to the project. These layers help organize the project structure and provide a clear separation of concerns.

- **Domain Layer**: The Domain layer includes classes that represent the core domain objects and entities in the system, such as Applicants, Faculties, Certificates, and Recruitment Plans. These classes encapsulate the business logic of the system.

- **Dao Layer**: The Dao (Data Access Object) layer is responsible for handling data storage and retrieval. It includes classes and methods for interacting with the database or any other data storage mechanism. For example, it may include methods for CRUD (Create, Read, Update, Delete) operations on Applicants, Faculties, and other domain objects.

### Project Structure

- src/
  - main/
    - java/
      - com/
        - yourcompany/
          - admissions/
            - domain/
              - Applicant.java
              - Faculty.java
              - Certificate.java
              - ...
            - dao/
              - ApplicantDao.java
              - FacultyDao.java
              - ...
            - ...
  - resources/
    - application.properties
- README.md


### Usage

To use this project, you can follow these steps:

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/osozznanie/Admission_Committee.git
   
### Configuring the database connection

To configure the database connection, perform the following steps:

1. open the `application.properties` file.

2. Locate the settings for the database connection and specify the required parameters such as host, port, database name, user name and password.

3. Save the changes in the `application.properties` file.
