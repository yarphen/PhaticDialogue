package com.fishteam.trollbot;

import com.fishteam.trollbot.interfaces.ReplyMask;
import com.fishteam.trollbot.interfaces.RequestMask;

/**
 * Pair of masks 
 */
public class MaskPair {
	private ReplyMask replyMask;
	private RequestMask requestMask;
	private double mood;
	
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