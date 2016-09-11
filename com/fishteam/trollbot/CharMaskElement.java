package com.fishteam.trollbot;

import java.util.List;

import com.fishteam.trollbot.interfaces.EvalMaskElement;


public class CharMaskElement implements EvalMaskElement{
	private char character;
	@Override
	public boolean match(List<CharMaskElement> chars) {
		return chars.size()==1&&chars.get(0).getCharacter()==character;
	}
	public char getCharacter() {
		return character;
	}
	public void setCharacter(char character) {
		this.character = character;
	}
	public boolean isLetter(){
		//TODO improve
		return true;
	}
	@Override
	public String toString() {
		return ""+character;
	}
	@Override
	public String eval() {
		return toString();
	}
}
