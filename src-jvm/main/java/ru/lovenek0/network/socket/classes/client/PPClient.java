package ru.lovenek0.network.socket.classes.client;

import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.common.HintType;
import php.runtime.env.Environment;
import php.runtime.ext.core.classes.WrapEnvironment;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseObject;
import php.runtime.memory.LongMemory;
import php.runtime.memory.ObjectMemory;
import php.runtime.memory.StringMemory;
import php.runtime.reflection.ClassEntity;
import ru.lovenek0.network.PingPongUDP.UDPPacket;
import ru.lovenek0.network.PingPongUDP.client.UDPClient;
import ru.lovenek0.network.PingPongUDP.client.UDPClientListener;
import ru.lovenek0.network.socket.PingPongSocketExtension;
import ru.lovenek0.network.socket.classes.PPPacket;

import java.net.DatagramPacket;
import java.util.Arrays;

@Reflection.Name("UDPClient")
@Reflection.Namespace(PingPongSocketExtension.NS + "\\Client")
public class PPClient extends BaseObject {
    public PPClient(Environment env) {
        super(env);
    }
    protected PPClient(ClassEntity entity) {
        super(entity);
    }
    public PPClient(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    private UDPClient client;
    private final Invoker[] callbacks = new Invoker[10];

    public static final int onIncorrectHostnameEvent = 0;
    public static final int onFailedToConnectEvent = 1;
    public static final int onPacketNotSendEvent = 2;
    public static final int onDisconnectTimeOutEvent = 3;
    public static final int onPacketSendEvent = 4;
    public static final int onServerDroppedConnectionEvent = 5;
    public static final int onClientDroppedConnectionEvent = 6;
    public static final int onPacketReceivedEvent = 7;
    public static final int onLatePacketReceivedEvent = 8;
    public static final int onPacketReceiveTimedOutEvent = 9;

    private void InitCallbacks(){
        client.setListener(new UDPClientListener() {
            @Override
            public void OnIncorrectHostnameEvent(String s, int i) {
                if(callbacks[onIncorrectHostnameEvent] == null)
                    return;
                callbacks[onIncorrectHostnameEvent].callNoThrow(StringMemory.valueOf(s), LongMemory.valueOf(i));
            }
            @Override
            public void OnFailedToConnectEvent(String s, int i) {
                if(callbacks[onFailedToConnectEvent] == null)
                    return;
                callbacks[onFailedToConnectEvent].callNoThrow(StringMemory.valueOf(s), LongMemory.valueOf(i));
            }
            @Override
            public void OnPacketNotSendEvent(UDPPacket udpPacket) {
                if(callbacks[onPacketNotSendEvent] == null)
                    return;
                callbacks[onPacketNotSendEvent].callNoThrow(ObjectMemory.valueOf(new PPPacket(getEnvironment(), udpPacket)));
            }
            @Override
            public void OnDisconnectTimeOutEvent() {
                if(callbacks[onDisconnectTimeOutEvent] == null)
                    return;
                callbacks[onDisconnectTimeOutEvent].callNoThrow();
            }
            @Override
            public void OnPacketSendEvent(UDPPacket udpPacket) {
                if(callbacks[onPacketSendEvent] == null)
                    return;
                callbacks[onPacketSendEvent].callNoThrow(ObjectMemory.valueOf(new PPPacket(getEnvironment(), udpPacket)));
            }
            @Override
            public void OnServerDroppedConnectionEvent() {
                if(callbacks[onServerDroppedConnectionEvent] == null)
                    return;
                callbacks[onServerDroppedConnectionEvent].callNoThrow();
            }
            @Override
            public void OnClientDroppedConnectionEvent() {
                if(callbacks[onClientDroppedConnectionEvent] == null)
                    return;
                callbacks[onClientDroppedConnectionEvent].callNoThrow();
            }
            @Override
            public void OnPacketReceivedEvent(UDPPacket udpPacket) {
                if(callbacks[onPacketReceivedEvent] == null)
                    return;
                callbacks[onPacketReceivedEvent].callNoThrow(ObjectMemory.valueOf(new PPPacket(getEnvironment(), udpPacket)));
            }
            @Override
            public void OnLatePacketReceivedEvent(UDPPacket udpPacket) {
                if(callbacks[onLatePacketReceivedEvent] == null)
                    return;
                callbacks[onLatePacketReceivedEvent].callNoThrow(ObjectMemory.valueOf(new PPPacket(getEnvironment(), udpPacket)));
            }
            @Override
            public void OnPacketReceiveTimedOutEvent() {
                if(callbacks[onPacketReceiveTimedOutEvent] == null)
                    return;
                callbacks[onPacketReceiveTimedOutEvent].callNoThrow();
            }
        });
    }

    @Reflection.Signature
    public void __construct(){
        client = new UDPClient();
        Arrays.fill(callbacks, null);
        InitCallbacks();
    }

    @Reflection.Signature
    public Memory connect(Memory host, Memory port){
        return client.connect(host.toString(), port.toInteger()) ? Memory.TRUE : Memory.FALSE;
    }

    @Reflection.Signature
    public void disconnect(){
        client.disconnect();
    }

    @Reflection.Signature
    public void sendData(Memory data){
        client.sendData(data.toString());
    }

    @Reflection.Signature
    public void setMaxPacketSize(Memory size){
        client.setPacketSize(size.toInteger());
    }

    @Reflection.Signature
    public Memory getMaxPacketSize(){
        return LongMemory.valueOf(client.getPacketSize());
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

    @Reflection.Signature
    public void setDisconnectTimeout(Memory timeoutMS){
        client.setDisconnectTimeout(timeoutMS.toInteger());
    }

    @Reflection.Signature
    public Memory getDisconnectTimeout(){
        return LongMemory.valueOf(client.getDisconnectTimeout());
    }

    @Reflection.Signature
    public void setReceiveTimeout(Memory timeoutMS){
        client.setReceiveTimeout(timeoutMS.toInteger());
    }

    @Reflection.Signature
    public Memory getReceiveTimeout(){
        return LongMemory.valueOf(client.getReceiveTimeout());
    }

    @Reflection.Signature
    public Memory getPing(){
        return LongMemory.valueOf(client.getPing());
    }

    @Reflection.Signature
    public Memory getLost(){
        return LongMemory.valueOf(client.getLost());
    }
}
