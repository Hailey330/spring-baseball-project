package com.cos.baseballproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.baseballproject.domain.player.PlayerRepository;
import com.cos.baseballproject.domain.team.TeamRepository;
import com.cos.baseballproject.service.PlayerService;
import com.cos.baseballproject.web.dto.SaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OutplayerController {

	private final PlayerService playerService;
	private final TeamRepository teamRepository;
	
	@GetMapping("/outplayer")
	public String playerList(Model model) {
		model.addAttribute("playerlist", playerService.선수목록());
		model.addAttribute("allTeam", teamRepository.findAll());
		return "outplayerList";
	}
	
	@GetMapping("/outplayer/list/{teamId}")
	public String playerTeamList(@PathVariable int teamId, Model model) {
		model.addAttribute("playerlist", playerService.선수팀목록(teamId));
		model.addAttribute("allTeam", teamRepository.findAll());
		return "outplayerList";
	}
	
	@PostMapping("/outplayer/save")
	public String mainSaveOutPlayerForm(SaveReqDto saveReqDto) {
		playerService.퇴출선수등록하기(saveReqDto);
		return "redirect:/player/list";
	}
}
