<?php

namespace Network\UDPSocket;

class UDPPacket{
    /**
     * UDPPacket constructor.
     * @param int $id Packet id
     * @param string $data Packet data
     */
    public function __construct(int $id, string $data){}

    /**
     * Get packet data
     * @return string
     */
    public function getData(): string{}

    /**
     * Get packet id
     * @return int
     */
    public function getID(): int{}
}