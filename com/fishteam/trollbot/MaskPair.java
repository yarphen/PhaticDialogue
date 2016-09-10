package com.fishteam.trollbot;
/**
 * Pair of masks 
 */
public class MaskPair {
	private ReplyMask replyMask;
	private RequestMask requestMask;
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
}
