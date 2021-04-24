package com.taek.games.lotto;

import static com.taek.games.lotto.LottoConstant.LOTTO_MAX_NUMBER;
import static com.taek.games.lotto.LottoConstant.LOTTO_MIN_NUMBER;
import static com.taek.games.lotto.LottoConstant.LOTTO_NUMBERS_SIZE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LottoGenerator {
	
	private Set<Integer> lottoNumbers;
	
	public LottoGenerator() {
		lottoNumbers = new HashSet<>();
		generate();
	}
	
	private void generate() {
		Random random = new Random();
		while (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
			lottoNumbers.add(LOTTO_MIN_NUMBER + random.nextInt(LOTTO_MAX_NUMBER));
		}
	}
	
	public List<Integer> get() {
		return new ArrayList<>(lottoNumbers);
	}

}
