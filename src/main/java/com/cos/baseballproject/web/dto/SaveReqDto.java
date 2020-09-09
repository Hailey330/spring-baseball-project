package com.cos.baseballproject.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveReqDto {
	private String stardiumName;
	private String teamName;
	private String playerName;
	private int playerNumber;
	private String playerPosition;
	private String reason;
}
