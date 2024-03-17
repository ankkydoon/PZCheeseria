### PZ Cheeseria

#Tech Stack->

1. Front End - React JS , Axios , Jest

2. Back End - Springboot Java 17 , Junit test , Mockito 

3. Docker - Multi Stage Pipeline

4. DB - MySQL

#Pipeline->
Docker compose contains multi stage pipeline to build, test and run the application

#How to run the application from parent folder?

docker-compose up --build -d

#Application Uri->

http://localhost:3000/

##Caveat->
The springboot container sometimes fail due to network issue with mysql container. in such case, kindly restart the springboot container.





