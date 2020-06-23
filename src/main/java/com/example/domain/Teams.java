package com.example.domain;


public class Teams {
	Integer id;
	String leagueName;
	String teamName;
	String headQuarters;
	String inauguRation;
	String history;
	
	
	
	@Override
	public String toString() {
		return "teams [id=" + id + ", leagueName=" + leagueName + ", teamName=" + teamName + ", headQuarters="
				+ headQuarters + ", inauguRation=" + inauguRation + ", history=" + history + "]";
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getHeadQuarters() {
		return headQuarters;
	}
	public void setHeadQuarters(String headQuarters) {
		this.headQuarters = headQuarters;
	}
	public String getInauguRation() {
		return inauguRation;
	}
	public void setInauguRation(String inauguRation) {
		this.inauguRation = inauguRation;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	
}
