package com.fishteam.trollbot.wildcards;

import java.util.List;
import java.util.Map;

import com.fishteam.trollbot.CharMaskElement;
import com.fishteam.trollbot.Utils;
import com.fishteam.trollbot.interfaces.EvalMaskElement;
import com.fishteam.trollbot.interfaces.MaskElement;

public class MemoryMaskElement implements EvalMaskElement{
	private String fieldName;
	private Map<String, String> memoryMap;
	@Override
	public boolean match(List<CharMaskElement> maskElements) {
		memoryMap.put(fieldName, Utils.eval(maskElements));
		return true;
	}
	@Override
	public String toString() {
		return "{"+fieldName+"}";
	}
	@Override
	public String eval() {
		return memoryMap.get(fieldName);
	}
}
