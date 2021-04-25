package com.taek.games.controller;

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
		new Ladder(new LadderGenerator(null, 5)).prettyPrint();
		return new Ladder(new LadderGenerator(null, 5)).getLadders();
	}
}
