package io.ace.nordclient.hacks.combat;

import io.ace.nordclient.CousinWare;
import io.ace.nordclient.command.Command;
import io.ace.nordclient.event.PacketEvent;
import io.ace.nordclient.hacks.Hack;
import io.ace.nordclient.utilz.Setting;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumHand;

public class pearlDelay extends Hack {
    Setting sDelay;
    public pearlDelay() {
        super("Pearl Delay", Category.EXPLOIT, 2956934);
        CousinWare.INSTANCE.settingsManager.rSetting(sDelay = new Setting("TickDelay", this, 18, 0, 500, true, "ChorusLagDelay", true));

    }
    int delay = 0;

    public void onUpdate(PacketEvent.Send event) {
        delay++;
        ItemStack handStack = mc.player.getHeldItem(EnumHand.MAIN_HAND);
        if(delay + -sDelay.getValInt() < 0 )
        if (event.getPacket() instanceof CPacketPlayerDigging) {
            if (!handStack.isEmpty() && handStack.getItem() != null && handStack.getItem() instanceof ItemEnderPearl) {
                if (event.getPacket() instanceof CPacketConfirmTeleport) {
                    event.setCanceled(true);
                }

            }
        }
    }
}
