package com.wdcftgg.inertiacancellation;


import com.wdcftgg.inertiacancellation.network.MessageInertiaCancellation;
import com.wdcftgg.inertiacancellation.network.PacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import static com.wdcftgg.inertiacancellation.init.RegistryHandler.MY_HOTKEY;

@Mod.EventBusSubscriber
public class ClientEvent {

    @SubscribeEvent
    public static void onKeyPressed(InputEvent.KeyInputEvent event) {
        if (MY_HOTKEY.isPressed()) {
            System.out.println("adweawd");
            EntityPlayer player = Minecraft.getMinecraft().player;
            if (player != null) {
                NBTTagCompound persistent = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);

                if (!persistent.hasKey(InertiaCancellation.MODID)) {
                    persistent.setBoolean(InertiaCancellation.MODID, true);
                    player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistent);
                    PacketHandler.INSTANCE.sendToServer(new MessageInertiaCancellation(true, player));
                } else {
                    boolean inertiaCancellation = persistent.getBoolean(InertiaCancellation.MODID);
                    PacketHandler.INSTANCE.sendToServer(new MessageInertiaCancellation(!inertiaCancellation, player));
                    persistent.setBoolean(InertiaCancellation.MODID, !inertiaCancellation);
                    player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistent);
                }
            }
        }
    }


}
