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
	private LadderGenerator ladderGenerator;
	private int[][] ladders;
	
	public Ladder(List<String> participants) {
		this.participants = participants;
		this.answers = generateAnswers();
		this.ladderGenerator = new LadderGenerator(10, participants.size() * 2 - 1);
		this.ladders = ladderGenerator.getLadders();
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
	
	public void getAnswer(String participant) {
		int index = participants.indexOf(participant);
		LadderState ladderState = new LadderState(1, index * 2, LadderDirection.DOWN);
		
		for (int i = 0; i < ladders.length; i++) {
			if (ladderState.getPrevDirection() != LadderDirection.LEFT &&
				ladderState.getCol() - 1 >= 0 && 
				ladders[ladderState.getRow()][ladderState.getCol() - 1] == 1
			) {
				ladderState.setCol(ladderState.getCol() - 1);
				ladderState.setPrevDirection(LadderDirection.LEFT);
			}
			else if (
				ladderState.getPrevDirection() != LadderDirection.RIGHT &&
				ladderState.getCol() + 1 <= ladderGenerator.getCol() - 1 &&
				ladders[ladderState.getRow()][ladderState.getCol() + 1] == 1
			) {
				ladderState.setCol(ladderState.getCol() + 1);
				ladderState.setPrevDirection(LadderDirection.RIGHT);
			} 
			else {
				ladderState.setRow(ladderState.getRow() + 1);
				ladderState.setPrevDirection(LadderDirection.DOWN);
			}
			
			if (i == ladders.length - 1) {
				System.out.println(ladderState.getCol());
			}
		}
	}
	
	private List<Boolean> generateAnswers() {
		int randomNumber = new Random().nextInt(participants.size());
		return IntStream.range(0, participants.size())
				.mapToObj(i -> i == randomNumber)
				.collect(Collectors.toList());
	}
}
