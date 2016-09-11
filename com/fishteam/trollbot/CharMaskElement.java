package com.fishteam.trollbot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.fishteam.trollbot.interfaces.EvalMaskElement;


public class CharMaskElement implements EvalMaskElement{
	private char character;
	private static final String LETTERS = "abcdefghijklmnopqrstuvwxyzàáâã´äåº¸æçè³¿éêëìíîïğñòôóõö÷øùşÿüúû'";
	private static final HashSet<Character> LETTERS_SET = new HashSet<Character>();
	static{
		char[]chars = LETTERS.toCharArray();
		char[]chars2 = LETTERS.toUpperCase().toCharArray();
		for(char c:chars){
			LETTERS_SET.add(c);
		}
		for(char c:chars2){
			LETTERS_SET.add(c);
		}
	}
	public CharMaskElement(char c) {
		setCharacter(c);
	}
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
		return LETTERS_SET.contains(character);
	}
	@Override
	public String toString() {
		return ""+character;
	}
	@Override
	public String eval() {
		return toString();
	}
	@Override
	public int hashCode() {
		final int prime = 101;
		int result = 1;
		result = prime * result + character;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharMaskElement other = (CharMaskElement) obj;
		if (character != other.character)
			return false;
		return true;
	}
}
