## Examples
### Server
#### Create and start the server
```php
// First option (default address and port: 127.0.0.1:20019)
$server = new UDPServer();
$server->start();

// Second option (address and port when creating an object)
$server = new UDPServer("192.168.1.2", 25565);
$server->start();


// Third option (address and port are replaced before launch)
$server = new UDPServer("192.168.1.2", 25565);
$server->bind("192.168.1.2", 25565);
$server->start();
```

#### Starting the server async
```php
$server = new UDPServer();
$server->setAsync(true);
$server->start();
echo "Message after start";
```

#### Using timeouts
```php
// Packet timeout (milliseconds)
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

#### Send message to server
```php
$client->sendData("hello, buddy!");
```

#### Using timeouts
```php
// Packet timeout (milliseconds)
// Recommended value 100-200
$client->setReceiveTimeout(200);

// Server disconnect timeout (milliseconds)
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

## Other
Author: [LoveNek0](https://github.com/lovenek0)