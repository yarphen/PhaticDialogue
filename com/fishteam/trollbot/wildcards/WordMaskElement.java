package com.fishteam.trollbot.wildcards;

import java.util.List;

import com.fishteam.trollbot.CharMaskElement;
import com.fishteam.trollbot.interfaces.MaskElement;

public class WordMaskElement implements MaskElement{
	@Override
	public boolean match(List<CharMaskElement> chars) {
		for(CharMaskElement maskElement:chars){
			if(!maskElement.isLetter())return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "[?]";
	}
}
