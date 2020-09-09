package com.cos.baseballproject.domain.player;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

	public Player findByName(String name);

}
