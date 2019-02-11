# mybd
DB playground with flyway and jOOQ 

# Build

    (master) $ gradle build -i
    
# Migrate DB
Flyway is available in the Gradle build. Run:

    (master) $ gradle flywayMigrate -i

Disply DB info

    (master) $ gradle flywayInfo -i
    
This command display the current DB status and migrations done.

    Schema version: 2
    +-----------+---------+---------------------+------+---------------------+---------+
    | Category  | Version | Description         | Type | Installed On        | State   |
    +-----------+---------+---------------------+------+---------------------+---------+
    | Versioned | 1       | Create person table | SQL  | 2019-02-10 22:37:36 | Success |
    | Versioned | 2       | Add people          | SQL  | 2019-02-10 22:39:58 | Success |
    +-----------+---------+---------------------+------+---------------------+---------+        

