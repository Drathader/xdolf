package com.darkcart.xdolf.mods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.darkcart.xdolf.Module;
import com.darkcart.xdolf.mods.aura.AuraMob;
import com.darkcart.xdolf.mods.aura.AuraPlayer;
import com.darkcart.xdolf.mods.aura.AutoArmor;
import com.darkcart.xdolf.mods.aura.CrystalAura;
import com.darkcart.xdolf.mods.aura.KillAura;
import com.darkcart.xdolf.mods.player.AntiKnockback;
import com.darkcart.xdolf.mods.player.AutoRespawn;
import com.darkcart.xdolf.mods.player.AutoWalk;
import com.darkcart.xdolf.mods.player.Flight;
import com.darkcart.xdolf.mods.player.Spammer;
import com.darkcart.xdolf.mods.player.Step;
import com.darkcart.xdolf.mods.render.Chams;
import com.darkcart.xdolf.mods.render.EntityESP;
import com.darkcart.xdolf.mods.render.NoHurtCam;
import com.darkcart.xdolf.mods.render.NoPumpkinBlur;
import com.darkcart.xdolf.mods.render.StorageESP;
import com.darkcart.xdolf.mods.render.Tracers;
import com.darkcart.xdolf.mods.world.Fullbright;
import com.darkcart.xdolf.mods.world.Timer;
import com.darkcart.xdolf.mods.world.XRay;

public class Hacks
{
	public static ArrayList<Module> display = new ArrayList<Module>();
	
	/** All mods stored in this list **/
	public static List<Module> hackList = Arrays.asList(new Module[] {
			new Fullbright(),
			new Tracers(),
			new StorageESP(),
			new EntityESP(),
			new NoHurtCam(),
			new AntiKnockback(),
			new Step(),
			new Flight(),
			new Spammer(),
			new Timer(),
			new NoPumpkinBlur(),
			new XRay(),
			new KillAura(),
			new AutoRespawn(),
			new AutoArmor(),
			new CrystalAura(),
			new AutoWalk(),
			new Chams(),
			new AuraMob(),
			new AuraPlayer(),
			new GUI(),
	});

	public static Module[] getEnabledHacks()
	{
		ArrayList<Module> enabledMods = new ArrayList<Module>();
		for(Module mod: hackList)
		{
			if(mod.isEnabled()) 
			{
				enabledMods.add(mod);
			}
		}
		
		return enabledMods.toArray(new Module[enabledMods.size()]);
	}
	
	public static Module getModByClassName(String name)
	{
		for(Module mod: hackList) 
		{
			if(mod.getClass().getSimpleName().toLowerCase().trim().equals(name.toLowerCase().trim()))
			{
				return mod;
			}
		}
		
		return null;
	}
	
	public static Module getModByName(String name) 
	{
		for(Module mod: hackList)
		{
			if(mod.getName().trim().equalsIgnoreCase(name.trim()) || mod.toString().trim().equalsIgnoreCase(name.trim())) 
			{
				return mod;
			}
		}
		
		return null;
	}
	
	public static Module findMod(Class<?extends Module> clazz) 
	{
		for(Module mod: hackList)
		{
			if(mod.getClass() == clazz)
			{
				return mod;
			}
		}
		
		return null;
	}
	
	public static Module findMod(String name)
	{
		Module mod = getModByName(name);
		if(mod != null) 
		{
			return mod;
		}
		mod = getModByClassName(name);
		
		return mod;
	}
}