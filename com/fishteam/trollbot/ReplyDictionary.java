package com.fishteam.trollbot;

/**
 * ReplyDictionary must find all the masks pairs
 * those matches the customer's phrase 
 */
public interface ReplyDictionary {
	Iterable<MaskPair> findMasks(String phrase);
}
