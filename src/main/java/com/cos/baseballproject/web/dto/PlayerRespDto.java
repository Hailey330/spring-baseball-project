package com.cos.baseballproject.web.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerRespDto {
	private int no;
	private int playerNumber;
	private String name;
	private String position;
	private String reason;
	private Timestamp createDate;
}
