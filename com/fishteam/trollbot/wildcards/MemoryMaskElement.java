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
	public MemoryMaskElement(String fieldName, Map<String, String> map) {
		this.fieldName=fieldName;
	}
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
	@Override
	public int hashCode() {
		final int prime = 83;
		int result = 1;
		result = prime * result
				+ ((fieldName == null) ? 0 : fieldName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemoryMaskElement other = (MemoryMaskElement) obj;
		if (fieldName == null) {
			if (other.fieldName != null)
				return false;
		} else if (!fieldName.equals(other.fieldName))
			return false;
		return true;
	}
}
