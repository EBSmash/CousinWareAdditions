package io.ace.nordclient.hacks.player;

import io.ace.nordclient.CousinWare;
import io.ace.nordclient.hacks.Hack;
import io.ace.nordclient.utilz.InventoryUtil;
import io.ace.nordclient.utilz.Setting;
import net.minecraft.init.Items;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import io.ace.nordclient.CousinWare;
import io.ace.nordclient.hacks.Hack;
import io.ace.nordclient.mixin.accessor.ITimer;
import io.ace.nordclient.utilz.Setting;
import net.minecraftforge.client.ClientCommandHandler;
import org.spongepowered.asm.mixin.Shadow;

public class GhostFirework extends Hack {
    Setting timeout;
    Setting speed;

    public GhostFirework() {
        super("GhostRocket", Category.PLAYER, 3106299);
        CousinWare.INSTANCE.settingsManager.rSetting(timeout = new Setting("Timeout", this, 5000, 250, 20000, true, "FireworkTimer", true));
//        CousinWare.INSTANCE.settingsManager.rSetting(speed = new Setting("TimerSpeed", this, 3, .1, 10, false, "TimerSpeed", true));

    }

    private long lastShootTime;
    int startingHand;

    public void onUpdate() {
//        ((ITimer) mc).setTickLength((float) (50 / speed.getValDouble()));

        int Hand = InventoryUtil.findItemInHotbar(Items.FIREWORKS);
        if (InventoryUtil.findItemInHotbar(Items.FIREWORKS) != -1 && System.currentTimeMillis() - lastShootTime >= timeout.getValInt()) {
            lastShootTime = System.currentTimeMillis();
            mc.player.connection.sendPacket(new CPacketHeldItemChange(Hand));
            mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));


        }
    }

        public void onEnable() {
            startingHand = mc.player.inventory.currentItem;
            lastShootTime = System.currentTimeMillis();


    }
}