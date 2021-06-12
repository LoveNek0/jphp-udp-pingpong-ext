# UDPConnection

- **class** `UDPConnection` (`Network\UDPSocket\UDPConnection`)
- **source** `Network/UDPSocket/UDPConnection.php`

---

#### Methods

- `->`[`__construct()`](#method-__construct) - _UDPConnection constructor._
- `->`[`sendData()`](#method-senddata) - _Send data to client_
- `->`[`disconnect()`](#method-disconnect) - _Disconnect client from server_
- `->`[`getHost()`](#method-gethost) - _Get client host_
- `->`[`getPort()`](#method-getport) - _Get client port_
- `->`[`getAddress()`](#method-getaddress) - _Get client address_
- `->`[`getPing()`](#method-getping) - _Get client ping_
- `->`[`getLost()`](#method-getlost) - _Get client lost packets_

---
# Methods

<a name="method-__construct"></a>

### __construct()
```php
__construct(string $host, int $port): void
```
UDPConnection constructor.

---

<a name="method-senddata"></a>

### sendData()
```php
sendData(string $data): void
```
Send data to client

---

<a name="method-disconnect"></a>

### disconnect()
```php
disconnect(): void
```
Disconnect client from server

---

<a name="method-gethost"></a>

### getHost()
```php
getHost(): string
```
Get client host

---

<a name="method-getport"></a>

### getPort()
```php
getPort(): int
```
Get client port

---

<a name="method-getaddress"></a>

### getAddress()
```php
getAddress(): string
```
Get client address

---

<a name="method-getping"></a>

### getPing()
```php
getPing(): int
```
Get client ping

---

<a name="method-getlost"></a>

### getLost()
```php
getLost(): int
```
Get client lost packets