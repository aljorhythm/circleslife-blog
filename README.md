# circleslife-blog

# Development

## Building

`./gradlew build`

## Testing

`./gradlew test`

## Database

Database for unit testing is embedded. To connect to a real server, create/edit springboot configuration files as per profile.

https://www.baeldung.com/spring-profiles

Example `application-demo.yml`

```
spring.data.mongodb.authentication-database=admin
spring.data.mongodb.username=root
spring.data.mongodb.password=root
spring.data.mongodb.database=test_db
spring.data.mongodb.port=27017
spring.data.mongodb.host=localhost
```

And run `java -jar <jar artefact path> -Dspring.profiles.active=demo`