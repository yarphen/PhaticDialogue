package com.fishteam.trollbot;

import java.util.Random;
import java.util.Scanner;

import com.fishteam.trollbot.interfaces.Bot;

public class BotProgram extends Thread{
	private static final int MAX_SLEEP = 4000;
	private static final int MIN_SLEEP = 100;
	private static final String BOT_NAME = "TrollBot";
	private Bot bot;
	public BotProgram(Bot bot) {
		super();
		this.bot = bot;
	}
	@Override
	public void run() {
		System.out.println("Вас вітає "+BOT_NAME+"! Поговоримо?");
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		while(true){
			System.out.print("Ви: ");
			String phrase = scanner.nextLine();
//			try {
//				Thread.sleep(random.nextInt(MAX_SLEEP-MIN_SLEEP)+MIN_SLEEP);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println(BOT_NAME+": "+bot.reply(phrase));
			if (bot.isDead())break;
		}
	}
}
