package com.taek.games.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taek.games.lotto.Lotto;
import com.taek.games.lotto.LottoSort;

@RestController
@RequestMapping("lotto")
public class LottoController {

	@GetMapping
	public List<Integer> getLottoNumbers() {
		return new Lotto().getLottoNumbers();
	}
	
	@GetMapping("sort")
	public List<Integer> getLottoNumbersOrderByNumberAsc() {
		return new Lotto().getLottoNumbersOrderByNumber(LottoSort.ASC);
	}
	
	@GetMapping("sort/{lottoSort}")
	public List<Integer> getLottoNumbersOrderByNumber(@PathVariable("lottoSort") LottoSort lottoSort) {
		return new Lotto().getLottoNumbersOrderByNumber(lottoSort);
	}
	
	@GetMapping("digit")
	public Map<Integer, List<Integer>> getLottoNumbersByDigit() {
		return new Lotto().getLottoNumbersByDigit();
	}
	
	@GetMapping("digit/sort")
	public Map<Integer, List<Integer>> getLottoNumbersByDigitOrderByDigitAsc() {
		return new Lotto().getLottoNumbersByDigitOrderByDigit(LottoSort.ASC);
	}
	
	@GetMapping("digit/sort/{lottoSort}")
	public Map<Integer, List<Integer>> getLottoNumbersByDigitOrderByDigit(@PathVariable("lottoSort") LottoSort lottoSort) {
		return new Lotto().getLottoNumbersByDigitOrderByDigit(lottoSort);
	}
}
