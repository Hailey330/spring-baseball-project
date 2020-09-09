package com.cos.baseballproject.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseballproject.domain.player.Player;
import com.cos.baseballproject.domain.player.PlayerRepository;
import com.cos.baseballproject.domain.stardium.Stardium;
import com.cos.baseballproject.domain.stardium.StardiumRepository;
import com.cos.baseballproject.domain.team.Team;
import com.cos.baseballproject.domain.team.TeamRepository;
import com.cos.baseballproject.web.dto.SaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MainService {

	private final StardiumRepository stardiumRepository;
	private final TeamRepository teamRepository;
	private final PlayerRepository playerRepository;
	
	@Transactional
	public void 홈구장등록하기(SaveReqDto saveReqDto) {
		
		Stardium stardiumEntity = Stardium.builder().zone(saveReqDto.getStardiumName()).build();
		stardiumRepository.save(stardiumEntity);
		
		Team teamEntity = Team.builder().stardium(stardiumEntity).name(saveReqDto.getTeamName()).build();
		teamRepository.save(teamEntity);
	}
	
	@Transactional
	public List<Team> 팀불러오기() {
		List<Team> teamEntity = teamRepository.findAll();
		return teamEntity;
	}
	
	@Transactional
	public void 선수등록하기(SaveReqDto saveReqDto) {
		
		Team teamEntity = teamRepository.findByName(saveReqDto.getTeamName());
		System.out.println("teamEntity : " + teamEntity);
		
		Player playerEntity = Player.builder()
				.name(saveReqDto.getPlayerName())
				.playerNumber(saveReqDto.getPlayerNumber())
				.position(saveReqDto.getPlayerPosition())
				.team(teamEntity)
				.build();
		
		playerRepository.save(playerEntity);
	}
	
}
