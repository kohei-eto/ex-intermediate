package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Teams;



@Repository
public class TeamsRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	private static final RowMapper<Teams> TEAMS_ROW_MAPPER
	 = (rs,i) -> {
		 Teams teams = new Teams();
		 teams.setId(rs.getInt("id"));
		 teams.setLeagueName(rs.getString("league_name"));
		 teams.setTeamName(rs.getString("team_name"));
		 teams.setHeadQuarters(rs.getString("headquarters"));
		 teams.setInauguRation(rs.getString("inauguration"));
		 teams.setHistory(rs.getString("history"));
		 return teams;
	 };
	 
	 public List<Teams> findAll() {
		 
		 String sql = "select * from teams ";
		 
		 List<Teams> teamsList
		      = template.query(sql, TEAMS_ROW_MAPPER);
		 return teamsList; 
     }
	 
	 public Teams load(Integer id) {
		 String sql =
				 "select * from teams where id = :id";
		 SqlParameterSource param
		     = new MapSqlParameterSource().addValue("id", id);
		 
		 Teams teams
		   = template.queryForObject(sql, param, TEAMS_ROW_MAPPER);
		 
		 return teams;
	 }
	 
	 
}
