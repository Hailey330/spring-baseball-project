package com.cos.baseballproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseballproject.service.StardiumService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class StardiumController {
	
	private final StardiumService stardiumService;
	
	@GetMapping("/stardium/list")
	public String stardiumList(Model model) {
		model.addAttribute("stardium", stardiumService.홈구장목록());
		return "stardiumList";
	}
	
	@DeleteMapping("/stardium/del/{id}")
	public @ResponseBody int stardiumListDelete(@PathVariable int id) {
		stardiumService.삭제하기(id);
		return id;
	}
}
