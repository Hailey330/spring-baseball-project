package com.cos.baseballproject.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.cos.baseballproject.web.dto.OutplayerRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OutplayerService {
	
	@PersistenceContext // DB Connection 할 수 있는 entity 객체를 넘겨줌
	private EntityManager em; // Entity로 매핑해줌

	public List<OutplayerRespDto> 퇴출선수리스트(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("select p.playerNumber, p.name, p.position, o.reason, o.createDate ");
		sb.append("from player p left join outplayer o ");
		sb.append("on p.id = o.playerId");
		String q = sb.toString();
		
		Query query = em.createNativeQuery(q, "OutplayerRespDtoMapping");
		List<OutplayerRespDto> outplayerRespDto = query.getResultList();
				
		return outplayerRespDto;
	}
	
}
