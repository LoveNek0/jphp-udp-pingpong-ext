## Примеры
### Сервер
#### Создание и запуск сервера
```php
// Первый вариант (адрес и порт по умолчанию: 127.0.0.1:20019)
$server = new UDPServer();
$server->start();

// Второй вариант (адрес и порт при создании объекта)
$server = new UDPServer("192.168.1.2", 25565);
$server->start();


// Третий вариант (адрес и порт заменяются перед запуском)
$server = new UDPServer("192.168.1.2", 25565);
$server->bind("192.168.1.2", 25565);
$server->start();
```

#### Асинхронный запуск сервера
```php
$server = new UDPServer();
$server->setAsync(true);
$server->start();
echo "Message after start";
```

#### Использование таймаутов
```php
// Таймаут ожидания пакета (миллисекунды)
// Рекомендуется значение 100-200
$server->setReceiveTimeout(200);

// Таймаут отключения клиента (миллисекунды)
$server->setDisconnectTimeout(5000);
```

#### Установка обработчика событий
```php
$server->setListener(UDPServer::onPacketReceive, function (UDPConnection $connection, UDPPacket $packet){
     if($packet->getData() != ""){
         echo "Packet receiving from " . $connection->getAddress() . "\n";
         echo "Data: " . $packet->getData() . "\n";
     }
 });
```

#### Действия с клиентами
```php
// Получить всех клиентов
$connections = $server->getConnections();

// Получить первого клиента из списка
$connection = $connections[0];

// Отправить клиенту сообщение
$connection->sendData("Hello!");

// Отключить клиента
$connection->disconnect();
```

### Клиент
#### Создание клиента, подключение к серверу и отключение
```php
$client = new UDPClient();
$client->connect("192.168.1.2", 25565);
$client->disconnect();
```

#### Отправка сообщения серверу
```php
$client->sendData("hello, buddy!");
```

#### Использование таймаутов
```php
// Таймаут ожидания пакета (миллисекунды)
// Рекомендуется значение 100-200
$client->setReceiveTimeout(200);

// Таймаут отключения от сервера (миллисекунды)
$client->setDisconnectTimeout(5000);
```

#### Установка обработчика событий
```php
$client->setListener(UDPServer::onPacketReceive, function (UDPPacket $packet){
    if($packet->getData() != ""){
        echo "Data: " . $packet->getData() . "\n";
    }
});
```

## Дополнительно
Автор: [LoveNek0](https://github.com/lovenek0)
