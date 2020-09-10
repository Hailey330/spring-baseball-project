package com.cos.baseballproject.domain.player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

	public Player findByName(String name);
	
	@Query(value = "select p.playerNumber, p.name, p.position, o.reason, o.createDate from player p left join outplayer o on p.id=o.playerId", nativeQuery = true)
	List<Player> mfindAll();

}
