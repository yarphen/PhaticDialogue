package com.fishteam.trollbot;

import java.util.Map;

import org.json.simple.JSONObject;

import com.fishteam.trollbot.interfaces.ReplyMask;
import com.fishteam.trollbot.interfaces.RequestMask;

/**
 * Pair of masks 
 */
public class MaskPair {
	private ReplyMask replyMask;
	private RequestMask requestMask;
	private double mood;
	
	public MaskPair(JSONObject elem, Map<String, String> memoryMap) {
		String reqMask = (String) elem.get("request");
		String replyMask = (String) elem.get("reply");
		double mood = ((Number)elem.get("mood")).doubleValue();
		this.mood = mood;
		this.requestMask = new RequestMaskImpl(Utils.constructReqMask(reqMask, memoryMap));
		this.replyMask = new ReplyMaskImpl(Utils.constructReplyMask(replyMask, memoryMap));
	}
	public MaskPair() {}
	
	public ReplyMask getReplyMask() {
		return replyMask;
	}
	public void setReplyMask(ReplyMask replyMask) {
		this.replyMask = replyMask;
	}
	public RequestMask getRequestMask() {
		return requestMask;
	}
	public void setRequestMask(RequestMask requestMask) {
		this.requestMask = requestMask;
	}
	public double getMood() {
		return mood;
	}
	public void setMood(double mood) {
		this.mood = mood;
	}
}