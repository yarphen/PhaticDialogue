package com.fishteam.trollbot;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fishteam.trollbot.interfaces.EvalMaskElement;
import com.fishteam.trollbot.interfaces.MaskElement;
import com.fishteam.trollbot.interfaces.Matches;
import com.fishteam.trollbot.interfaces.ReplyMask;
import com.fishteam.trollbot.wildcards.RememberMaskElement;

public class ReplyMaskImpl implements ReplyMask {
	private List<EvalMaskElement> sequence = new LinkedList<EvalMaskElement>();
	
	public ReplyMaskImpl(List<EvalMaskElement> sequence) {
		super();
		this.sequence = sequence;
	}

	@Override
	public String process(Matches matches) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(RememberMaskElement reElement : matches.getSequence()){
			map.put(reElement.getIndex(), reElement.getContent());
		}
		for(EvalMaskElement evalElement : sequence){
			if (evalElement instanceof RememberMaskElement){
				RememberMaskElement element = (RememberMaskElement) evalElement;
				if (map.containsKey(element.getIndex())){
					element.setContent(map.get(element.getIndex()));
				}
			}
		}
		return Utils.eval(sequence);
	}

	@Override
	public List<EvalMaskElement> getSequence() {
		return sequence;
	}

}
