package com.cos.baseballproject.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseballproject.domain.Outplayer.Outplayer;
import com.cos.baseballproject.domain.Outplayer.OutplayerRepository;
import com.cos.baseballproject.domain.player.Player;
import com.cos.baseballproject.domain.player.PlayerRepository;
import com.cos.baseballproject.web.dto.OutplayerRespDto;
import com.cos.baseballproject.web.dto.SaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {
	
	@PersistenceContext // DB Connection 할 수 있는 entity 객체를 넘겨줌
	private EntityManager em; // Entity로 매핑해줌

	private final PlayerRepository playerRepository;
	private final OutplayerRepository outplayerRepository;
	
	@Transactional
	public List<Player> 선수목록() {
		// PlayerRespDto에 Player 정보 담고, outPlayer 정보도 같이 담아서 보낼 것!
		List<Player> playerEntity = playerRepository.mfindAll();
		System.out.println("playerEntity.get(0) 확인 : " + playerEntity.get(0));
		return playerEntity;
	}
	
	@Transactional
	public void 삭제하기(int id) {
		Player playerEntity = playerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 선수가 없습니다. id = " + id));
		playerRepository.delete(playerEntity);
	}
	
	@Transactional
	public void 퇴출선수등록하기(SaveReqDto saveReqDto) {
		Player playerEntity = playerRepository.findByName(saveReqDto.getPlayerName());
		System.out.println("퇴출 선수 : " + playerEntity);
		Outplayer outPlayerEntity = Outplayer.builder()
				.player(playerEntity)
				.reason(saveReqDto.getReason())
				.build();
		outplayerRepository.save(outPlayerEntity);
	}
}
