package com.fishteam.trollbot;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import com.fishteam.trollbot.interfaces.MaskElement;
import com.fishteam.trollbot.interfaces.ReplyDictionary;

public class TreeDictionary implements ReplyDictionary {
	/**
	 * bad solution of problem that root element can't contain anything
	 */
	private HashMap<MaskElement, TreeNode> roots = new HashMap<MaskElement, TreeNode>();
	@Override
	public Iterable<MaskPair> findMasks(String phrase, boolean isCaseSensitive) {
		List<CharMaskElement> charList = Utils.constructPhrase(phrase);
		List<MaskPair> pairs = new LinkedList<MaskPair>();
		roots.values().forEach(root->{
			pairs.addAll(root.findMasks(charList, isCaseSensitive));
		});
		return pairs;
	}
	private class TreeNode{
		private MaskElement element;
		private HashMap<MaskElement, TreeNode> children = new HashMap<>();
		private List<MaskPair> pairs = new LinkedList<MaskPair>();

		private Collection<MaskPair> findMasks(List<CharMaskElement> charList, boolean isCaseSensitive) {
			List<MaskPair> pairs = new LinkedList<MaskPair>();
			if (!this.pairs.isEmpty()&&element.match(charList, isCaseSensitive)){
				pairs.addAll(this.pairs);
			}
			List<List<CharMaskElement>> subLists = new LinkedList<List<CharMaskElement>>();
			for(int i=0; i<=charList.size(); i++){
				List<CharMaskElement> head = charList.subList(0, i);
				if (element.match(head, isCaseSensitive)){
					List<CharMaskElement> tail = charList.subList(i, charList.size());
					subLists.add(tail);
				}
			}
			children.values().forEach(root->{
				subLists.forEach(tail->{
					pairs.addAll(root.findMasks(tail, isCaseSensitive));
				});
			});
			return pairs;
		}
		@Override
		public int hashCode() {
			final int prime = 97;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result
					+ ((element == null) ? 0 : element.hashCode());
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
			TreeNode other = (TreeNode) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (element == null) {
				if (other.element != null)
					return false;
			} else if (!element.equals(other.element))
				return false;
			return true;
		}
		private TreeDictionary getOuterType() {
			return TreeDictionary.this;
		}
		private void addMask(MaskPair pair, List<MaskElement> subList) {
			//bad solution causes code duplication
			if (subList.isEmpty())return;
			MaskElement first = subList.get(0);
			TreeNode child;
			if (children.containsKey(first)){
				child = children.get(first);
			}else{
				child = new TreeNode();
				child.element = first;
				children.put(first, child);
			}
			if (subList.size()==1){
				child.pairs.add(pair);
			}else{
				child.addMask(pair,subList.subList(1, subList.size()));
			}
		}

	}
	@Override
	public void addMask(MaskPair pair) {
		//bad solution causes code duplication
		List<MaskElement> list = pair.getRequestMask().getSequence();
		if (list.isEmpty())return;
		MaskElement first = list.get(0);
		TreeNode root;
		if (roots.containsKey(first)){
			root = roots.get(first);
		}else{
			root = new TreeNode();
			root.element = first;
			roots.put(first, root);
		}
		if (list.size()==1){
			root.pairs.add(pair);
		}else{
			root.addMask(pair,list.subList(1, list.size()));
		}
	}
}
