package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotels;


@Repository
public class HotelsRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	

	private static final RowMapper<Hotels> HOTELS_ROW_MAPPER
	 = (rs,i) -> {
		 Hotels hotels = new Hotels();
		 hotels.setId(rs.getInt("id"));
		 hotels.setAreaName(rs.getString("area_name"));
		 hotels.setHotelName(rs.getString("hotel_name"));
		 hotels.setAddress(rs.getString("address"));
		 hotels.setNearestStation(rs.getString("nearest_station"));
		 hotels.setPrice(rs.getInt("price"));
		 hotels.setParking(rs.getString("parking"));
		 
		 return hotels;
	 };
	 
	 
	 
	 public List<Hotels> findByPrice2(String price) {
		 
		 
		 String sql =
				 "select * from hotels";
		 

	 	 List<Hotels> hotelslist
	   = template.query(sql, HOTELS_ROW_MAPPER);
	 	 
	 	 return hotelslist;
	 }
	 
	 
	 
	 
	 public List<Hotels> findByPrice(Integer price) {
		
		 
		 String sql =
				 "select * from hotels where price <= :price";
		 
		 
		 SqlParameterSource param
	       = new MapSqlParameterSource().addValue("price", price);
		 
		 	 List<Hotels> hotelslist
		   = template.query(sql, param, HOTELS_ROW_MAPPER);
		 
		 return hotelslist;
	 }

}
