<?php

namespace Network\UDPSocket;

use php\lang\Environment;
use UDPConnection;

class UDPServer{
    const onConnect = 0;
    const onPacketReceive = 1;
    const onDisconnectTimeout = 2;
    const onPacketNotSend = 3;
    const onPacketSend = 4;
    const onPacketReceiveTimeout = 5;
    const onPacketArrivedLate = 6;
    const onServerDisconnect = 7;
    const onClientDisconnect = 8;
    const onFailedToStart = 9;

    /**
     * UDPServer constructor.
     * @param string $host Server host
     * @param int $memory Server port
     */
    public function __construct(string $host = "127.0.0.1", int $memory = 20019){}

    /**
     * Bind server address
     * @param string $host Server host
     * @param int $memory Server port
     */
    public function bind(string $host, int $memory){}

    /**
     * Run server
     */
    public function run(){}

    /**
     * Set timeout for clients disconnecting
     * @param int $timeoutMS
     */
    public function setDisconnectTimeout(int $timeoutMS){}

    /**
     * Get timeout for clients disconnecting
     * @return int
     */
    public function getDisconnectTimeout(): int{}

    /**
     * Set timeout for packets receiving
     * @param int $timeoutMS
     */
    public function setReceiveTimeout(int $timeoutMS){}

    /**
     * Get timeout for packets receiving
     * @return int
     */
    public function getReceiveTimeout(): int{}

    /**
     * Get server clients
     * @return UDPConnection[]
     */
    public function getConnections(): array{}

    /**
     * Send packet to connection
     * @param UDPConnection $connection
     * @param UDPPacket $packet
     */
    public function sendPacket(UDPConnection $connection, UDPPacket $packet){}

    /**
     * Set handlers for events
     * @param int $type Event
     * @param callable $callback Handler
     * @param Environment $env Environment
     */
    public function setListener(int $type, callable $callback, Environment $env = null){}
}