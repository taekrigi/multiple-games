package com.taek.games.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.taek.games.lotto.LottoSort;

public class LottoStringToEnumConverter implements Converter<String, LottoSort> {

	@Override
	public LottoSort convert(String source) {
		try {
			return LottoSort.valueOf(source.toUpperCase());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}
