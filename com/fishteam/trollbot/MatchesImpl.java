package com.fishteam.trollbot;

import java.util.LinkedList;
import java.util.List;

import com.fishteam.trollbot.interfaces.Matches;
import com.fishteam.trollbot.wildcards.RememberMaskElement;

public class MatchesImpl implements Matches {

	private List<RememberMaskElement> sequence = new LinkedList<RememberMaskElement>();
	@Override
	public List<RememberMaskElement> getSequence() {
		return sequence;
	}
	
}
