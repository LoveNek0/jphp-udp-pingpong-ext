# UDP Client-Server API
## Описание
API для приложений, использующих UDP соединение типа Пинг-Понг

## Установка
```
jppm add jphp-udp-pingpong-ext@0.9.0
```

## Сборка и добавление в локальный репозиторий
```
jppm publish
```

## Примеры
### Сервер
#### Создание и запуск сервера
```php
// Первый вариант (адрес и порт по умолчанию: 127.0.0.1:20019)
$server = new UDPServer();
$server->run();

// Второй вариант (адрес и порт при создании объекта)
$server = new UDPServer("192.168.1.2", 25565);
$server->run();


// Третий вариант (адрес и порт заменяются перед запуском)
$server = new UDPServer("192.168.1.2", 25565);
$server->bind("192.168.1.2", 25565);
$server->run();
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
Автор: [LoveNek0](https://t.me/lovenek0)