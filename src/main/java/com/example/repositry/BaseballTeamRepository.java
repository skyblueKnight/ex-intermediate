package com.example.repositry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.BaseballTeam;

/**
 * 野球チーム情報テーブル(teams)を操作するリポジトリ.
 * 
 * @author momoyo kanie
 *
 */
@Repository
public class BaseballTeamRepository {
	
	/**
	 * BaseBallTeamオブジェクトを返すRowMapper. 
	 */
	private final static RowMapper<BaseballTeam> BASEBALL_TEAM_ROW_MAPPER = (rs,i) ->{
		BaseballTeam baseballTeam = new BaseballTeam();
		baseballTeam.setId(rs.getInt("id"));
		baseballTeam.setTeamName(rs.getString("team_name"));		
		baseballTeam.setHeadquarters(rs.getString("headquarters"));		
		baseballTeam.setInauguration(rs.getString("inauguration"));		
		baseballTeam.setHistory(rs.getString("history"));		
		baseballTeam.setLeagueName(rs.getString("leagueName"));		
		
		return baseballTeam;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	

	
	/**
	 * 全件検索を行う.
	 * 
	 * @return 野球チーム情報一覧
	 */
	public List<BaseballTeam> findAll(){
		
		String sql ="SELECT id, team_name, headquarters, inauguration, history, league_name FROM teams;";
		List<BaseballTeam> baseballTeamList = template.query(sql, BASEBALL_TEAM_ROW_MAPPER);
		
		return baseballTeamList;
	}
	
	
}
