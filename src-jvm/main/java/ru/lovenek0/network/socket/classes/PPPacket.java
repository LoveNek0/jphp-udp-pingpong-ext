package ru.lovenek0.network.socket.classes;

import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseObject;
import php.runtime.memory.LongMemory;
import php.runtime.memory.StringMemory;
import php.runtime.reflection.ClassEntity;
import ru.lovenek0.network.PingPongUDP.UDPPacket;
import ru.lovenek0.network.socket.PingPongSocketExtension;

@Reflection.Name("UDPPacket")
@Reflection.Namespace(PingPongSocketExtension.NS)
public class PPPacket extends BaseObject {
    public PPPacket(Environment env) {
        super(env);
    }
    public PPPacket(Environment env, UDPPacket packet){
        super(env);
        this.packet = packet;
    }
    protected PPPacket(ClassEntity entity) {
        super(entity);
    }
    protected PPPacket(ClassEntity entity, UDPPacket packet){
        super(entity);
        this.packet = packet;
    }
    public PPPacket(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }
    public PPPacket(Environment env, ClassEntity clazz, UDPPacket packet){
        super(env, clazz);
        this.packet = packet;
    }

    private UDPPacket packet;

    @Reflection.Signature
    public void __construct(Memory id, Memory data){
        packet = new UDPPacket(id.toLong(), data.toString());
    }

    @Reflection.Signature
    public Memory getData(){
        return StringMemory.valueOf(packet.GetData());
    }

    @Reflection.Signature
    public Memory getID(){
        return LongMemory.valueOf(packet.GetID());
    }
}
