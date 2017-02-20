package com.darkcart.xcheat.commands;

import com.darkcart.xcheat.Client;
import com.darkcart.xcheat.Wrapper;

import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.util.text.TextComponentString;

public class CmdSay extends Command {
	public CmdSay() {
		super("say");
	}

	@Override
	public void runCommand(String s, String[] args) {
		try {
			String s1 = s.substring(4);
			Wrapper.getPlayer().connection.sendPacket(new CPacketChatMessage(s1));
		} catch(Exception e) {
			Wrapper.getPlayer().addChatMessage(new TextComponentString("Usage: " + getSyntax()));
		}
	}

	@Override
	public String getDescription() {
		return "Sends a chat message.";
	}

	@Override
	public String getSyntax() {
		return "say <message>";
	}
}