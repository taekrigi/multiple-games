package com.taek.games.ladder;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Ladder {
	
	private List<String> participants;
	private List<Boolean> answers;
	private int[][] ladders;
	
	public Ladder(List<String> participants) {
		this.participants = participants;
		this.answers = generateAnswers();
		this.ladders = new LadderGenerator(10, participants.size() * 2 - 1).getLadders();
	}
	
	public void prettyPrint() {
		for (String participant : participants) {
			System.out.print(participant + "   ");
		}
		System.out.println();
		
		for (int i = 0; i < ladders.length; i++) {
			for (int j = 0; j < ladders[i].length; j++) {
				System.out.print(ladders[i][j] + " ");
			}
			System.out.println();
		}
		
		for (Boolean answer : answers) {
			System.out.print((answer ? "O" : "X") + "   ");
		}
	}
	
	public int[][] getLadders() {
		return ladders;
	}
	
	private List<Boolean> generateAnswers() {
		int randomNumber = new Random().nextInt(participants.size());
		return IntStream.range(0, participants.size())
				.mapToObj(i -> i == randomNumber)
				.collect(Collectors.toList());
	}
}
