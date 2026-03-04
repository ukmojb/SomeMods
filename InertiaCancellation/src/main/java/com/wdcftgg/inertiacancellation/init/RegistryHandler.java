package com.wdcftgg.inertiacancellation.init;


import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class RegistryHandler {

	public static final KeyBinding MY_HOTKEY = new KeyBinding("key.inertiacancellation.inertia_cancellation", KeyConflictContext.IN_GAME, KeyModifier.NONE, Keyboard.KEY_NUMPAD1, "key.category.inertiacancellation");

	public static void InitReg()
	{
		ClientRegistry.registerKeyBinding(MY_HOTKEY);
	}
}
