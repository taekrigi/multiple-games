package com.taek.games.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taek.games.ladder.Ladder;
import com.taek.games.ladder.LadderGenerator;

@RestController
@RequestMapping("ladder")
public class LadderController {

	@GetMapping
	public int[][] getLadders() {
		new Ladder(Arrays.asList("A", "B", "C", "D", "E")).prettyPrint();
		return new Ladder(Arrays.asList("A", "B", "C", "D", "E")).getLadders();
	}
}
