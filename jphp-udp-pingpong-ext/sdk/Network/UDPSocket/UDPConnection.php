<?php

namespace Network\UDPSocket;

class UDPConnection{
    /**
     * UDPConnection constructor.
     * @param string $host Client host
     * @param int $port Client port
     */
    public function __construct(string $host, int $port){}

    /**
     * Send data to client
     * @param string $data
     */
    public function sendData(string $data){}

    /**
     * Disconnect client from server
     */
    public function disconnect(){}

    /**
     * Get client host
     * @return string
     */
    public function getHost(): string{}

    /**
     * Get client port
     * @return int
     */
    public function getPort(): int{}

    /**
     * Get client address
     * @return string
     */
    public function getAddress(): string{}

    /**
     * Get client ping
     * @return int
     */
    public function getPing(): int{}

    /**
     * Get client lost packets
     * @return int
     */
    public function getLost(): int{}
}