package com.fishteam.trollbot;

/** Used to monitore Trollbot's mood.
*	The current mood is used to determine how friendly
*	or neutral Trollbot's response to the user is.
*	Things like swearwords or words of thanks can shift
*	the bot's mood drastically.
*/
public class BotStatus {
	
	/** Trollbot's current disposition.  */
	private double mood;
	
	public BotStatus(double initialMood) {
		mood = initialMood;
		if mood<0.5			mood=1.0;
		if mood>4.0			mood=4.0;
	}
	
	/** Reaction to friendly user input */
	public void answerPoliteResponse() {
		if mood>=0.5 && mood<=3.5	mood+=0.5;
		else if mood<0.5			mood=1.0;
		else if mood>4.0			mood=4.0;
	}
	
	/** Reaction to rude user input */
	public void answerImpoliteResponse() {
		if mood>=1.0 && mood<=4.0	mood-=0.5;
		else if mood<0.5			mood=0.5;
		else if mood>4.0			mood=3.5;
	}
	
	/** Reaction to extremely innapropriate user input, 
	*	i.e. heavy swearing, calling your mom fat etc. */
	public void answerOffensiveResponse() {
		if mood>=1.5 && mood<=4.0	mood-=1.0;
		else if mood<1.5			mood=0.5;
		else if mood>4.0			mood=3.0;
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
