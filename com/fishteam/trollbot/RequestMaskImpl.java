package com.fishteam.trollbot;

import java.util.LinkedList;
import java.util.List;

import com.fishteam.trollbot.interfaces.MaskElement;
import com.fishteam.trollbot.interfaces.Matches;
import com.fishteam.trollbot.interfaces.RequestMask;
import com.fishteam.trollbot.wildcards.RememberMaskElement;

public class RequestMaskImpl implements RequestMask{
	private List<MaskElement> sequence = new LinkedList<MaskElement>();
	
	public RequestMaskImpl(List<MaskElement> sequence) {
		super();
		this.sequence = sequence;
	}

	@Override
	public Matches match(String string, boolean isCaseSensitive) {
		TreeDictionary oneWordDictionary = new TreeDictionary();
		MaskPair pair = new MaskPair();
		pair.setRequestMask(this);
		oneWordDictionary.addMask(pair);
		if (oneWordDictionary.findMasks(string, isCaseSensitive).iterator().hasNext()){
			Matches matches = new MatchesImpl();
			for(MaskElement element:sequence){
				if (element instanceof RememberMaskElement){
					RememberMaskElement rememberElement = (RememberMaskElement) element;
					matches.getSequence().add(rememberElement);
				}
			}
			return matches;
		}else{
			return null;
		}
	}

	@Override
	public List<MaskElement> getSequence() {
		return sequence;
	}

}
