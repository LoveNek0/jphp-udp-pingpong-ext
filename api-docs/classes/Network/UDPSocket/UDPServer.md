# UDPServer

- **class** `UDPServer` (`Network\UDPSocket\UDPServer`)
- **source** `Network/UDPSocket/UDPServer.php`

---

#### Methods

- `->`[`__construct()`](#method-__construct) - _UDPServer constructor._
- `->`[`bind()`](#method-bind) - _Bind server address_
- `->`[`run()`](#method-run) - _Run server_
- `->`[`setDisconnectTimeout()`](#method-setdisconnecttimeout) - _Set timeout for clients disconnecting_
- `->`[`getDisconnectTimeout()`](#method-getdisconnecttimeout) - _Get timeout for clients disconnecting_
- `->`[`setReceiveTimeout()`](#method-setreceivetimeout) - _Set timeout for packets receiving_
- `->`[`getReceiveTimeout()`](#method-getreceivetimeout) - _Get timeout for packets receiving_
- `->`[`getConnections()`](#method-getconnections) - _Get server clients_
- `->`[`sendPacket()`](#method-sendpacket) - _Send packet to connection_
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

<a name="method-run"></a>

### run()
```php
run(): void
```
Run server

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

<a name="method-sendpacket"></a>

### sendPacket()
```php
sendPacket(UDPConnection $connection, Network\UDPSocket\UDPPacket $packet): void
```
Send packet to connection

---

<a name="method-setlistener"></a>

### setListener()
```php
setListener(int $type, callable $callback, php\lang\Environment $env): void
```
Set handlers for events