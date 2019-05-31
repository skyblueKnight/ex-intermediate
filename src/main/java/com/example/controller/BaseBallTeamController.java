package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BaseballTeam;
import com.example.service.BaseballTeamService;

/**
 * 野球チーム一覧・詳細表示を行うコントローラ.
 * 
 * @author momoyo kanie
 */
@Controller
@RequestMapping("/baseball-team")
public class BaseBallTeamController {
	
	
	@Autowired
	private BaseballTeamService service;
	
	
	/**
	 * 野球チーム情報一覧を取得してから、チーム一覧表示画面に遷移する.
	 * 
	 * @param model モデル
	 * @return チーム一覧表示画面
	 */
	@RequestMapping("")
	public String index(Model model) {
		
		List<BaseballTeam> baseballTeamList = service.findAll();
		model.addAttribute("baseballTeamList",baseballTeamList);
		
		return "baseball-team-list";
	}
	
	
	/**
	 * 野球チームの詳細情報を取得してから、詳細表示画面に遷移する.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/get-details")
	public String getDetails(int id,Model model) {
		
		BaseballTeam baseballTeam = service.load(id);
		model.addAttribute("baseballTeam",baseballTeam);
		
		return "baseball-team-details";
	}
	
}
