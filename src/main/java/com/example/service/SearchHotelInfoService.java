package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.HotelInfo;
import com.example.repositry.SearchHotelInfoRepository;

/**
 * ホテル情報検索を行うサービス.
 * 
 * @author momoyo kanie
 */
@Service
public class SearchHotelInfoService {

	@Autowired
	private SearchHotelInfoRepository repository;
	
	
	/**
	 * 全件検索を行う.
	 * 
	 * @return 取得したホテル情報一覧
	 */
	public List<HotelInfo> searchAll(){
		return repository.findAll();
	}
	
	
	/**
	 * 価格から検索を行う.
	 * 
	 * @param price 検索する価格
	 * @return 取得したホテル情報一覧
	 */
	public List<HotelInfo> searchByPrice(int price){
		return repository.findByPrice(price);
	}

}
