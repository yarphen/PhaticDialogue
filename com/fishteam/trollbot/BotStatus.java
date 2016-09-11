package com.fishteam.trollbot;

import java.lang.*;

/** Used to monitore Trollbot's mood.
*	The current mood is used to determine how friendly
*	or neutral Trollbot's response to the user is.
*	Things like swearwords or words of thanks can shift
*	the bot's mood drastically.
*/
public class BotStatus {
	
	/** Trollbot's current disposition */
	private double mood;
	
	public BotStatus(double initialMood) {
		mood = initialMood;
		if (mood<0.5)			mood=1.0;
		if (mood>4.0)			mood=4.0;
	}
	
	/** Reaction to user input. Trollbot's mood will change */
	public void react(double userMood) {
		if (userMood==mood)	return;
		
		// Trollbot's mood changes by the absolute value of the differense between it's and user's mood
		double diff = Math.abs(mood-userMood);
		
		if (userMood>mood) {
			// Positive responses always cheer Trollbot up
			if (userMood>2.0) {
				mood+=diff;
			}
			// Negative responses worsen Trollbot's mood unless it can't get any worse at this point
			else {
				if ((mood-diff)<=0.5) 	mood=0.5; //the bot's mood can't get any worse than 0,5
				else					mood-=diff;
			}
		}
		else {
			if (userMood>2.0) {
				if ((mood+diff)>=4.0) 	mood=4.0; //the bot's mood can't get any better than 4,0
				else					mood+=diff;
			}	
			else {
				mood-=diff;
			}
		}
	}
	
	/** Writes moods and their numerical values to the console */
	public void showMoodChart() {
		System.console().writer().println("enthusiastic 4.0");
		System.console().writer().println("cheerful 	3.5");
		System.console().writer().println("conservative 3.0");
		System.console().writer().println("bored 		2.5");
		System.console().writer().println("antagonistic 2.0");
		System.console().writer().println("angry 		1.5");
		System.console().writer().println("fearful 		1.0");
		System.console().writer().println("apathetic 	0.5");
	}
	
	/** Returns Trollbot's current mood */
	public double getMood() {
		return mood;
	}
	
	/** Changes Trollbots mood according to the Tone Scale */
	public void setMood(double mood) {
		this.mood = mood;
	}
}
