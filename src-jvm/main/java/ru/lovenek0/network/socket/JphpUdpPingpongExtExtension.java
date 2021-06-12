package ru.lovenek0.network.socket;

import php.runtime.env.CompileScope;
import php.runtime.ext.support.Extension;
import ru.lovenek0.network.socket.classes.PPConnection;
import ru.lovenek0.network.socket.classes.PPPacket;
import ru.lovenek0.network.socket.classes.PPServer;

public class JphpUdpPingpongExtExtension extends Extension {
    public static final String NS = "Network\\UDPSocket";

    @Override
    public Status getStatus() {
        return Status.STABLE;
    }

    @Override
    public void onRegister(CompileScope compileScope) {
        registerClass(compileScope, PPServer.class);
        registerClass(compileScope, PPConnection.class);
        registerClass(compileScope, PPPacket.class);
    }
}