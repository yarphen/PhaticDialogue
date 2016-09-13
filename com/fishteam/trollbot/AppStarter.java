package com.fishteam.trollbot;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.fishteam.trollbot.interfaces.ReplyDictionary;

public class AppStarter {
	private static final String PATH = "src/dict.json";

	public static void main(String[] args) {
		ReplyDictionary dictionary = new TreeDictionary();
		Map<String, String> memoryMap = new HashMap<String, String>();
		Utils.createPairsDictionaryFromFile(new File(PATH), memoryMap)
		.forEach(item->dictionary.addMask(item));
		BotProgram botProgram = new BotProgram(new TrollBot(new BotStatus(2.8), dictionary, new MoodFilter(),
				/*caseSensitive*/ false));
		botProgram.start();
	}
}
