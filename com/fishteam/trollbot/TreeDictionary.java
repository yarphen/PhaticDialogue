package com.fishteam.trollbot;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.fishteam.trollbot.interfaces.MaskElement;
import com.fishteam.trollbot.interfaces.ReplyDictionary;

public class TreeDictionary implements ReplyDictionary {
	private List<TreeNode> roots;
	@Override
	public Iterable<MaskPair> findMasks(String phrase) {
		List<CharMaskElement> charList = Utils.constructPhrase(phrase);
		List<MaskPair> pairs = new LinkedList<MaskPair>();
		roots.forEach(root->{
			pairs.addAll(root.findMasks(charList));
		});
		return pairs;
	}
	private class TreeNode{
		private MaskElement element;
		private List<TreeNode> children;
		private MaskPair pair;
		private Collection<MaskPair> findMasks(List<CharMaskElement> charList) {
			List<MaskPair> pairs = new LinkedList<MaskPair>();
			if (pair!=null&&element.match(charList)){
				pairs.add(pair);
			}
			List<List<CharMaskElement>> subLists = new LinkedList<List<CharMaskElement>>();
			for(int i=0; i<=charList.size(); i++){
				List<CharMaskElement> head = charList.subList(0, i);
				if (element.match(head)){
					List<CharMaskElement> tail = charList.subList(i, charList.size());
					subLists.add(tail);
				}
			}
			children.forEach(root->{
				subLists.forEach(tail->{
					pairs.addAll(root.findMasks(tail));
				});
			});
			return pairs;
		}
	}
}
