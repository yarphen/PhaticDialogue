package com.fishteam.trollbot.interfaces;

import com.fishteam.trollbot.BotStatus;
import com.fishteam.trollbot.MaskPair;

/**
 * ReplyFilter must find one of all the masks pairs
 * that is the best 
 */
public interface ReplyFilter {
	MaskPair findBestMask(Iterable<MaskPair> pairs, BotStatus status);
}
