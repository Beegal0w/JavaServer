# Java Server
Basic Java Server and Client

## Description
This project creates a server that a client can connect to. When a client connects, the server sends back three random cards from a list, then disconnects.

## How to Run

1. Open two terminals and navigate to the folder containing the Java files.

2. Compile the code:
javac TarotCardServer.java
javac TarotCardClient.java

3. Start the server:
run 'java TarotCardServer [port]' (default port is 21540)

4. Run the client:
On another terminal, run 'java TarotCardClient [server_ip] [port]' (default server_ip is localhost, default port is 21540)
