package com.fishteam.trollbot;

import java.util.Random;
import java.util.Scanner;

import com.fishteam.trollbot.interfaces.Bot;

public class BotProgram extends Thread{
	private static final int MAX_SLEEP = 4000;
	private static final int MIN_SLEEP = 100;
	private Bot bot;
	public BotProgram(Bot bot) {
		super();
		this.bot = bot;
	}
	@Override
	public void run() {
		System.out.println("��� ��� TrollBot!");
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		while(true){
			String phrase = scanner.nextLine();
			try {
				Thread.sleep(random.nextInt(MAX_SLEEP-MIN_SLEEP)+MIN_SLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(bot.reply(phrase));
		}
	}
}
