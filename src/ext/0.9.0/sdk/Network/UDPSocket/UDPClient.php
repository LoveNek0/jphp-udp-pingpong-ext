<?php

namespace Network\UDPSocket;

use php\lang\Environment;

class UDPClient{
    const onPacketNotSend = 0;
    const onPacketSend = 1;
    const onPacketReceiveTimeout = 2;
    const onPacketReceive = 3;
    const onPacketArrivedLate = 4;
    const onDisconnectTimeout = 5;
    const onClientDisconnect = 6;
    const onServerDisconnect = 7;
    const onConnect = 8;
    const onFailedToConnect = 9;

    /**
     * UDPClient constructor.
     */
    public function __construct(){}

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
     * Set maximum size of packet
     * @param int $size
     */
    public function setMaxPacketSize(int $size){}

    /**
     * Get maximum size of packet
     * @return int
     */
    public function getMaxPacketSize(): int{}

    /**
     * Set handler for events listener
     * @param int $type
     * @param callable $callback
     * @param Environment|null $env
     */
    public function setListener(int $type, callable $callback, Environment $env = null){}

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