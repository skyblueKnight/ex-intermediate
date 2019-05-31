package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.BaseballTeam;
import com.example.repositry.BaseballTeamRepository;

/**
 * 野球チーム一覧・詳細情報表示をするサービス.
 * 
 * @author momoyo kanie
 */
@Service
public class BaseballTeamService {

	@Autowired
	private BaseballTeamRepository repository;

	/**
	 * 全件検索を行う.
	 * 
	 * @return 野球チーム情報一覧
	 */
	public List<BaseballTeam> showList() {
		return repository.findAll();
	}

	/**
	 * 主キー検索を行う.
	 * 
	 * @param id 検索するID
	 * @return 取得した野球チーム情報
	 */
	public BaseballTeam showDetail(int id) {
		return repository.load(id);
	}

}
