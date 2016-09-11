package com.fishteam.trollbot.interfaces;
/**
 * This mask is purposed to match
 * some phrase and return as
 * the result list of captured
 * words  
 */
public interface RequestMask {
	Matches match(String string);
}
