package de.florianmichael.vialoadingbase.platform.viaversion;

import com.viaversion.viaversion.api.platform.ViaInjector;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.libs.fastutil.ints.IntLinkedOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSortedSet;
import com.viaversion.viaversion.libs.gson.JsonObject;
import de.florianmichael.vialoadingbase.netty.NettyConstants;

public class CustomViaInjector implements ViaInjector {

    @Override
    public void inject() {
        // Implemented by Mixins
    }

    @Override
    public void uninject() {
        // ICM
    }

    @Override
    public String getEncoderName() {
        return NettyConstants.HANDLER_ENCODER_NAME;
    }

    @Override
    public String getDecoderName() {
        return NettyConstants.HANDLER_DECODER_NAME;
    }

    @Override
    public IntSortedSet getServerProtocolVersions() {
        final IntSortedSet versions = new IntLinkedOpenHashSet();
        for (ProtocolVersion value : ProtocolVersion.getProtocols()) {
            if (value.getOriginalVersion() >= ProtocolVersion.v1_7_1.getOriginalVersion()) {
                versions.add(value.getOriginalVersion());
            }
        }

        return versions;
    }

    @Override
    public int getServerProtocolVersion() {
        return this.getServerProtocolVersions().firstInt();
    }

    @Override
    public JsonObject getDump() {
        return new JsonObject();
    }
}
