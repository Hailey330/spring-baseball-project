package com.cos.baseballproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseballproject.service.TeamService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamController {

	private final TeamService teamService;

	@GetMapping("/team/list")
	public String teamList(Model model) {
		model.addAttribute("team", teamService.팀목록());
		return "teamList";
	}
	
	@DeleteMapping("/team/del/{id}")
	public @ResponseBody int teamListDelete(@PathVariable int id) {
		teamService.삭제하기(id);
		return id;
	}
}
