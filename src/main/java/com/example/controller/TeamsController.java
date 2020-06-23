package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Teams;
import com.example.service.TeamsService;

@Controller
@RequestMapping("/i")
public class TeamsController {
	@Autowired
	private TeamsService teamsService;
	
	@RequestMapping("")
	public String index(Model model) {
		
		  List<Teams> teamlist = teamsService.showList();
			/* teamlist.addAll(teamsService.showList()); */
		  model.addAttribute("teamlist",teamlist);
		  
		return "showlist";
	}
	
	@RequestMapping("/output")
	public String output(String id, Model model) {
		
		 Teams teams = teamsService.showDetail(Integer.parseInt(id));
		 model.addAttribute("teams", teams);
		
		return "showdetail";
	}
	
}
