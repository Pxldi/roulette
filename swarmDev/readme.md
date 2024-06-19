## Start Application Without Docker

WSL 

Go to directory with `build.sbt`

Start Frontend and Backend:

`sbt "runMain Roulette.controller.ControllerApi"`

`sbt "runMain TuiClient"`

Place a Bet:

`bet 1 e e 13`

`d`


## API Endpoints
```bash
curl -X POST http://localhost:8080/roulette/setupPlayers
curl -X GET http://localhost:8080/roulette/getResult
curl -X POST http://localhost:8080/roulette/save
curl -X POST http://localhost:8080/roulette/load
curl -X POST http://localhost:8080/roulette/saveDB
curl -X POST http://localhost:8080/roulette/loadDB
curl -X POST http://localhost:8080/roulette/undo
curl -X POST http://localhost:8080/roulette/redo
```



## Docker Swarm

Go to Directory /swarmDev

### Init New Docker Swarm Stack
`docker swarm init`

### Create New Docker Images
#### Backend:

`docker-compose -f ./backendDeployment.yaml build`

`docker push nielshen/roulette:backend-latest`

#### Frontend:

`docker-compose -f ./frontendDeployment.yaml build`

`docker push nielshen/roulette:frontend-latest`

### Apply New Docker Images
`docker stack deploy -c docker-compose.yml meinStack`

### Show Pods Inside Docker-Swarm
`docker service ls`

`docker stack services meinStack`

### Remove Docker-Swarm Stack
`docker stack rm meinStack`



## Test Frontend, Database, Kafka Inside Docker

#### Frontend
`docker exec -it <container id Frontend> bash`

`bet 1 e e 13`

`d`

#### Backend
`docker attach <container id Backend> `

detach: CTRL + q

#### PostgreSQL:
use db-client container:
`docker exec -it <container ID Ubuntu db-client> bash`

`apt-get update && apt-get install curl -y`

`curl -X POST http://roulette-backend:8080/roulette/saveDB`

`psql -h postgres -U roulette_user -d roulette`

Password: `roulette_pass`

`\dt`

`SELECT * FROM players;`

`DELETE FROM players;`


#### MongoDB:
##### Test DB Connection
use db-client container:
`docker exec -it <container ID Ubuntu db-client> bash`

(mongo mongodb://mongo:27017/roulette)

`mongo mongodb://mongo:27017`

`show collections;`

`db.test.insert({name: "test"});`

`db.test.find();`



##### Test DB Insertion From Frontend

`docker exec -it <MongoDB container> bash`

`apt-get update`
`apt-get install -y mongodb-mongosh`

`mongosh`

`show dbs`

`use roulette`

`show collections`

`db.players.find()`



#### Test Database from outside e.g for Gatling:

`curl -X POST localhost:8080/roulette/saveDB`

#### Kafka:
`docker exec -it <container id kafka container> bash`

`kafka-console-producer.sh --broker-list kafka:9092 --topic test`

send message e.g "test"