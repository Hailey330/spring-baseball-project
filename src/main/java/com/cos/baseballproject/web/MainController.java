package com.cos.baseballproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.baseballproject.service.MainService;
import com.cos.baseballproject.web.dto.SaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {
	
	private final MainService mainService;
	
	@GetMapping("/main")
	public String mainForm(Model model) {
		model.addAttribute("teamlist", mainService.팀불러오기());
		return "saveForm";
	}
	
	@PostMapping("/main/save")
	public String mainSaveForm(SaveReqDto saveReqDto) {
		mainService.홈구장등록하기(saveReqDto);
		return "redirect:/main";
	}
	
	@PostMapping("/main/save/player")
	public String mainSavePlayerForm(SaveReqDto saveReqDto) {
		System.out.println("team name 확인 : " + saveReqDto.getTeamName());
		mainService.선수등록하기(saveReqDto);
		return "redirect:/main";
	}
}
