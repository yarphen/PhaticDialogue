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
	@Override
	public int hashCode() {
		return 61;
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
