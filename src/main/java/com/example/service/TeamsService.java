package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Teams;
import com.example.repository.TeamsRepository;




@Service
@Transactional
public class TeamsService {
	@Autowired
	private TeamsRepository teamsRepository;
	
	

	public List<Teams> showList() {
		return teamsRepository.findAll();
	}
	
	public Teams showDetail(Integer id) {
		return teamsRepository.load(id);
	}
	
}
