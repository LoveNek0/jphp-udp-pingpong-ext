<?php

namespace Network\PPSocket\Server;

use php\lang\Environment;
use Network\PPSocket\Server\UDPConnection;
use Network\PPSocket\UDPPacket;

class UDPServer{
    const onFailedToStartEvent = 0;
    const onPacketSendEvent = 1;
    const onPacketNotSendEvent = 2;
    const onDisconnectTimeOutEvent = 3;
    const onConnectEvent = 4;
    const onServerDroppedConnectionEvent = 5;
    const onClientDroppedConnectionEvent = 6;
    const onPacketReceivedEvent = 7;
    const onLatePacketReceivedEvent = 8;
    const onPacketReceiveTimedOutEvent = 9;
    const onServerStopEvent = 10;

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
     * Start server
     */
    public function start(){}
	
    /**
     * Stop server
     */
    public function stop(){}

    /**
     * Set packet size
     * @param int $timeoutMS
     */
    public function setPacketSize(int $timeoutMS){}

    /**
     * Get packet size
     * @return int
     */
    public function getPacketSize(): int{}

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
     * Set async status
     * @param bool $status
     */
    public function setAsync(bool $status){}

    /**
     * Check is async server
     * @return bool
     */
     public function isAsync() : bool{}

    /**
     * Set handlers for events
     * @param int $type Event
     * @param callable $callback Handler
     * @param Environment $env Environment
     */
    public function setListener(int $type, callable $callback, Environment $env = null){}
}
