package com.wdcftgg.inertiacancellation.network;

import com.wdcftgg.inertiacancellation.InertiaCancellation;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageInertiaCancellation implements IMessageHandler<MessageInertiaCancellation, IMessage>, IMessage  {

    public boolean inertiaCancellation;
    public int entId;


    public MessageInertiaCancellation() {
    }

    public MessageInertiaCancellation(boolean inertiaCancellation, EntityPlayer player) {
        this.inertiaCancellation = inertiaCancellation;
        this.entId = player.getEntityId();
    }

    public void fromBytes(ByteBuf buf) {
        this.inertiaCancellation = buf.readBoolean();
        this.entId = buf.readInt();
    }

    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(this.inertiaCancellation);
        buf.writeInt(this.entId);
    }


    public IMessage onMessage(MessageInertiaCancellation message, MessageContext ctx) {
        Entity entity = ctx.getServerHandler().player.world.getEntityByID(message.entId);
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            NBTTagCompound persistent = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
            persistent.setBoolean(InertiaCancellation.MODID, message.inertiaCancellation);
            player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistent);
        }
        return null;
    }
}