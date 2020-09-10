package com.cos.baseballproject.web.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OutplayerRespDto {
	private int playerNumber;
	private String name;
	private String position;
	private String reason;
	private Timestamp createDate;
}
