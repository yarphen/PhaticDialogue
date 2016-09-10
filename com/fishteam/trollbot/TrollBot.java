package com.fishteam.trollbot;

/**
 * TrollBot is the only implementation
 * of Bot interface in our program.
 * It includes bot's status, dictionary
 * of mask pairs, and filter for replies.
 */
public class TrollBot implements Bot {
	/**
	 * Bot's status includes bot's state,
	 * is expected to save something like mood 
	 */
	private BotStatus status;
	/**
	 * Dictionary make the bot able to know 
	 * sample phrases and so
	 */
	private ReplyDictionary dictionary;
	/**
	 * Filter is purposed to find the best
	 * answer to the customer's phrase
	 */
	private ReplyFilter filter;
	@Override
	public String reply(String phrase) {
		Iterable<MaskPair> pairs = dictionary.findMasks(phrase);
		MaskPair bestPair = filter.findBestMask(pairs, status);
		Matches matches = bestPair.getRequestMask().match(phrase);
		return bestPair.getReplyMask().process(matches);
	}

}
