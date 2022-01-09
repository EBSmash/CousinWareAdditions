package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;

public class S15PacketEntityRelMove extends SPacketEntity {
    public void SPacketEntity$S15PacketEntityRelMove() {
    }

    public void SPacketEntity$S15PacketEntityRelMove(int entityIdIn, long xIn, long yIn, long zIn, boolean onGroundIn) {
//        super(entityIdIn);
        this.posX = (int)xIn;
        this.posY = (int)yIn;
        this.posZ = (int)zIn;
        this.onGround = onGroundIn;
    }

    public void readPacketData(PacketBuffer buf) throws IOException {
        super.readPacketData(buf);
        this.posX = buf.readShort();
        this.posY = buf.readShort();
        this.posZ = buf.readShort();
        this.onGround = buf.readBoolean();
    }

    public void writePacketData(PacketBuffer buf) throws IOException {
        super.writePacketData(buf);
        buf.writeShort(this.posX);
        buf.writeShort(this.posY);
        buf.writeShort(this.posZ);
        buf.writeBoolean(this.onGround);
    }
}
