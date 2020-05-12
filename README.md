# Readme

This project demonstrates a defect in mapping `java.time.Instant` variables to the database using Spring Data R2DBC.

This relates to [issue 207](https://github.com/spring-projects/spring-data-r2dbc/issues/207) in Spring Data R2DBC.
# Build
`mvn install`

# Create database
```
%> cd liquibase
%> mvn liquibase:update
```

# Run tests
`mvn test`
