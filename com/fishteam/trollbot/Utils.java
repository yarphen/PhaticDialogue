package com.fishteam.trollbot;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.fishteam.trollbot.interfaces.EvalMaskElement;
import com.fishteam.trollbot.interfaces.MaskElement;

public class Utils {
	public static String eval(List<? extends EvalMaskElement> masks){
		return masks.stream().sequential().collect(
				LinkedList<String>::new,
				(LinkedList<String> list, EvalMaskElement mask)->list.add(mask.eval()),
				(l1, l2)->l1.addAll(l2))
				.stream().sequential().collect(Collectors.joining(""));
	}
	public static List<MaskElement> constructMask(String mask){
		//TODO
		String [] matches = mask.split("/\\[\\\\*\\]|\\[\\\\?\\]|\\{\\w+\\}|\\[\\d\\]/g");
		return null;
	}
	public static List<CharMaskElement> constructPhrase(String phrase){
		List<CharMaskElement> phraseObject = new LinkedList<CharMaskElement> ();
		char[] chars = phrase.toCharArray();
		for(char c: chars){
			phraseObject.add(new CharMaskElement(c));
		}
		return phraseObject;
	}
	private static List<String> exactSplit(String string, String[] splitters){
		List<String> strings = new LinkedList<String>();
		int index = 0;
		while(index<string.length()){
			int min = Integer.MAX_VALUE;
			String closestSplitter=null;
			for(String splitter: splitters){
				int currentPos = string.indexOf(splitter, index);
				if (min>currentPos){
					min=currentPos;
					closestSplitter = splitter;
				}
			}
			String part = string.substring(index, min);
			
		}

		return strings;
	}
}
