package com.cos.baseballproject.domain.team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer>{

	public Team findByName(String name);
}
