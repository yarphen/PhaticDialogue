package com.fishteam.trollbot;

import com.fishteam.trollbot.interfaces.ReplyFilter;

public class MoodFilter implements ReplyFilter {
	
	/** Iterates over all fitting reply masks and picks
	 *  the one that matches Trollbot's current status(mood) best */
	public MaskPair findBestMask(Iterable<MaskPair> pairs, BotStatus status){	
		
		double botMood = status.getMood();
		double maskMood = 0;
		double currentDiff = 0;
		double bestDiff = 0;
		MaskPair bestPair = null;
		
		for (MaskPair pair : pairs)
		{
			maskMood = pair.getMood();
			currentDiff = Math.abs(botMood-maskMood);
			if (currentDiff<bestDiff){
				bestDiff=currentDiff;
				bestPair=pair;
			}
		}
		return bestPair;
	}
}
