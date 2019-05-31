package com.example.repositry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.HotelInfo;

/**
 * ホテル情報一覧テーブル（hotels）を操作するリポジトリ.
 * 
 * @author momoyo kanie
 *
 */
@Repository
public class SearchHotelInfoRepository {

	/**
	 * ホテル情報ドメインを返すRowMapper.
	 */
	private final static RowMapper<HotelInfo> HOTEL_INFO_ROW_MAPPER = (rs, i) -> {
		HotelInfo hotelInfo = new HotelInfo();
		hotelInfo.setId(rs.getInt("id"));
		hotelInfo.setArealName(rs.getString("area_name"));
		hotelInfo.setHotelName(rs.getString("hotel_name"));
		hotelInfo.setAddress(rs.getString("address"));
		hotelInfo.setNearestStation(rs.getString("nearest_station"));
		hotelInfo.setPrice(rs.getInt("price"));
		hotelInfo.setParking(rs.getString("parking"));

		return hotelInfo;
	};

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * 全件検索を行う.
	 * 
	 * @return 取得したホテル情報一覧
	 */
	public List<HotelInfo> findAll() {

		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking" + " FROM hotels"
				+ " ORDER BY price DESC;";
		List<HotelInfo> hotelInfoList = template.query(sql, HOTEL_INFO_ROW_MAPPER);

		return hotelInfoList;
	}

	/**
	 * 価格からホテル情報を検索する.<br>
	 * 受け取った価格"以下"のホテル情報を取得する。 何も取得しなかった場合は空のリストを返す。
	 * 
	 * @param price 検索する価格
	 * @return 取得したホテル情報一覧 / 情報がなかった場合は 空のリスト
	 */
	public List<HotelInfo> findByPrice(int price) {

		List<HotelInfo> hotelInfoList;
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking" + " FROM hotels"
				+ " WHERE price<=:price"
				+ " ORDER BY price DESC;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);

		hotelInfoList = template.query(sql, param, HOTEL_INFO_ROW_MAPPER);
		return hotelInfoList;
	}

}
