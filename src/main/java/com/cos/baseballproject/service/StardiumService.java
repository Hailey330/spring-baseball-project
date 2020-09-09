package com.cos.baseballproject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseballproject.domain.stardium.Stardium;
import com.cos.baseballproject.domain.stardium.StardiumRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StardiumService {

	private final StardiumRepository stardiumRepository;
	
	@Transactional
	public List<Stardium> 홈구장목록() {
		List<Stardium> stardiumEntity = stardiumRepository.findAll();
		return stardiumEntity;
	}
	
	@Transactional
	public void 삭제하기(int id) {
		Stardium stardiumEntity = stardiumRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 포스팅이 없습니다. id = " + id));
		stardiumRepository.delete(stardiumEntity);
	}
}
