package com.fishteam.trollbot;

public class AppStarter {
	public static void main(String[] args) {
		BotProgram botProgram = new BotProgram(new TrollBot(new BotStatus(2), new TreeDictionary(), new MoodFilter()));
		botProgram.start();
	}
}
