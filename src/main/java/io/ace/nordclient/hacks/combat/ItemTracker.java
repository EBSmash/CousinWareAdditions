package io.ace.nordclient.hacks.combat;

import io.ace.nordclient.CousinWare;
import io.ace.nordclient.hacks.Hack;
import io.ace.nordclient.utilz.Setting;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.Comparator;

public class ItemTracker extends Hack {
    private final ArrayList<BlockPos> notOwnCrystals = new ArrayList<>();

    Setting crystals;
    Setting exp;

    private int delayStep = 0;

    public ItemTracker() {
        super("ItemTracker", Category.COMBAT, 134965678);
        CousinWare.INSTANCE.settingsManager.rSetting(crystals = new Setting("Crystals", this, true, "crystalCount", true));
        CousinWare.INSTANCE.settingsManager.rSetting(exp = new Setting("Exp", this, true,"expCount", true));
    }

    @Override
    public void onUpdate() {
        EntityEnderCrystal crystal = (EntityEnderCrystal) mc.world.loadedEntityList.stream().filter((entity) -> entity instanceof EntityEnderCrystal).min(Comparator.comparing((c) -> mc.player.getDistance(c))).orElse(null);
    }
}
