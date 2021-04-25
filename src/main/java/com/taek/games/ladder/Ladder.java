package com.taek.games.ladder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Ladder {
	
	private int[][] ladders;
	
	public Ladder(LadderGenerator ladderGenerator) {
		this.ladders = ladderGenerator.getLadders();
	}
	
	public void prettyPrint() {
		for (int i = 0; i < ladders.length; i++) {
			for (int j = 0; j < ladders[i].length; j++) {
				System.out.print(ladders[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public int[][] getLadders() {
		return ladders;
	}
}
