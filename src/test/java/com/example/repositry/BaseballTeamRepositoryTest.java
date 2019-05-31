package com.example.repositry;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.BaseballTeam;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseballTeamRepositoryTest {

	@Autowired
	private BaseballTeamRepository repository;

	@Test
	public void testFindAll() {
		List<BaseballTeam> baseballTeamList = repository.findAll();
	
		assertThat("サイズが一致しません",baseballTeamList.size(),is(6));
		assertThat("発足順になっていません",baseballTeamList.get(0).getTeamName(),is("読売ジャイアンツ"));
		assertThat("発足順になっていません",baseballTeamList.get(5).getTeamName(),is("東京ヤクルトスワローズ"));
		
		System.out.println("全件検索するテスト終了");
	}
	
	@Test
	public void testLoad() {
		BaseballTeam baseballTeam = repository.load(1);
		assertThat("取得情報が一致しません", baseballTeam.getTeamName(), is("読売ジャイアンツ"));		
		baseballTeam = repository.load(6);
		assertThat("取得情報が一致しません", baseballTeam.getTeamName(), is("東京ヤクルトスワローズ"));
		baseballTeam = repository.load(3);
		assertThat("取得情報が一致しません", baseballTeam.getTeamName(), is("中日ドラゴンズ"));	
		
		System.out.println("主キー検索するテスト終了");
	}

}
