package com.fishteam.trollbot;

import java.io.File;

import com.fishteam.trollbot.interfaces.ReplyDictionary;

public class AppStarter {
	private static final String PATH = "src/dict.json";

	public static void main(String[] args) {
		ReplyDictionary dictionary = new TreeDictionary();
		Utils.readPairsDictionaryFromFile(new File(PATH))
		.forEach(item->dictionary.addMask(item));
		BotProgram botProgram = new BotProgram(new TrollBot(new BotStatus(2.8), dictionary, new MoodFilter()));
		botProgram.start();
	}
}
