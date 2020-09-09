package com.cos.baseballproject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseballproject.domain.stardium.Stardium;
import com.cos.baseballproject.domain.team.Team;
import com.cos.baseballproject.domain.team.TeamRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class TeamService {

	private final TeamRepository teamRepository;
	
	@Transactional
	public List<Team> 팀목록() {
		List<Team> teamEntity = teamRepository.findAll();
		return teamEntity;
	}
	
	@Transactional
	public void 삭제하기(int id) {
		Team teamEntity = teamRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 팀이 없습니다. id = " + id));
		teamRepository.delete(teamEntity);
	}
}
