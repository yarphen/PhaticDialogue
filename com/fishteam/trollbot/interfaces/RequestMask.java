package com.fishteam.trollbot.interfaces;

import java.util.List;

/**
 * This mask is purposed to match
 * some phrase and return as
 * the result list of captured
 * words  
 */
public interface RequestMask {
	Matches match(String string, boolean isCaseSensitive);
	List<MaskElement> getSequence();
}
