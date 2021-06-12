package ru.lovenek0.network.socket.classes;

import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseObject;
import php.runtime.memory.LongMemory;
import php.runtime.memory.StringMemory;
import php.runtime.reflection.ClassEntity;
import ru.lovenek0.UDPConnection;
import ru.lovenek0.network.socket.JphpUdpPingpongExtExtension;

@Reflection.Name("UDPConnection")
@Reflection.Namespace(JphpUdpPingpongExtExtension.NS)
public class PPConnection extends BaseObject {
    public PPConnection(Environment env) {
        super(env);
    }
    protected PPConnection(ClassEntity entity) {
        super(entity);
    }
    public PPConnection(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    public UDPConnection connection;

    @Reflection.Signature
    public void __construct(Memory host, Memory port){
        connection = new UDPConnection(host.toString(), port.toInteger());
    }

    @Reflection.Signature
    public void sendData(Memory data){
        connection.SendData(data.toString());
    }

    @Reflection.Signature
    public void disconnect(){
        connection.Disconnect();
    }

    @Reflection.Signature
    public Memory getHost(){
        return StringMemory.valueOf(connection.GetHost());
    }

    @Reflection.Signature
    public Memory getPort(){
        return LongMemory.valueOf(connection.GetPort());
    }

    @Reflection.Signature
    public Memory getAddress(){
        return StringMemory.valueOf(connection.GetAddress());
    }

    @Reflection.Signature
    public Memory getPing(){
        return LongMemory.valueOf(connection.GetPing());
    }

    @Reflection.Signature
    public Memory getLost(){
        return LongMemory.valueOf(connection.GetLost());
    }
}
