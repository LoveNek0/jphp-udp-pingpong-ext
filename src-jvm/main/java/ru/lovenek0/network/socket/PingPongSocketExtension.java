package ru.lovenek0.network.socket;

import php.runtime.env.CompileScope;
import php.runtime.ext.support.Extension;
import ru.lovenek0.network.socket.classes.client.PPClient;
import ru.lovenek0.network.socket.classes.server.PPConnection;
import ru.lovenek0.network.socket.classes.PPPacket;
import ru.lovenek0.network.socket.classes.server.PPServer;

public class PingPongSocketExtension extends Extension {
    public static final String NS = "Network\\PPSocket";

    @Override
    public Status getStatus() {
        return Status.STABLE;
    }

    @Override
    public void onRegister(CompileScope compileScope) {
        registerClass(compileScope, PPServer.class);
        registerClass(compileScope, PPConnection.class);
        registerClass(compileScope, PPPacket.class);
        registerClass(compileScope, PPClient.class);
    }
}