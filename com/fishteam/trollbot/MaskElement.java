package com.fishteam.trollbot;

import java.util.List;

public interface MaskElement {
	String toString();
	boolean match(List<CharMaskElement> chars);
}
