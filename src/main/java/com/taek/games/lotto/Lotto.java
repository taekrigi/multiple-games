package com.taek.games.lotto;

import static com.taek.games.lotto.LottoConstant.LOTTO_MAX_NUMBER;
import static com.taek.games.lotto.LottoConstant.LOTTO_MIN_NUMBER;
import static com.taek.games.lotto.LottoConstant.LOTTO_NUMBERS_SIZE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.taek.games.lotto.error.LottoNumberDuplicationException;
import com.taek.games.lotto.error.LottoNumberNotValidException;
import com.taek.games.lotto.error.LottoSizeNotValidException;

public class Lotto {
	
	private final List<Integer> lottoNumbers;
	
	public Lotto() {
		this.lottoNumbers = new LottoGenerator().get();
	}
	
	public Lotto(List<Integer> lottoNumbers) throws Exception {
		validateSize(lottoNumbers);
		validateDuplication(lottoNumbers);
		validateNumber(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}
	
	private void validateSize(Collection<Integer> lottoNumbers) throws LottoSizeNotValidException {
		if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
			throw new LottoSizeNotValidException("로또 번호는 6개만 가능합니다.");
		}
	}
	
	private void validateDuplication(List<Integer> lottoNumbers) throws LottoNumberDuplicationException {
		Set<Integer> nonDuplicatedNumbers = new HashSet<>(lottoNumbers);
		if (nonDuplicatedNumbers.size() != LOTTO_NUMBERS_SIZE) {
			throw new LottoNumberDuplicationException("로또 번호는 중복될 수 없습니다.");
		}
	}
	
	private void validateNumber(List<Integer> lottoNumbers) throws LottoNumberNotValidException {
		if (!lottoNumbers.stream().allMatch(n -> LOTTO_MIN_NUMBER <= n && n <= LOTTO_MAX_NUMBER)) {
			throw new LottoNumberNotValidException(
				String.format(
					"로또 번호는 %d 이상, %d 이하의 숫자여야 합니다.",
					LOTTO_MIN_NUMBER, 
					LOTTO_MAX_NUMBER
				)
			);
		}
	}
	
	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
	}
	
	public List<Integer> getLottoNumbersOrderByNumber(LottoSort lottoSort) {
		return lottoNumbers.stream()
				.sorted(lottoSort.getComparator())
				.collect(Collectors.toList());
	}
	
	public Map<Integer, List<Integer>> getLottoNumbersByDigit() {
		Map<Integer, List<Integer>> lottoNumbersByDigit = new HashMap<>();
		
		for (int number : lottoNumbers) {
		    int key = getDigitKeyByNumber(number);
			List<Integer> numbers = lottoNumbersByDigit.getOrDefault(getDigitKeyByNumber(number), new ArrayList<>());
			numbers.add(number);
			lottoNumbersByDigit.put(key, numbers);
		}
		
		return lottoNumbersByDigit;
	}
	
	public Map<Integer, List<Integer>> getLottoNumbersByDigitOrderByDigit(LottoSort lottoSort) {
		return new TreeMap<>(getLottoNumbersByDigit());
	}
	
	private int getDigitKeyByNumber(int number) {
		if (number < 10) return 1;
		
		StringBuilder strNumber = new StringBuilder(String.valueOf(number));
		strNumber.setCharAt(strNumber.length() - 1, '0');
		
		return Integer.parseInt(strNumber.toString());
	}
}
