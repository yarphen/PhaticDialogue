package com.fishteam.trollbot;

import com.fishteam.trollbot.interfaces.Bot;
import com.fishteam.trollbot.interfaces.Matches;
import com.fishteam.trollbot.interfaces.ReplyDictionary;
import com.fishteam.trollbot.interfaces.ReplyFilter;

/**
 * TrollBot is the only implementation
 * of Bot interface in our program.
 * It includes bot's status, dictionary
 * of mask pairs, and filter for replies.
 */
public class TrollBot implements Bot {
	private static final String NO_PHRASE_FOUND = "Запитайте щось простіше, будь ласка.";
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
	/**
	 * Wheaser bot understands different cases for words
     */
	private boolean caseSensitivePhrases;

	public TrollBot(BotStatus status, ReplyDictionary dictionary,
			ReplyFilter filter, boolean caseSensitivePhrases) {
		super();
		this.status = status;
		this.dictionary = dictionary;
		this.filter = filter;
		this.caseSensitivePhrases = caseSensitivePhrases;
	}

	@Override
	public String reply(String phrase) {
		Iterable<MaskPair> pairs = dictionary.findMasks(phrase, this.caseSensitivePhrases);
		status.react(Math.random()*3.5+0.5);
		MaskPair bestPair = filter.findBestMask(pairs, status);
		if (bestPair!=null){
			Matches matches = bestPair.getRequestMask().match(phrase, this.caseSensitivePhrases);
			return bestPair.getReplyMask().process(matches);
		}else{
			return NO_PHRASE_FOUND;
		}
	}

	@Override
	public boolean isDead() {
		return status.getMood()<=0.55;
	}

}
