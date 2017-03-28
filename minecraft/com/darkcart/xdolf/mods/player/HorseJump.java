package com.darkcart.xdolf.mods.player;

import org.lwjgl.input.Keyboard;

import com.darkcart.xdolf.Module;
import com.darkcart.xdolf.util.Category;

import net.minecraft.client.entity.EntityPlayerSP;

public class HorseJump extends Module
{
	public HorseJump()
	{
		super("HorseJump", "Max jump height on a horse everytime.", Keyboard.KEYBOARD_SIZE, 0xFFFFFF, Category.Player);
	}
	
	@Override
	public void onUpdate(EntityPlayerSP player) {
		if(isEnabled()) {
			player.horseJumpPower = 1.0F;
		}
	}
}