package com.fishteam.trollbot;

import java.util.List;

public class TreeDictionary implements ReplyDictionary {

	@Override
	public Iterable<MaskPair> findMasks(String phrase) {
		// TODO Auto-generated method stub
		return null;
	}
	private class TreeNode{
		private MaskElement element;
		private List<TreeNode> children;
		private MaskPair pair;
	}
}
