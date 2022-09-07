<?php

namespace Network\PPSocket\Client;

use Network\PPSocket\UDPPacket;
use php\lang\Environment;

class UDPClient{
    const onIncorrectHostnameEvent = 0;
    const onFailedToConnectEvent = 1;
    const onPacketNotSendEvent = 2;
    const onDisconnectTimeOutEvent = 3;
    const onPacketSendEvent = 4;
    const onServerDroppedConnectionEvent = 5;
    const onClientDroppedConnectionEvent = 6;
    const onPacketReceivedEvent = 7;
    const onLatePacketReceivedEvent = 8;
    const onPacketReceiveTimedOutEvent = 9;

    /**
     * UDPClient constructor.
     */
    public function __construct(){}

    /**
     * Connect to server
     * @param string $host
     * @param int $port
     */
    public function connect(string $host, int $port){}

    /**
     * Disconnect from server
     */
    public function disconnect(){}

    /**
     * Send data to server
     * @param string $data
     */
    public function sendData(string $data){}

    /**
     * Check is client connected to server
     * @return bool
     */
    public function isConnected(): bool{}

    /**
     * Set maximum size of packet
     * @param int $size
     */
    public function setPacketSize(int $size){}

    /**
     * Get maximum size of packet
     * @return int
     */
    public function getPacketSize(): int{}

    /**
     * Set handler for events listener
     * @param int $type
     * @param callable $callback
     */
    public function setListener(int $type, callable $callback){}

    /**
     * Set timeout for disconnecting
     * @param int $timeoutMS
     */
    public function setDisconnectTimeout(int $timeoutMS){}

    /**
     * Get timeout for disconnecting
     * @return int
     */
    public function getDisconnectTimeout(): int{}

    /**
     * Set timeout for receiving
     * @param int $timeoutMS
     */
    public function setReceiveTimeout(int $timeoutMS){}

    /**
     * Get timeout for receiving
     * @return int
     */
    public function getReceiveTimeout(): int{}

    /**
     * Get ping
     * @return int
     */
    public function getPing(): int{}

    /**
     * Get lost packets
     * @return int
     */
    public function getLost(): int{}
}
