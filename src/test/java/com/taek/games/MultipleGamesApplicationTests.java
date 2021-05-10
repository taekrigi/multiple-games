package com.taek.games;

import com.taek.games.calculator.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MultipleGamesApplicationTests {

	@Test
	void testCalcuator() {
		new Calculator().calculate("3 + 2 / 5 - 3 * 2");
	}

}
