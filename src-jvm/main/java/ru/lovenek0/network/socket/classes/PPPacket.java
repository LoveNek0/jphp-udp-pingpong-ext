package ru.lovenek0.network.socket.classes;

import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseObject;
import php.runtime.memory.LongMemory;
import php.runtime.memory.StringMemory;
import php.runtime.reflection.ClassEntity;
import ru.lovenek0.UDPPacket;
import ru.lovenek0.network.socket.JphpUdpPingpongExtExtension;

@Reflection.Name("UDPPacket")
@Reflection.Namespace(JphpUdpPingpongExtExtension.NS)
public class PPPacket extends BaseObject {
    public PPPacket(Environment env) {
        super(env);
    }
    protected PPPacket(ClassEntity entity) {
        super(entity);
    }
    public PPPacket(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    public UDPPacket packet;

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
