package com.fishteam.trollbot.interfaces;

import java.util.List;

import com.fishteam.trollbot.CharMaskElement;

public interface MaskElement {
	String toString();
	boolean match(List<CharMaskElement> chars, boolean isCaseSensitive);
}
