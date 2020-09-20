package com.cos.baseballproject.domain.outplayer;

import java.sql.Timestamp;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SqlResultSetMapping;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.baseballproject.domain.player.Player;
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
						@ColumnResult(name="id", type = Integer.class),
						@ColumnResult(name="playerNumber", type = Integer.class),
						@ColumnResult(name="name", type = String.class),
						@ColumnResult(name="position", type = String.class),
						@ColumnResult(name="reason", type = String.class),
						@ColumnResult(name="createDate", type = String.class)
				}
		)
)

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Outplayer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String reason;
	@CreationTimestamp
	private Timestamp createDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "playerId")
	private Player player;
	
}
