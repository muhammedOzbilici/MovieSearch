## Movie Search Application with Spring Boot and React

This is an application for searching movies on OMDB api.  
Found movies will populated to db (H2 database) and it will be cached for 10 minutes.  
If the movie that you are searching, is not in db, then it will search throug OMDB api.    


docker run :  

```
docker build -f Dockerfile -t moviesearch .  
docker run -p 8082:8082 moviesearch  
```

Swagger Api  
http://localhost:8082/swagger-ui.html
