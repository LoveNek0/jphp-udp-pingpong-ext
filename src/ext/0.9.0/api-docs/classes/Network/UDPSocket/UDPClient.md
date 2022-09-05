# UDPClient

- **class** `UDPClient` (`Network\UDPSocket\UDPClient`)
- **source** `Network/UDPSocket/UDPClient.php`

---

#### Methods

- `->`[`__construct()`](#method-__construct) - _UDPClient constructor._
- `->`[`disconnect()`](#method-disconnect) - _Disconnect from server_
- `->`[`sendData()`](#method-senddata) - _Send data to server_
- `->`[`setMaxPacketSize()`](#method-setmaxpacketsize) - _Set maximum size of packet_
- `->`[`getMaxPacketSize()`](#method-getmaxpacketsize) - _Get maximum size of packet_
- `->`[`setListener()`](#method-setlistener) - _Set handler for events listener_
- `->`[`setDisconnectTimeout()`](#method-setdisconnecttimeout) - _Set timeout for disconnecting_
- `->`[`getDisconnectTimeout()`](#method-getdisconnecttimeout) - _Get timeout for disconnecting_
- `->`[`setReceiveTimeout()`](#method-setreceivetimeout) - _Set timeout for receiving_
- `->`[`getReceiveTimeout()`](#method-getreceivetimeout) - _Get timeout for receiving_
- `->`[`getPing()`](#method-getping) - _Get ping_
- `->`[`getLost()`](#method-getlost) - _Get lost packets_

---
# Methods

<a name="method-__construct"></a>

### __construct()
```php
__construct(): void
```
UDPClient constructor.

---

<a name="method-disconnect"></a>

### disconnect()
```php
disconnect(): void
```
Disconnect from server

---

<a name="method-senddata"></a>

### sendData()
```php
sendData(string $data): void
```
Send data to server

---

<a name="method-setmaxpacketsize"></a>

### setMaxPacketSize()
```php
setMaxPacketSize(int $size): void
```
Set maximum size of packet

---

<a name="method-getmaxpacketsize"></a>

### getMaxPacketSize()
```php
getMaxPacketSize(): int
```
Get maximum size of packet

---

<a name="method-setlistener"></a>

### setListener()
```php
setListener(int $type, callable $callback, php\lang\Environment $env): void
```
Set handler for events listener

---

<a name="method-setdisconnecttimeout"></a>

### setDisconnectTimeout()
```php
setDisconnectTimeout(int $timeoutMS): void
```
Set timeout for disconnecting

---

<a name="method-getdisconnecttimeout"></a>

### getDisconnectTimeout()
```php
getDisconnectTimeout(): int
```
Get timeout for disconnecting

---

<a name="method-setreceivetimeout"></a>

### setReceiveTimeout()
```php
setReceiveTimeout(int $timeoutMS): void
```
Set timeout for receiving

---

<a name="method-getreceivetimeout"></a>

### getReceiveTimeout()
```php
getReceiveTimeout(): int
```
Get timeout for receiving

---

<a name="method-getping"></a>

### getPing()
```php
getPing(): int
```
Get ping

---

<a name="method-getlost"></a>

### getLost()
```php
getLost(): int
```
Get lost packets