package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.HotelInfo;
import com.example.service.SearchHotelInfoService;

/**
 * ホテル検索を行うコントローラ.
 * 
 * @author momoyo kanie
 */
@Controller
@RequestMapping("/hotel")
public class SearchHotelInfoController {
	
	@Autowired
	private SearchHotelInfoService service;

	/**
	 * ホテル情報検索画面に遷移する.
	 * 
	 * @return ホテル情報検索画面
	 */
	@RequestMapping("")
	public String index() {

		return "search-hotel";
	}
	
	
	/**
	 * 入力された価格以下のホテルを検索して、表示画面に遷移する.<br>
	 * 入力された値が空(null)なら全件検索を行う。
	 * 入力された値が0以下または数値以外ならエラーメッセージを表示させる。
	 * 
	 * @param price 検索する価格
	 * @param model モデル
	 * @return ホテル情報検索画面
	 */
	@RequestMapping("/search-hotel-info")
	public String searchHotelInfo(String price, Model model) {
		
//		if(price<0) {
//			model.addAttribute("error","0以上の値を入力してください");
//		}
		
		List<HotelInfo> hotelInfoList;
		return "search-hotel";
		
		
		
	}

}
