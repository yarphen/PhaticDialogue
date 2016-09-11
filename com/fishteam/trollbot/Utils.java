package com.fishteam.trollbot;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
	public static String eval(List<? extends EvalMaskElement> masks){
		return masks.stream().sequential().collect(
				LinkedList<String>::new,
				(LinkedList<String> list, EvalMaskElement mask)->list.add(mask.eval()),
				(l1, l2)->l1.addAll(l2))
				.stream().sequential().collect(Collectors.joining(""));
	}
}
