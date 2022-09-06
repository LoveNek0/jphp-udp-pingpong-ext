package ru.lovenek0.network.socket.classes;

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
import ru.lovenek0.UDPClient;
import ru.lovenek0.UDPClientListener;
import ru.lovenek0.UDPPacket;
import ru.lovenek0.network.socket.JphpUdpPingpongExtExtension;

import java.net.DatagramPacket;
import java.util.Arrays;

@Reflection.Name("UDPClient")
@Reflection.Namespace(JphpUdpPingpongExtExtension.NS)
public class PPClient extends BaseObject {
    private UDPClient client;


    public PPClient(Environment env) {
        super(env);
    }

    protected PPClient(ClassEntity entity) {
        super(entity);
    }

    public PPClient(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    private Invoker[] callbacks = new Invoker[10];

    public static final int onPacketNotSend = 0;
    public static final int onPacketSend = 1;
    public static final int onPacketReceiveTimeout = 2;
    public static final int onPacketReceive = 3;
    public static final int onPacketArrivedLate = 4;
    public static final int onDisconnectTimeout = 5;
    public static final int onClientDisconnect = 6;
    public static final int onServerDisconnect = 7;
    public static final int onConnect = 8;
    public static final int onFailedToConnect = 9;

    private void InitCallbacks(){
        client.SetListener(new UDPClientListener() {
            @Override
            public void OnPacketNotSend(UDPPacket udpPacket) {
                if(callbacks[onPacketNotSend] == null)
                    return;
                PPPacket packet = new PPPacket(getEnvironment());
                packet.packet = udpPacket;
                callbacks[onPacketNotSend].callNoThrow(ObjectMemory.valueOf(packet));
            }

            @Override
            public void OnPacketSend(UDPPacket udpPacket) {
                if(callbacks[onPacketSend] == null)
                    return;
                PPPacket packet = new PPPacket(getEnvironment());
                packet.packet = udpPacket;
                callbacks[onPacketSend].callNoThrow(ObjectMemory.valueOf(packet));
            }

            @Override
            public void OnPacketReceiveTimeout() {
                if(callbacks[onPacketReceiveTimeout] == null)
                    return;
                callbacks[onPacketReceiveTimeout].callNoThrow();
            }

            @Override
            public void OnPacketReceive(UDPPacket udpPacket) {
                if(callbacks[onPacketReceive] == null)
                    return;
                PPPacket packet = new PPPacket(getEnvironment());
                packet.packet = udpPacket;
                callbacks[onPacketReceive].callNoThrow(ObjectMemory.valueOf(packet));
            }

            @Override
            public void OnPacketArrivedLate(UDPPacket udpPacket) {
                if(callbacks[onPacketArrivedLate] == null)
                    return;
                PPPacket packet = new PPPacket(getEnvironment());
                packet.packet = udpPacket;
                callbacks[onPacketArrivedLate].callNoThrow(ObjectMemory.valueOf(packet));
            }

            @Override
            public void OnDisconnectTimeout() {
                if(callbacks[onDisconnectTimeout] == null)
                    return;
                callbacks[onDisconnectTimeout].callNoThrow();
            }

            @Override
            public void OnClientDisconnect() {
                if(callbacks[onClientDisconnect] == null)
                    return;
                callbacks[onClientDisconnect].callNoThrow();
            }

            @Override
            public void OnServerDisconnect() {
                if(callbacks[onServerDisconnect] == null)
                    return;
                callbacks[onServerDisconnect].callNoThrow();
            }

            @Override
            public void OnDatagramReceive(DatagramPacket datagramPacket) {

            }

            @Override
            public void OnConnect() {
                if(callbacks[onConnect] == null)
                    return;
                callbacks[onConnect].callNoThrow();
            }

            @Override
            public void OnFailedToConnect(Exception e, String s, int i) {
                if(callbacks[onFailedToConnect] == null)
                    return;
                callbacks[onFailedToConnect].callNoThrow(StringMemory.valueOf(s), LongMemory.valueOf(i));
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
    public void connect(Memory host, Memory port){
        client.Connect(host.toString(), port.toInteger());
    }

    @Reflection.Signature
    public void disconnect(){
        client.Disconnect();
    }

    @Reflection.Signature
    public void sendData(Memory data){
        client.SendData(data.toString());
    }

    @Reflection.Signature
    public void setMaxPacketSize(Memory size){
        client.SetMaxPacketSize(size.toInteger());
    }

    @Reflection.Signature
    public Memory getMaxPacketSize(){
        return LongMemory.valueOf(client.GetMaxPacketSize());
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

    @Reflection.Signature
    public void setDisconnectTimeout(Memory timeoutMS){
        client.SetDisconnectTimeout(timeoutMS.toInteger());
    }

    @Reflection.Signature
    public Memory getDisconnectTimeout(){
        return LongMemory.valueOf(client.GetDisconnectTimeout());
    }

    @Reflection.Signature
    public void setReceiveTimeout(Memory timeoutMS){
        client.SetReceiveTimeout(timeoutMS.toInteger());
    }

    @Reflection.Signature
    public Memory getReceiveTimeout(){
        return LongMemory.valueOf(client.GetReceiveTimeout());
    }

    @Reflection.Signature
    public Memory getPing(){
        return LongMemory.valueOf(client.GetPing());
    }

    @Reflection.Signature
    public Memory getLost(){
        return LongMemory.valueOf(client.GetLost());
    }
}
