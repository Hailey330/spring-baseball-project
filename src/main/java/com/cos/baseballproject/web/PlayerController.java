package com.cos.baseballproject.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseballproject.domain.player.Player;
import com.cos.baseballproject.domain.player.PlayerRepository;
import com.cos.baseballproject.domain.team.TeamRepository;
import com.cos.baseballproject.service.OutplayerService;
import com.cos.baseballproject.service.PlayerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {
	
	private final PlayerService playerService;
	private final OutplayerService outPlayerService;
	private final TeamRepository teamRepository;
	
	@GetMapping("/player/list")
	public String playerList(Model model) {
		model.addAttribute("player", outPlayerService.퇴출선수리스트());
		model.addAttribute("allTeam", teamRepository.findAll());
		return "playerList";
	}
	
	@GetMapping("/player/list/{teamId}")
	public String playerTeamList(@PathVariable int teamId, Model model) {
		model.addAttribute("player", outPlayerService.퇴출선수팀리스트(teamId));
		model.addAttribute("allTeam", teamRepository.findAll());
		return "playerList";
	}
	
	@DeleteMapping("/player/del/{id}")
	public @ResponseBody int playerListDelete(@PathVariable int id) {
		playerService.삭제하기(id);
		return id;
	}

}
