package com.fishteam.trollbot;

public interface ReplyDictionary {
	Iterable<RequestMask> findMasks(String phrase);
}
