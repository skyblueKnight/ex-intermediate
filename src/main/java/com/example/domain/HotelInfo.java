package com.example.domain;

/**
 * ホテル情報を格納するドメイン.
 * 
 * @author momoyo kanie
 *
 */
public class HotelInfo {
	
	/** ID */
	private Integer id;
	/** 所在エリア　*/
	private String arealName;
	/** ホテル名　*/
	private String hotelName;
	/** 所在地　*/
	private String address;
	/** 最寄り駅　*/
	private String nearestStation;
	/** 価格 */
	private Integer price;
	/** 駐車場の有無　*/
	private String parking;
	
	
	// ----- setter getter ----- //
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getArealName() {
		return arealName;
	}
	public void setArealName(String arealName) {
		this.arealName = arealName;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNearestStation() {
		return nearestStation;
	}
	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	
	
}
