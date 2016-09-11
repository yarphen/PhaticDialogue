package com.fishteam.trollbot.wildcards;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.fishteam.trollbot.CharMaskElement;
import com.fishteam.trollbot.Utils;
import com.fishteam.trollbot.interfaces.EvalMaskElement;
import com.fishteam.trollbot.interfaces.MaskElement;

public class RememberMaskElement implements EvalMaskElement{
	private int index;
	private String content;
	public RememberMaskElement(int i) {
		index=i;
	}
	@Override
	public boolean match(List<CharMaskElement> maskElements) {
		content=Utils.eval(maskElements);
		return true;
	}
	@Override
	public String toString() {
		return "["+index+"]";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String eval() {
		return getContent();
	}
	@Override
	public int hashCode() {
		final int prime = 71;
		int result = 1;
		result = prime * result + index;
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
		RememberMaskElement other = (RememberMaskElement) obj;
		if (index != other.index)
			return false;
		return true;
	}
}
