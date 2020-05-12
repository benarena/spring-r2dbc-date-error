# Readme

This project demonstrates a defect in mapping `java.time.Instant` variables to the database using Spring Data R2DBC.

This relates to [issue 207](https://github.com/spring-projects/spring-data-r2dbc/issues/207) in Spring Data R2DBC.
# Build
`mvn install`

# Create database
```
%> cd liquibase
%> mvn liquibase:update
%> cd ..
```

# Run tests
`mvn test`

## Test result
2020-05-12 12:00:01.173 DEBUG 43047 --- [actor-tcp-nio-1] o.s.d.r2dbc.core.DefaultDatabaseClient   : Executing SQL statement [INSERT INTO users (created) VALUES (?)]

```
java.lang.AssertionError: expectation "consumeNextWith" failed (expected: onNext(); actual: onError(java.lang.IllegalArgumentException: Cannot encode value of type 'class java.util.Date'))
...
	Suppressed: java.lang.IllegalArgumentException: Cannot encode value of type 'class java.util.Date'
		at dev.miku.r2dbc.mysql.codec.DefaultCodecs.encode(DefaultCodecs.java:182)
		Suppressed: reactor.core.publisher.FluxOnAssembly$OnAssemblyException: 
Error has been observed at the following site(s):
	|_ checkpoint ⇢ SQL "INSERT INTO users (created) VALUES (?)" [DatabaseClient]
Stack trace:
			at dev.miku.r2dbc.mysql.codec.DefaultCodecs.encode(DefaultCodecs.java:182)
			at dev.miku.r2dbc.mysql.ParametrizedStatementSupport.bind(ParametrizedStatementSupport.java:74)
			at dev.miku.r2dbc.mysql.ParametrizedStatementSupport.bind(ParametrizedStatementSupport.java:41)
			at org.springframework.data.r2dbc.core.DefaultDatabaseClient$StatementWrapper.bind(DefaultDatabaseClient.java:1684)
      ...
```
