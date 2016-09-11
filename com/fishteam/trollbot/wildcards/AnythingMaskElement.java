package com.fishteam.trollbot.wildcards;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import com.fishteam.trollbot.CharMaskElement;
import com.fishteam.trollbot.interfaces.MaskElement;

public class AnythingMaskElement implements MaskElement{

	@Override
	public boolean match(List<CharMaskElement> maskElements) {
		return true;
	}
	@Override
	public String toString() {
		return "[*]";
	}
}
