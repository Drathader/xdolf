package com.darkcart.xdolf.clickgui.windows;

import com.darkcart.xdolf.Wrapper;
import com.darkcart.xdolf.clickgui.XdolfGuiClick;
import com.darkcart.xdolf.clickgui.elements.XdolfButton;
import com.darkcart.xdolf.clickgui.elements.XdolfSlider;
import com.darkcart.xdolf.clickgui.elements.XdolfWindow;
import com.darkcart.xdolf.fonts.Fonts;
import com.darkcart.xdolf.mods.Hacks;
import com.darkcart.xdolf.util.Friend;
import com.darkcart.xdolf.util.RenderUtils;

import net.minecraft.entity.player.EntityPlayer;

public class WindowRadar extends XdolfWindow {
	public WindowRadar() {
		super("Radar", 94, 98);
	}
	
	@Override
	public void draw(int x, int y)
	{
		if(dragging)
		{
			drag(x, y);
		}
			
		if(isOpen())
		{
			int rect = 0;
			int rect2 = 0;
			for(Object o: Wrapper.getWorld().playerEntities) {
				EntityPlayer e = (EntityPlayer) o;
				if(e != Wrapper.getPlayer() && !e.isDead) {
					rect += 10;
					rect2 += 7;
				}
			}
			int count = 0;
				
			if(!(rect == 0 && count == 0))
			{
				RenderUtils.drawBorderedRect(getXAndDrag(), getYAndDrag(), getXAndDrag() + 100, getYAndDrag() + rect + 16, 0.5F, 0xFF000000, 0x80000000);
			}
			count = 0;
			for(Object o: Wrapper.getWorld().playerEntities)
			{
				EntityPlayer e = (EntityPlayer) o;
				if(e != Wrapper.getPlayer() && !e.isDead)
				{
					int distance = (int)Wrapper.getPlayer().getDistanceToEntity(e);
					String text = "";
					if(Wrapper.getFriends().isFriend(e.getName()))
					{
						text = "\247a" + e.getName() + "\247f: " + (int)distance;
					}else{
						text = "\247c" + e.getName() + "\247f: " + (int)distance;
					}
					for(Friend friend: Wrapper.getFriends().friendsList)
					{
						text = text.replace(friend.getName(), friend.getAlias());
					}
					int xPosition = getXAndDrag() + 3;
					int yPosition = getYAndDrag() + (10 * count) + 13;
					Fonts.roboto18.drawStringWithShadow(text, xPosition, yPosition, 0xFFFFFF);
					count++;
				}
			}
				
			if(rect == 0 && count == 0)
			{
				RenderUtils.drawBorderedRect(getXAndDrag(), getYAndDrag(), getXAndDrag() + 100 , getYAndDrag() + 26 , 0.5F, 0xff000000, 0x80000000);
				Fonts.roboto18.drawStringWithShadow("No players in range.", getXAndDrag() + 3, getYAndDrag() + 13, 0xFFFFFF);
			}
			
			Fonts.roboto18.drawStringWithShadow(getTitle(), getXAndDrag() + 3, getYAndDrag() + 1, 0xFFFFFFFF);
			if(Wrapper.getMinecraft().currentScreen instanceof XdolfGuiClick) {
				RenderUtils.drawBorderedRect(getXAndDrag() + 79, getYAndDrag() + 2, getXAndDrag() + 88, getYAndDrag() + 11, 0.5F, 0xFF000000, isPinned() ? 0xFFFF0000 : 0xFF383b42);
				RenderUtils.drawBorderedRect(getXAndDrag() + 89, getYAndDrag() + 2, getXAndDrag() + 98, getYAndDrag() + 11, 0.5F, 0xFF000000, isOpen() ? 0xFFFF0000 : 0xFF383b42);
			}
			}else{
			RenderUtils.drawBorderedRect(getXAndDrag(), getYAndDrag(), getXAndDrag() + 100, getYAndDrag() + 14, 0.5F, 0xFF000000, 0x80000000);
			Fonts.roboto18.drawStringWithShadow(getTitle(), getXAndDrag() + 3, getYAndDrag() + 1, 0xFFFFFFFF);
			if(Wrapper.getMinecraft().currentScreen instanceof XdolfGuiClick) {
				RenderUtils.drawBorderedRect(getXAndDrag() + 79, getYAndDrag() + 2, getXAndDrag() + 88, getYAndDrag() + 11, 0.5F, 0xFF000000, isPinned() ? 0xFFFF0000 : 0xFF383b42);
				RenderUtils.drawBorderedRect(getXAndDrag() + 89, getYAndDrag() + 2, getXAndDrag() + 98, getYAndDrag() + 11, 0.5F, 0xFF000000, isOpen() ? 0xFFFF0000 : 0xFF383b42);
		
			}
		}
	}
}
