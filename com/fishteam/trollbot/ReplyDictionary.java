package com.fishteam.trollbot;

public interface ReplyDictionary {
	RequestMask findBestMask(String phrase, BotStatus status);
}
