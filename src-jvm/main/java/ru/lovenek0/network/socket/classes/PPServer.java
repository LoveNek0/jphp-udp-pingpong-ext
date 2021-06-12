package ru.lovenek0.network.socket.classes;


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
import ru.lovenek0.UDPConnection;
import ru.lovenek0.UDPPacket;
import ru.lovenek0.UDPServer;
import ru.lovenek0.UDPServerListener;
import ru.lovenek0.network.socket.JphpUdpPingpongExtExtension;

import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.Arrays;

@Reflection.Name("UDPServer")
@Reflection.Namespace(JphpUdpPingpongExtExtension.NS)
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
    private Invoker[] callbacks = new Invoker[10];

    public static final int onConnect = 0;
    public static final int onPacketReceive = 1;
    public static final int onDisconnectTimeout = 2;
    public static final int onPacketNotSend = 3;
    public static final int onPacketSend = 4;
    public static final int onPacketReceiveTimeout = 5;
    public static final int onPacketArrivedLate = 6;
    public static final int onServerDisconnect = 7;
    public static final int onClientDisconnect = 8;
    public static final int onFailedToStart = 9;

    private void InitCallbacks(){
        server.SetListener(new UDPServerListener() {
            @Override
            public void OnConnect(UDPConnection udpConnection) {
                if(callbacks[onConnect] == null)
                    return;
                PPConnection ppConnection = new PPConnection(getEnvironment());
                ppConnection.connection = udpConnection;
                callbacks[onConnect].callNoThrow(ObjectMemory.valueOf(ppConnection));
            }

            @Override
            public void OnPacketReceive(UDPConnection udpConnection, UDPPacket udpPacket) {
                if(callbacks[onPacketReceive] == null)
                    return;
                PPConnection ppConnection = new PPConnection(getEnvironment());
                ppConnection.connection = udpConnection;
                PPPacket ppPacket = new PPPacket(getEnvironment());
                ppPacket.packet = udpPacket;
                callbacks[onPacketReceive].callNoThrow(ObjectMemory.valueOf(ppConnection), ObjectMemory.valueOf(ppPacket));
            }

            @Override
            public void OnDisconnectTimeout(UDPConnection udpConnection) {
                if(callbacks[onDisconnectTimeout] == null)
                    return;
                PPConnection ppConnection = new PPConnection(getEnvironment());
                ppConnection.connection = udpConnection;
                callbacks[onDisconnectTimeout].callNoThrow(ObjectMemory.valueOf(ppConnection));
            }

            @Override
            public void OnPacketNotSend(UDPConnection udpConnection, UDPPacket udpPacket) {
                if(callbacks[onPacketNotSend] == null)
                    return;
                PPConnection ppConnection = new PPConnection(getEnvironment());
                ppConnection.connection = udpConnection;
                PPPacket ppPacket = new PPPacket(getEnvironment());
                ppPacket.packet = udpPacket;
                callbacks[onPacketNotSend].callNoThrow(ObjectMemory.valueOf(ppConnection), ObjectMemory.valueOf(ppPacket));
            }

            @Override
            public void OnPacketSend(UDPConnection udpConnection, UDPPacket udpPacket) {
                if(callbacks[onPacketSend] == null)
                    return;
                PPConnection ppConnection = new PPConnection(getEnvironment());
                ppConnection.connection = udpConnection;
                PPPacket ppPacket = new PPPacket(getEnvironment());
                ppPacket.packet = udpPacket;
                callbacks[onPacketSend].callNoThrow(ObjectMemory.valueOf(ppConnection), ObjectMemory.valueOf(ppPacket));
            }

            @Override
            public void OnPacketReceiveTimeout() {
                if(callbacks[onPacketReceiveTimeout] == null)
                    return;
                callbacks[onPacketReceiveTimeout].callNoThrow();
            }

            @Override
            public void OnPacketArrivedLate(UDPConnection udpConnection, UDPPacket udpPacket) {
                if(callbacks[onPacketArrivedLate] == null)
                    return;
                PPConnection ppConnection = new PPConnection(getEnvironment());
                ppConnection.connection = udpConnection;
                PPPacket ppPacket = new PPPacket(getEnvironment());
                ppPacket.packet = udpPacket;
                callbacks[onPacketArrivedLate].callNoThrow(ObjectMemory.valueOf(ppConnection), ObjectMemory.valueOf(ppPacket));
            }

            @Override
            public void OnServerDisconnect(UDPConnection udpConnection, UDPPacket udpPacket) {
                if(callbacks[onServerDisconnect] == null)
                    return;
                PPConnection ppConnection = new PPConnection(getEnvironment());
                ppConnection.connection = udpConnection;
                PPPacket ppPacket = new PPPacket(getEnvironment());
                ppPacket.packet = udpPacket;
                callbacks[onServerDisconnect].callNoThrow(ObjectMemory.valueOf(ppConnection), ObjectMemory.valueOf(ppPacket));
            }

            @Override
            public void OnClientDisconnect(UDPConnection udpConnection, UDPPacket udpPacket) {
                if(callbacks[onClientDisconnect] == null)
                    return;
                PPConnection ppConnection = new PPConnection(getEnvironment());
                ppConnection.connection = udpConnection;
                PPPacket ppPacket = new PPPacket(getEnvironment());
                ppPacket.packet = udpPacket;
                callbacks[onClientDisconnect].callNoThrow(ObjectMemory.valueOf(ppConnection), ObjectMemory.valueOf(ppPacket));
            }

            @Override
            public void OnDatagramReceive(UDPConnection udpConnection, DatagramPacket datagramPacket) {}

            @Override
            public void OnFailedToStart(Exception e, String host, int port) {
                if(callbacks[onFailedToStart] == null)
                    return;
                callbacks[onFailedToStart].callNoThrow(StringMemory.valueOf(host), LongMemory.valueOf(port));
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
        server.Bind(host.toString(), port.toInteger());
    }

    @Reflection.Signature
    public void run(){
        server.Run();
    }

    @Reflection.Signature
    public void setDisconnectTimeout(Memory timeoutMS){
        server.SetDisconnectTimeout(timeoutMS.toLong());
    }

    @Reflection.Signature
    public Memory getDisconnectTimeout(){
        return LongMemory.valueOf(server.GetDisconnectTimeout());
    }

    @Reflection.Signature
    public void setReceiveTimeout(Memory timeoutMS){
        server.SetReceiveTimeout(timeoutMS.toInteger());
    }

    @Reflection.Signature
    public Memory getReceiveTimeout(){
        return LongMemory.valueOf(server.GetReceiveTimeout());
    }

    @Reflection.Signature
    public Memory getConnections(){
        ArrayList<UDPConnection> connections = server.GetConnections();
        ArrayMemory result = new ArrayMemory();
        for(UDPConnection connection : connections){
            PPConnection ppConnection = new PPConnection(getEnvironment());
            ppConnection.connection = connection;
            result.add(ObjectMemory.valueOf(ppConnection));
        }
        return result;
    }

    @Reflection.Signature
    public void sendPacket(Memory connection, Memory packet){
        server.SendPacket(connection.toObject(PPConnection.class).connection, packet.toObject(PPPacket.class).packet);
    }

    @Reflection.Signature({
            @Reflection.Arg(value = "type", type = HintType.INT),
            @Reflection.Arg(value = "runnable", type = HintType.CALLABLE),
            @Reflection.Arg(value = "env", typeClass = "php\\lang\\Environment", optional = @Reflection.Optional("NULL"))
    })
    public Memory setListener(Environment env, Memory... args){
        Environment _env = args[2].isNull()
                ? env
                : args[2].toObject(WrapEnvironment.class).getWrapEnvironment();
        if(args[1].isNull())
            return Memory.FALSE;

        final Invoker invoker = Invoker.valueOf(_env, null, args[1]);

        int id = args[0].toInteger();
        if(id < 0 || id >= callbacks.length)
            return Memory.FALSE;

        this.callbacks[id] = invoker;
        return Memory.TRUE;
    }
}
