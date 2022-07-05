# To StartUp application

1. Open terminal in project folder
2. Go to `distrib` folder
3. create volume for persistent `docker volume create -d local postgres-local-volume-message-kata`
4. run `docker-compose up` command
5. Go to project folder
6. `./gradlew clean build bootRun`

# Clean up

1. run `docker-compose down` command
2. remove volume `docker volume rm postgres-local-volume-message-kata`
3. run `docker-compose down`

# To see messages in queue 
1. Go to the page `http://localhost:15672/`
2. Default rabbitMQ log/pass (guest/guest) 

# For manual testing 
see the postman collection visible.postman_collection.json

# Further enchantments
1. More tests
2. Prometheus/Grafana for monitoring
3. Proper error handling for constraints (see ExceptionHandlingController for handling example)
4. Endpoints could use some requests with validation
5. Maybe further explore ManyToOne and OneToMany type of relationship in User-Message (depends on further tasks)
6. Add logger
7. Profiling for test (h2 db), dev, prod