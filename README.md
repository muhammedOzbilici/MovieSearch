## Movie Search Application with Spring Boot and React

This is an application for searching movies on OMDB api.  
Found movies will populated to db (H2 database) and it will be cached for 10 minutes.  
If the movie that you are searching is not in db, then it will search through OMDB api.   

Reach github link

https://github.com/muhammedOzbilici/moviesearch-react


docker run :  

```
docker build -f Dockerfile -t moviesearch .  
docker run -p 8082:8082 moviesearch  
```


![alt text](https://user-images.githubusercontent.com/7340804/67681741-f7db3c80-f99e-11e9-81ad-487f652fed59.png)

Swagger Api  
http://localhost:8082/swagger-ui.html


![alt text](https://user-images.githubusercontent.com/7340804/67681751-fc9ff080-f99e-11e9-89cf-dbbc3126d4ce.png)

