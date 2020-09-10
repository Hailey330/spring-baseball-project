package com.cos.baseballproject.domain.player;

import java.sql.Timestamp;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SqlResultSetMapping;

import com.cos.baseballproject.domain.team.Team;
import com.cos.baseballproject.web.dto.OutplayerRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(
		name = "OutplayerRespDtoMapping",
		classes = @ConstructorResult(
				targetClass = OutplayerRespDto.class,
				columns = {
						@ColumnResult(name="playerNumber", type = Integer.class),
						@ColumnResult(name="name", type = String.class),
						@ColumnResult(name="position", type = String.class),
						@ColumnResult(name="reason", type = String.class),
						@ColumnResult(name="createDate", type = Timestamp.class),
				}
		)
)


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int playerNumber;
	private String name;
	private String position;

	// 한 선수는 하나의 팀만 
	@ManyToOne
	@JoinColumn(name = "teamId")
	private Team team;

}
