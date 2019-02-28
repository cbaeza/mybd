# mybd
Playground with [flyway](https://flywaydb.org/), [jOOQ](https://www.jooq.org/), [H2](http://www.h2database.com/html/main.html) and [SpringBoot](http://spring.io/projects/spring-boot) 

# Build
To run a full build

    (master) $ gradle build -i
    
# Migrate DB
Flyway is available in the Gradle build. Run:

    (master) $ gradle flywayMigrate -i

Display DB info

    (master) $ gradle flywayInfo -i
    
This command display the current DB status and migrations done.

    Schema version: 2
    +-----------+---------+---------------------+------+---------------------+---------+
    | Category  | Version | Description         | Type | Installed On        | State   |
    +-----------+---------+---------------------+------+---------------------+---------+
    | Versioned | 1       | Create person table | SQL  | 2019-02-10 22:37:36 | Success |
    | Versioned | 2       | Add people          | SQL  | 2019-02-10 22:39:58 | Success |
    +-----------+---------+---------------------+------+---------------------+---------+        

# Run tests

    (master) $ gradle clean test -i
    
# Run SpringBoot app
App run http://localhost:8080/

    (master) $ gradle bootRun -i    
    
Available rest endpoint
    
    http://localhost:8080/persons
