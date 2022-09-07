# UDPServer

- **class** `UDPServer` (`Network\PPSocket\Server\UDPServer`)
- **source** `Network/PPSocket/Server/UDPServer.php`

---

#### Methods

- `->`[`__construct()`](#method-__construct) - _UDPServer constructor._
- `->`[`bind()`](#method-bind) - _Bind server address_
- `->`[`start()`](#method-start) - _Start server_
- `->`[`stop()`](#method-stop) - _Stop server_
- `->`[`setPacketSize()`](#method-setpacketsize) - _Set packet size_
- `->`[`getPacketSize()`](#method-getpacketsize) - _Get packet size_
- `->`[`setDisconnectTimeout()`](#method-setdisconnecttimeout) - _Set timeout for clients disconnecting_
- `->`[`getDisconnectTimeout()`](#method-getdisconnecttimeout) - _Get timeout for clients disconnecting_
- `->`[`setReceiveTimeout()`](#method-setreceivetimeout) - _Set timeout for packets receiving_
- `->`[`getReceiveTimeout()`](#method-getreceivetimeout) - _Get timeout for packets receiving_
- `->`[`getConnections()`](#method-getconnections) - _Get server clients_
- `->`[`setAsync()`](#method-setasync) - _Set async status_
- `->`[`isAsync()`](#method-isasync) - _Check is async server_
- `->`[`setListener()`](#method-setlistener) - _Set handlers for events_

---
# Methods

<a name="method-__construct"></a>

### __construct()
```php
__construct(string $host, int $memory): void
```
UDPServer constructor.

---

<a name="method-bind"></a>

### bind()
```php
bind(string $host, int $memory): void
```
Bind server address

---

<a name="method-start"></a>

### start()
```php
start(): void
```
Start server

---

<a name="method-stop"></a>

### stop()
```php
stop(): void
```
Stop server

---

<a name="method-setpacketsize"></a>

### setPacketSize()
```php
setPacketSize(int $timeoutMS): void
```
Set packet size

---

<a name="method-getpacketsize"></a>

### getPacketSize()
```php
getPacketSize(): int
```
Get packet size

---

<a name="method-setdisconnecttimeout"></a>

### setDisconnectTimeout()
```php
setDisconnectTimeout(int $timeoutMS): void
```
Set timeout for clients disconnecting

---

<a name="method-getdisconnecttimeout"></a>

### getDisconnectTimeout()
```php
getDisconnectTimeout(): int
```
Get timeout for clients disconnecting

---

<a name="method-setreceivetimeout"></a>

### setReceiveTimeout()
```php
setReceiveTimeout(int $timeoutMS): void
```
Set timeout for packets receiving

---

<a name="method-getreceivetimeout"></a>

### getReceiveTimeout()
```php
getReceiveTimeout(): int
```
Get timeout for packets receiving

---

<a name="method-getconnections"></a>

### getConnections()
```php
getConnections(): UDPConnection[]
```
Get server clients

---

<a name="method-setasync"></a>

### setAsync()
```php
setAsync(bool $status): void
```
Set async status

---

<a name="method-isasync"></a>

### isAsync()
```php
isAsync(): bool
```
Check is async server

---

<a name="method-setlistener"></a>

### setListener()
```php
setListener(int $type, callable $callback): void
```
Set handlers for events