package com.fishteam.trollbot;
/**
 * ReplyFilter must find one of all the masks pairs
 * that is the best 
 */
public interface ReplyFilter {
	MaskPair findBestMask(Iterable<MaskPair> pairs, BotStatus status);
}
