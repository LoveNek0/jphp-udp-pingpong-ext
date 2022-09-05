# UDP Client-Server API
## Description
API for applications using a UDP Ping-Pong connection

## Installation
```
jppm add jphp-udp-pingpong-ext@0.9.0
```

## Build and add to local repository
```
jppm publish
```

## Examples
### Server
#### Server creation and launch
```php
// First option (default address and port: 127.0.0.1:20019)
$server = new UDPServer();
$server->run();

// Second option (address and port when creating an object)
$server = new UDPServer("192.168.1.2", 25565);
$server->run();


// Third option (address and port are replaced before launch)
$server = new UDPServer("192.168.1.2", 25565);
$server->bind("192.168.1.2", 25565);
$server->run();
```
#### Using timeouts
```php
// Packet receiving timeout (milliseconds)
// Recommended value 100-200
$server->setReceiveTimeout(200);

// Client disconnect timeout (milliseconds)
$server->setDisconnectTimeout(5000);
```

#### Installing an event handler
```php
$server->setListener(UDPServer::onPacketReceive, function (UDPConnection $connection, UDPPacket $packet){
     if($packet->getData() != ""){
         echo "Packet receiving from " . $connection->getAddress() . "\n";
         echo "Data: " . $packet->getData() . "\n";
     }
 });
```

#### Actions with clients
```php
// Get all clients
$connections = $server->getConnections();

// Get the first client from the list
$connection = $connections[0];

// Send a message to the client
$connection->sendData("Hello!");

// Disconnect client
$connection->disconnect();
```

### Client
#### Create client, connect to server and disconnect
```php
$client = new UDPClient();
$client->connect("192.168.1.2", 25565);
$client->disconnect();
```

#### Sending a message to the server
```php
$client->sendData("hello, buddy!");
```

#### Using timeouts
```php
// Packet receiving timeout (milliseconds)
// Recommended value 100-200
$client->setReceiveTimeout(200);

// Timeout for disconnecting from the server (milliseconds)
$client->setDisconnectTimeout(5000);
```

#### Installing an event handler
```php
$client->setListener(UDPServer::onPacketReceive, function (UDPPacket $packet){
    if($packet->getData() != ""){
        echo "Data: " . $packet->getData() . "\n";
    }
});
```

## Additionally
Author: [LoveNek0](https://t.me/lovenek0)