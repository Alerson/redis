# Redis

SpringBoot redis application

In this Application we are using HashOperation.
We can manage redis hash values using the HashOperations helper class.

![img_4.png](img_4.png)

HashOperations have put(), get(), entries(), values, and delete etc. as basic hash map operations to operate with redis hash key values.

To run application, execute the following steps.
1. Run docker file in application root directory.
> docker-compose up -d
2. Start the Spring Boot Application running main class.

3. Save(POST) item in Redis database.

![img_1.png](img_1.png)
4. (GET) all data from Redis database.

![img.png](img.png)
5. (GET) data by ID from Redis database.

![img_2.png](img_2.png)
6. (DELETE) data by ID from Redis database.

![img_3.png](img_3.png)