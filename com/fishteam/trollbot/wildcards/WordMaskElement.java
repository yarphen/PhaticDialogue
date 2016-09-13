package com.fishteam.trollbot.wildcards;

import java.util.List;

import com.fishteam.trollbot.CharMaskElement;
import com.fishteam.trollbot.interfaces.MaskElement;

public class WordMaskElement implements MaskElement{
	@Override
	public boolean match(List<CharMaskElement> chars, boolean isCaseSensitive) {
		for(CharMaskElement maskElement:chars){
			if(!maskElement.isLetter())return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "[?]";
	}
	@Override
	public int hashCode() {
		return 59;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}
