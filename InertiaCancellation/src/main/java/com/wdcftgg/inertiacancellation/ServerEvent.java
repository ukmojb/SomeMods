package com.wdcftgg.inertiacancellation;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber
public class ServerEvent {


    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;
        NBTTagCompound persistent = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);

        if (persistent.hasKey(InertiaCancellation.MODID)) {
            boolean inertiaCancellation = persistent.getBoolean(InertiaCancellation.MODID);
            if (player.capabilities.isFlying && inertiaCancellation) {
                if (player.moveForward == 0 && player.moveStrafing == 0) {
                    player.motionX *= 0.5;
                    player.motionZ *= 0.5;
                }
            }
        }
    }
}
