package com.fishteam.trollbot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fishteam.trollbot.interfaces.EvalMaskElement;
import com.fishteam.trollbot.interfaces.MaskElement;
import com.fishteam.trollbot.wildcards.AnythingMaskElement;
import com.fishteam.trollbot.wildcards.MemoryMaskElement;
import com.fishteam.trollbot.wildcards.RememberMaskElement;
import com.fishteam.trollbot.wildcards.WordMaskElement;

public class Utils {
	private static final String [] WILDCARDS = {"[*]", "[?]", "{name}", "[0]", "[1]", "[2]", "[3]"}; 
	private static final JSONParser JSON_PARSER = new JSONParser();
	private static final String ENCODING = "UTF-8";
	public static String eval(List<? extends EvalMaskElement> masks){
		return masks.stream().sequential().collect(
				LinkedList<String>::new,
				(LinkedList<String> list, EvalMaskElement mask)->list.add(mask.eval()),
				(l1, l2)->l1.addAll(l2))
				.stream().sequential().collect(Collectors.joining(""));
	}
	public static List<MaskElement> constructReqMask(String mask, Map<String, String> memoryMap){
		List<String> list = exactSplit(mask, WILDCARDS);
		List<MaskElement> maskObject = new LinkedList<MaskElement> ();
		int index = 0;
		for(String element:list){
			boolean b = index%2==1;
			maskObject.addAll(constructReqFragment(element, b, memoryMap));
			index++;
		}
		return maskObject;
	}
	public static List<EvalMaskElement> constructReplyMask(String mask, Map<String, String> memoryMap) {
		List<String> list = exactSplit(mask, WILDCARDS);
		List<EvalMaskElement> maskObject = new LinkedList<EvalMaskElement> ();
		int index = 0;
		for(String element:list){
			boolean b = index%2==1;
			maskObject.addAll(constructReplyFragment(element, b, memoryMap));
			index++;
		}
		return maskObject;
	}
	public static List<CharMaskElement> constructPhrase(String phrase){
		List<CharMaskElement> phraseObject = new LinkedList<CharMaskElement> ();
		char[] chars = phrase.toCharArray();
		for(char c: chars){
			phraseObject.add(new CharMaskElement(c));
		}
		return phraseObject;
	}
	public static List<MaskPair> createPairsDictionaryFromFile(File file, Map<String, String> memoryMap){
		List<MaskPair> pairs = new LinkedList<MaskPair>();
		try {
			JSONArray json = (JSONArray) JSON_PARSER.parse(new InputStreamReader(new FileInputStream(file), Charset.forName(ENCODING)));
			for(Object o:json){
				JSONObject elem = (JSONObject) o;
				MaskPair pair = new MaskPair(elem, memoryMap);
				pairs.add(pair);
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return pairs;
	}
	private static List<String> exactSplit(String string, String[] splitters){
		List<String> strings = new LinkedList<String>();
		int index = 0;
		while(index<string.length()){
			int min = Integer.MAX_VALUE;
			String closestSplitter=null;
			for(String splitter: splitters){
				int currentPos = string.indexOf(splitter, index);
				if (min>currentPos&&currentPos!=-1){
					min=currentPos;
					closestSplitter = splitter;
				}
			}
			String part;
			if (min!=Integer.MAX_VALUE){
				part = string.substring(index, min);
				strings.add(part);
				strings.add(closestSplitter);
				index = min + closestSplitter.length();
			}else{
				part = string.substring(index);
				strings.add(part);
				index = min;
			}
		}
		return strings;
	}
	private static List<MaskElement> constructReqFragment(String fragment, boolean isWildcard, Map<String, String> memoryMap){
		List<MaskElement> fragmentObject = new LinkedList<MaskElement> ();
		if (isWildcard){
			switch (fragment) {
			case "[*]":
				fragmentObject.add(new AnythingMaskElement());
				break;
			case "[?]":
				fragmentObject.add(new WordMaskElement());
				break;
			case "[0]":
				fragmentObject.add(new RememberMaskElement(0));
				break;
			case "[1]":
				fragmentObject.add(new RememberMaskElement(1));
				break;
			case "[2]":
				fragmentObject.add(new RememberMaskElement(2));
				break;
			case "[3]":
				fragmentObject.add(new RememberMaskElement(3));
				break;
			case "{name}":
				fragmentObject.add(new MemoryMaskElement("name", memoryMap));
				break;
			default:
				throw new IllegalArgumentException();
			}
		}else{
			fragmentObject.addAll(constructPhrase(fragment));
		}
		return fragmentObject;
	}
	private static List<EvalMaskElement> constructReplyFragment(String fragment, boolean isWildcard, Map<String, String> memoryMap){
		List<EvalMaskElement> fragmentObject = new LinkedList<EvalMaskElement> ();
		if (isWildcard){
			switch (fragment) {
			case "[0]":
				fragmentObject.add(new RememberMaskElement(0));
				break;
			case "[1]":
				fragmentObject.add(new RememberMaskElement(1));
				break;
			case "[2]":
				fragmentObject.add(new RememberMaskElement(2));
				break;
			case "[3]":
				fragmentObject.add(new RememberMaskElement(3));
				break;
			case "{name}":
				fragmentObject.add(new MemoryMaskElement("name", memoryMap));
				break;
			default:
				throw new IllegalArgumentException();
			}
		}else{
			fragmentObject.addAll(constructPhrase(fragment));
		}
		return fragmentObject;
	}
	
}
