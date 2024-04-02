# Notes System

*A backend system for Notes management. Consists of Create, Update and Delete functionality of a Note. It also has a basic not found exception handling.*

## Libraries/Tools Used
* Java 17
* Maven
* [Spring Boot](https://spring.io/projects/spring-boot) with the following components:
    * Spring Web

### A. Run the Spring Boot application
1. Open your IDE (**e.g.,** IntelliJ)
2. Go to [exam]
3. Right-click then select **Run/Debug**.
4. This will run the Spring Boot application - below is the expected logs at startup.
```
 .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 [2m2024-04-02T22:48:34.717+08:00[0;39m [32m INFO[0;39m [35m24012[0;39m [2m---[0;39m [2m[exam] [           main][0;39m [2m[0;39m[36mcom.ota.exam.ExamApplication            [0;39m [2m:[0;39m Starting ExamApplication using Java 17.0.10 with PID 24012 (D:\Programming\exam\target\classes started by mirvh in D:\Programming\exam)
[2m2024-04-02T22:48:34.720+08:00[0;39m [32m INFO[0;39m [35m24012[0;39m [2m---[0;39m [2m[exam] [           main][0;39m [2m[0;39m[36mcom.ota.exam.ExamApplication            [0;39m [2m:[0;39m No active profile set, falling back to 1 default profile: "default"
[2m2024-04-02T22:48:35.262+08:00[0;39m [32m INFO[0;39m [35m24012[0;39m [2m---[0;39m [2m[exam] [           main][0;39m [2m[0;39m[36mo.s.b.w.embedded.tomcat.TomcatWebServer [0;39m [2m:[0;39m Tomcat initialized with port 8080 (http)
[2m2024-04-02T22:48:35.270+08:00[0;39m [32m INFO[0;39m [35m24012[0;39m [2m---[0;39m [2m[exam] [           main][0;39m [2m[0;39m[36mo.apache.catalina.core.StandardService  [0;39m [2m:[0;39m Starting service [Tomcat]
[2m2024-04-02T22:48:35.271+08:00[0;39m [32m INFO[0;39m [35m24012[0;39m [2m---[0;39m [2m[exam] [           main][0;39m [2m[0;39m[36mo.apache.catalina.core.StandardEngine   [0;39m [2m:[0;39m Starting Servlet engine: [Apache Tomcat/10.1.19]
[2m2024-04-02T22:48:35.308+08:00[0;39m [32m INFO[0;39m [35m24012[0;39m [2m---[0;39m [2m[exam] [           main][0;39m [2m[0;39m[36mo.a.c.c.C.[Tomcat].[localhost].[/]      [0;39m [2m:[0;39m Initializing Spring embedded WebApplicationContext
[2m2024-04-02T22:48:35.308+08:00[0;39m [32m INFO[0;39m [35m24012[0;39m [2m---[0;39m [2m[exam] [           main][0;39m [2m[0;39m[36mw.s.c.ServletWebServerApplicationContext[0;39m [2m:[0;39m Root WebApplicationContext: initialization completed in 556 ms
[2m2024-04-02T22:48:35.566+08:00[0;39m [32m INFO[0;39m [35m24012[0;39m [2m---[0;39m [2m[exam] [           main][0;39m [2m[0;39m[36mo.s.b.w.embedded.tomcat.TomcatWebServer [0;39m [2m:[0;39m Tomcat started on port 8080 (http) with context path ''
[2m2024-04-02T22:48:35.572+08:00[0;39m [32m INFO[0;39m [35m24012[0;39m [2m---[0;39m [2m[exam] [           main][0;39m [2m[0;39m[36mcom.ota.exam.ExamApplication            [0;39m [2m:[0;39m Started ExamApplication in 1.108 seconds (process running for 1.579)
[2m
 ```
 
 
### Test Server
1. Go to Postman -> Import and then paste the curl commands below. 
2. Don't forget to change the IDs to be tested.

#### POST /notes: Create a new note.

```
curl --location 'http://localhost:8080/notes' \
--header 'Content-Type: application/json' \
--data '{
    "title": "Title",
    "body": "Body"
}'
```

#### GET /notes: Retrieve all notes.

```
curl --location 'http://localhost:8080/notes'
```

#### GET /notes/:id: Retrieve a specific note by ID.

```
curl --location 'http://localhost:8080/notes/<id>'
```

#### PUT /notes/:id: Update a specific note.

```
curl --location --request PUT 'http://localhost:8080/notes/<id>' \
--header 'Content-Type: application/json' \
--data '{
    "title": "Titleupdate",
    "body": "Body"
}'
```

#### DELETE /notes/:id: Delete a specific note.

```
curl --location --request DELETE 'http://localhost:8080/notes/<id>' \
--header 'Content-Type: application/json' \
--data ''
```