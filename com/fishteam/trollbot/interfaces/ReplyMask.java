package com.fishteam.trollbot.interfaces;

import java.util.List;

/**
 * This is a mask purposed to fill it
 * with the match results and create reply
 */
public interface ReplyMask {
	String process(Matches matches);
	List<EvalMaskElement> getSequence();
}
