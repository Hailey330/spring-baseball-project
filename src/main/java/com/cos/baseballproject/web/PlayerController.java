package com.cos.baseballproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseballproject.service.PlayerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {
	
	private final PlayerService playerService;
	
	@GetMapping("/player/list")
	public String teamList(Model model) {
		model.addAttribute("player", playerService.선수목록());
		return "playerList";
	}
	
	@DeleteMapping("/player/del/{id}")
	public @ResponseBody int playerListDelete(@PathVariable int id) {
		playerService.삭제하기(id);
		return id;
	}

}
