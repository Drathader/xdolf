package com.darkcart.xdolf.mods.world;

import org.lwjgl.input.Keyboard;

import com.darkcart.xdolf.Module;
import com.darkcart.xdolf.util.Category;

import net.minecraft.client.entity.EntityPlayerSP;

public class Timer extends Module {
	
	public Timer()
	{
		super("Timer", "Speeds up the game. Doesn't bypass on most servers.", Keyboard.KEYBOARD_SIZE, 0xFFFFFF, Category.World);
	}
	
	public static float speed = 5.0f;

	public void onUpdate(EntityPlayerSP player) {
		if(isEnabled() && net.minecraft.util.Timer.timerSpeed != speed) {
			net.minecraft.util.Timer.timerSpeed = speed;
		}
	}

	@Override
	public void onDisable() {
		net.minecraft.util.Timer.timerSpeed = 1;
	}
}
