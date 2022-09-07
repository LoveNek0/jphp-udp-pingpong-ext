package ru.lovenek0.network.socket.classes.server;

import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseObject;
import php.runtime.memory.LongMemory;
import php.runtime.memory.StringMemory;
import php.runtime.reflection.ClassEntity;
import ru.lovenek0.network.PingPongUDP.server.UDPConnection;
import ru.lovenek0.network.socket.PingPongSocketExtension;

@Reflection.Name("UDPConnection")
@Reflection.Namespace(PingPongSocketExtension.NS + "\\Server")
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
    public PPConnection(Environment env, UDPConnection connection) {
        super(env);
        this.connection = connection;
    }
    protected PPConnection(ClassEntity entity, UDPConnection connection) {
        super(entity);
        this.connection = connection;
    }
    public PPConnection(Environment env, ClassEntity clazz, UDPConnection connection) {
        super(env, clazz);
        this.connection = connection;
    }

    public UDPConnection connection;

    @Reflection.Signature
    public void __construct(Memory host, Memory port){
        connection = new UDPConnection(host.toString(), port.toInteger());
    }

    @Reflection.Signature
    public void sendData(Memory data){
        connection.sendData(data.toString());
    }

    @Reflection.Signature
    public void disconnect(){
        connection.disconnect();
    }

    @Reflection.Signature
    public Memory getHost(){
        return StringMemory.valueOf(connection.getHost());
    }

    @Reflection.Signature
    public Memory getPort(){
        return LongMemory.valueOf(connection.getPort());
    }

    @Reflection.Signature
    public Memory getAddress(){
        return StringMemory.valueOf(connection.getAddress());
    }

    @Reflection.Signature
    public Memory getPing(){
        return LongMemory.valueOf(connection.getPing());
    }

    @Reflection.Signature
    public Memory getLost(){
        return LongMemory.valueOf(connection.getLost());
    }
}
