package com.fishteam.trollbot.interfaces;

import com.fishteam.trollbot.MaskPair;

/**
 * ReplyDictionary must find all the masks pairs
 * those matches the customer's phrase 
 */
public interface ReplyDictionary {
	Iterable<MaskPair> findMasks(String phrase);
	void addMask(MaskPair pair);
}
