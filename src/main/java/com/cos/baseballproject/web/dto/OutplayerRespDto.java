package com.cos.baseballproject.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutplayerRespDto {
	private int id;
	private int playerNumber;
	private String name;
	private String position;
	private String reason;
	private String createDate;
}
