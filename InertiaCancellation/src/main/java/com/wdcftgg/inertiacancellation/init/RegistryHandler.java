package com.wdcftgg.inertiacancellation.init;


import net.minecraft.block.Block;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

@EventBusSubscriber
public class RegistryHandler {

	public static final KeyBinding MY_HOTKEY = new KeyBinding("key.inertiacancellation.inertia_cancellation", KeyConflictContext.IN_GAME, KeyModifier.NONE, Keyboard.KEY_NUMPAD1, "key.category.inertiacancellation");


	public static void preInitRegistries(FMLPreInitializationEvent event)
	{

//		ModEntityInit.registerEntities();


	}

	public static void postInitReg()
	{
		//WorldType TYPE_ONE = new WorldTypeOne();
	}
	public static void InitReg()
	{
		ClientRegistry.registerKeyBinding(MY_HOTKEY);
	}



	public static void serverRegistries(FMLServerStartingEvent event)
    {
        //event.registerServerCommand(new CommandDimTeleport());
    }

	@SubscribeEvent
	public static void onRegisterSoundEvents(RegistryEvent.Register<SoundEvent> event)
	{
//		ResourceLocation location3 = new ResourceLocation(SpaceTime.MODID, "fallsword");
//
//		ModSounds.FALLSWORD = new SoundEvent(location3).setRegistryName(location3);
//
//		event.getRegistry().register(ModSounds.FALLSWORD);
	}

	private static Item newItemBlock(Block block){
		return new ItemBlock(block).setRegistryName(block.getRegistryName()).setTranslationKey(block.getTranslationKey());
	}
}
