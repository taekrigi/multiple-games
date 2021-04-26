package com.taek.games.ladder;

import java.util.Random;
import java.util.function.Consumer;

public class LadderGenerator {

	private int row = 10;
	private int col;
	private int[][] ladders;

	public LadderGenerator(int row, int col) {
		this.row = row;
		this.col = col;
		ladders = new int[row][col];
		generate();
	}
	
	public int[][] getLadders() {
		return ladders;
	}
	
	private void generate() {
		Consumer<Integer> road = setRoad(ladders);
		for (int i = 0; i < row; i++) {
			road.accept(i);
			for (int j = 0; j < col; j++) {
				if (j % 2 == 0) {
					ladders[i][j] = 1;
				}
			}
		}
	}

	private Consumer<Integer> setRoad(int[][] ladders) {
		Random random = new Random();
		int[] targets = generateRandomTargets();
		
		return row -> {
			int col = targets[random.nextInt(targets.length)];
			if (row == 0 || 
				row == this.row - 1 ||
				ladders[row - 1][col] == 1 ||
				ladders[row + 1][col] == 1) return;
			
			ladders[row][col] = 1;
			
		};
	}
	
	private int[] generateRandomTargets() {
		int[] targets = new int[col / 2];
		for (int i = 0, start = 1; i < col / 2; i++, start+=2) {
			targets[i] = start;
		}
		return targets;
	}
}
