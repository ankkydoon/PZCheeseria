### PZ Cheeseria

Front End - React JS , Axios 
Back End - Springboot Java , Junit test , Mockito 
Docker - Multi Stage Pipeline
DB - MySQL

Pipeline->
Docker compose contains multi stage pipeline to build, test and run the application

How to run the application from parent folder?
docker-compose up --build -d

Caveat->
The springboot container sometimes fail due to network issue with mysql container. in such case, kindly restart the springboot container.





