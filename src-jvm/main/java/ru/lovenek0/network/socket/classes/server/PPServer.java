package ru.lovenek0.network.socket.classes.server;


import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.common.HintType;
import php.runtime.env.Environment;
import php.runtime.ext.core.classes.WrapEnvironment;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseObject;
import php.runtime.memory.ArrayMemory;
import php.runtime.memory.LongMemory;
import php.runtime.memory.ObjectMemory;
import php.runtime.memory.StringMemory;
import php.runtime.reflection.ClassEntity;
import ru.lovenek0.network.PingPongUDP.UDPPacket;
import ru.lovenek0.network.PingPongUDP.server.UDPConnection;
import ru.lovenek0.network.PingPongUDP.server.UDPServer;
import ru.lovenek0.network.PingPongUDP.server.UDPServerListener;
import ru.lovenek0.network.socket.PingPongSocketExtension;
import ru.lovenek0.network.socket.classes.PPPacket;

import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.Arrays;

@Reflection.Name("UDPServer")
@Reflection.Namespace(PingPongSocketExtension.NS + "\\Server")
public class PPServer extends BaseObject {
    public PPServer(Environment env) {
        super(env);
    }
    protected PPServer(ClassEntity entity) {
        super(entity);
    }
    public PPServer(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    private UDPServer server;
    private final Invoker[] callbacks = new Invoker[10];

    public static final int onFailedToStartEvent = 0;
    public static final int onPacketSendEvent = 1;
    public static final int onPacketNotSendEvent = 2;
    public static final int onDisconnectTimeOutEvent = 3;
    public static final int onConnectEvent = 4;
    public static final int onServerDroppedConnectionEvent = 5;
    public static final int onClientDroppedConnectionEvent = 6;
    public static final int onPacketReceivedEvent = 7;
    public static final int onLatePacketReceivedEvent = 8;
    public static final int onPacketReceiveTimedOutEvent = 9;
    public static final int onServerStopEvent = 10;

    private void InitCallbacks(){
        server.setListener(new UDPServerListener() {
            @Override
            public void OnFailedToStartEvent() {
                if(callbacks[onFailedToStartEvent] == null)
                    return;
                callbacks[onFailedToStartEvent].callNoThrow();
            }
            @Override
            public void OnPacketSendEvent(UDPConnection udpConnection, UDPPacket udpPacket) {
                if(callbacks[onPacketSendEvent] == null)
                    return;
                callbacks[onPacketSendEvent].callNoThrow(ObjectMemory.valueOf(
                        new PPConnection(getEnvironment(), udpConnection)),
                        ObjectMemory.valueOf(new PPPacket(getEnvironment(), udpPacket)));
            }
            @Override
            public void OnPacketNotSendEvent(UDPConnection udpConnection, UDPPacket udpPacket) {
                if(callbacks[onPacketNotSendEvent] == null)
                    return;
                callbacks[onPacketNotSendEvent].callNoThrow(ObjectMemory.valueOf(
                                new PPConnection(getEnvironment(), udpConnection)),
                        ObjectMemory.valueOf(new PPPacket(getEnvironment(), udpPacket)));
            }
            @Override
            public void OnDisconnectTimeOutEvent(UDPConnection udpConnection) {
                if(callbacks[onDisconnectTimeOutEvent] == null)
                    return;
                callbacks[onDisconnectTimeOutEvent].callNoThrow(ObjectMemory.valueOf(
                                new PPConnection(getEnvironment(), udpConnection)));
            }
            @Override
            public void OnConnectEvent(UDPConnection udpConnection) {
                if(callbacks[onConnectEvent] == null)
                    return;
                callbacks[onConnectEvent].callNoThrow(ObjectMemory.valueOf(
                                new PPConnection(getEnvironment(), udpConnection)));
            }
            @Override
            public void OnServerDroppedConnectionEvent(UDPConnection udpConnection, UDPPacket udpPacket) {
                if(callbacks[onServerDroppedConnectionEvent] == null)
                    return;
                callbacks[onServerDroppedConnectionEvent].callNoThrow(ObjectMemory.valueOf(
                                new PPConnection(getEnvironment(), udpConnection)),
                        ObjectMemory.valueOf(new PPPacket(getEnvironment(), udpPacket)));
            }
            @Override
            public void OnClientDroppedConnectionEvent(UDPConnection udpConnection, UDPPacket udpPacket) {
                if(callbacks[onClientDroppedConnectionEvent] == null)
                    return;
                callbacks[onClientDroppedConnectionEvent].callNoThrow(ObjectMemory.valueOf(
                                new PPConnection(getEnvironment(), udpConnection)),
                        ObjectMemory.valueOf(new PPPacket(getEnvironment(), udpPacket)));
            }
            @Override
            public void OnPacketReceivedEvent(UDPConnection udpConnection, UDPPacket udpPacket) {
                if(callbacks[onPacketReceivedEvent] == null)
                    return;
                callbacks[onPacketReceivedEvent].callNoThrow(ObjectMemory.valueOf(
                                new PPConnection(getEnvironment(), udpConnection)),
                        ObjectMemory.valueOf(new PPPacket(getEnvironment(), udpPacket)));
            }
            @Override
            public void OnLatePacketReceivedEvent(UDPConnection udpConnection, UDPPacket udpPacket) {
                if(callbacks[onLatePacketReceivedEvent] == null)
                    return;
                callbacks[onLatePacketReceivedEvent].callNoThrow(ObjectMemory.valueOf(
                                new PPConnection(getEnvironment(), udpConnection)),
                        ObjectMemory.valueOf(new PPPacket(getEnvironment(), udpPacket)));
            }
            @Override
            public void OnPacketReceiveTimedOutEvent() {
                if(callbacks[onPacketReceiveTimedOutEvent] == null)
                    return;
                callbacks[onPacketReceiveTimedOutEvent].callNoThrow();
            }
            @Override
            public void OnServerStopEvent() {
                if(callbacks[onServerStopEvent] == null)
                    return;
                callbacks[onServerStopEvent].callNoThrow();
            }
        });
    }

    @Reflection.Signature
    public void __construct(){
        server = new UDPServer();
        Arrays.fill(callbacks, null);
        InitCallbacks();
    }

    @Reflection.Signature
    public void __construct(Memory host, Memory port){
        server = new UDPServer(host.toString(), port.toInteger());
        Arrays.fill(callbacks, null);
        InitCallbacks();
    }

    @Reflection.Signature
    public void bind(Memory host, Memory port){
        server.bind(host.toString(), port.toInteger());
    }

    @Reflection.Signature
    public void start(){
        server.start();
    }

    @Reflection.Signature
    public void stop(){
        server.stop();
    }

    @Reflection.Signature
    public void setDisconnectTimeout(Memory timeoutMS){
        server.setDisconnectTimeout(timeoutMS.toInteger());
    }

    @Reflection.Signature
    public Memory getDisconnectTimeout(){
        return LongMemory.valueOf(server.getDisconnectTimeout());
    }

    @Reflection.Signature
    public void setReceiveTimeout(Memory timeoutMS){
        server.setReceiveTimeout(timeoutMS.toInteger());
    }

    @Reflection.Signature
    public Memory getReceiveTimeout(){
        return LongMemory.valueOf(server.getReceiveTimeout());
    }

    @Reflection.Signature
    public Memory getConnections(){
        ArrayMemory connections = new ArrayMemory();
        for(UDPConnection connection : server.getConnections())
            connections.add(ObjectMemory.valueOf(new PPConnection(getEnvironment(), connection)));
        return connections;
    }

    @Reflection.Signature({
            @Reflection.Arg(value = "type", type = HintType.INT),
            @Reflection.Arg(value = "runnable", type = HintType.CALLABLE)
    })
    public Memory setListener(Environment env, Memory... args){
        if(args[1].isNull())
            return Memory.FALSE;

        final Invoker invoker = Invoker.valueOf(env, null, args[1]);

        int id = args[0].toInteger();
        if(id < 0 || id >= callbacks.length)
            return Memory.FALSE;

        this.callbacks[id] = invoker;
        return Memory.TRUE;
    }
}
