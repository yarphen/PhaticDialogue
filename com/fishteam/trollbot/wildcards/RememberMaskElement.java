package com.fishteam.trollbot.wildcards;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.fishteam.trollbot.CharMaskElement;
import com.fishteam.trollbot.EvalMaskElement;
import com.fishteam.trollbot.MaskElement;
import com.fishteam.trollbot.Utils;

public class RememberMaskElement implements EvalMaskElement{
	private int index;
	private String content;
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
}
