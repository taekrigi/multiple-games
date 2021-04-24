package com.taek.games.lotto;

import java.util.Comparator;

public enum LottoSort {

	ASC((a1, a2) -> a1 - a2),
	DESC((a1, a2) -> a2 - a1)
	
	;
	
	private Comparator<Integer> comparator;
	
	LottoSort(Comparator<Integer> comparator) {
		this.comparator = comparator;
	}
	
	public Comparator<Integer> getComparator() {
		return comparator;
	}
}
