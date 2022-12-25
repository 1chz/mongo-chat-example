# Real-time chat server example

This is a simple example of a real-time chat server using Spring Boot and MongoDB and SSE protocol.

## How to run

1. Run the server

```shell
./gradlew bootRun
```

2. Send a message

```shell
curl --location --request POST 'http://localhost:8080/chat' --header 'Content-Type: application/json' --data-raw '{
  "sender": "siro",
  "receiver": "junny",
  "message": "junny is king babo"
}'
```

3. Open the client

open http://localhost:8080/chat/sender/{sender}/receiver/{receiver}

```shell
open http://localhost:8080/chat/sender/siro/receiver/junny
```

4. Continue sending messages...