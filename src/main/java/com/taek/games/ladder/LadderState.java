package com.taek.games.ladder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LadderState {
	
	private int row;
	private int col;
	private LadderDirection prevDirection;
	
	public LadderState(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public LadderState(int row, int col, LadderDirection prevDirection) {
		this.row = row;
		this.col = col;
		this.prevDirection = prevDirection;
	}
}
