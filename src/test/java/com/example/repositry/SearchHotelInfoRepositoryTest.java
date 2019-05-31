package com.example.repositry;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.HotelInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchHotelInfoRepositoryTest {

	@Autowired
	private SearchHotelInfoRepository repository;	
	
	@Test
	public void testFindAll() {
		
		List<HotelInfo> hotelInfoList = repository.findAll();
		
		assertThat("データ件数が一致しません",hotelInfoList.size(),is(5));
		assertThat("価格順になっていません",hotelInfoList.get(0).getHotelName(),is("パレスホテル東京"));
		assertThat("価格順になっていません",hotelInfoList.get(4).getHotelName(),is("ホテルローズガーデン新宿"));
	
		System.out.println("全件検索テスト終了");
	}
	
	@Test
	public void testFindByPrice() {
		
		List<HotelInfo> hotelInfoList;
		hotelInfoList = repository.findByPrice(4999);
		assertThat("「4999円」時のデータ件数が一致しません",hotelInfoList.size(),is(0));
		hotelInfoList = repository.findByPrice(20001);
		assertThat("「20001円」時のデータ件数が一致しません",hotelInfoList.size(),is(5));
		hotelInfoList = repository.findByPrice(5000);
		assertThat("「5000円」時のデータ件数が一致しません",hotelInfoList.size(),is(1));
		assertThat("「5000円」時の取得データが一致しません",hotelInfoList.get(0).getHotelName(),is("ホテルローズガーデン新宿"));
		hotelInfoList = repository.findByPrice(20000);
		assertThat("「20000円」時のデータ件数が一致しません",hotelInfoList.size(),is(5));
		assertThat("価格順になっていません",hotelInfoList.get(0).getHotelName(),is("パレスホテル東京"));
		assertThat("価格順になっていません",hotelInfoList.get(4).getHotelName(),is("ホテルローズガーデン新宿"));
		hotelInfoList = repository.findByPrice(15000);
		assertThat("「15000円」時のデータ件数が一致しません",hotelInfoList.size(),is(4));
		assertThat("価格順になっていません",hotelInfoList.get(0).getHotelName(),is("東京ベイ舞浜ホテル"));
		assertThat("価格順になっていません",hotelInfoList.get(3).getHotelName(),is("ホテルローズガーデン新宿"));

		System.out.println("価格検索テスト終了");
	}

}
