package com.cos.baseballproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.baseballproject.service.PlayerService;
import com.cos.baseballproject.web.dto.SaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OutplayerController {

	private final PlayerService playerService;
	
	@GetMapping("/outplayer")
	public String teamList(Model model) {
		model.addAttribute("playerlist", playerService.선수목록());
		return "outplayerList";
	}
	
	@PostMapping("/outplayer/save")
	public String mainSaveOutPlayerForm(SaveReqDto saveReqDto) {
		playerService.퇴출선수등록하기(saveReqDto);
		return "redirect:/player/list";
	}
}
