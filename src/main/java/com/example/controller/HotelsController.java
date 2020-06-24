package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotels;
import com.example.form.HotelsForm;
import com.example.service.HotelsService;

@Controller
@RequestMapping("/j")
public class HotelsController {
	@Autowired
	private HotelsService hotelsService;
	
	@ModelAttribute
	public HotelsForm setUpForm() {
		return new HotelsForm();
	}
	
	@RequestMapping("")
	public String input() {
		return "hotels";
	}
	
	@RequestMapping("/output")
	public String output(
			@Validated HotelsForm hotelsForm,
			BindingResult result,Model model) {
		
           if(result.hasErrors()) {
			
			return "hotels";
			}
		
		
		 if (hotelsForm.getPrice().equals("")) {
			 
			 List<Hotels> hotelslist =
					    hotelsService.searchByLessThanPrice2(hotelsForm.getPrice());
			 
			 model.addAttribute("hotelslist", hotelslist);
			 
				
				return "hotels";
			 
		 } else {
		
		
		  List<Hotels> hotelslist =
		    hotelsService.searchByLessThanPrice(Integer.parseInt(hotelsForm.getPrice()));
		  
		  
		  model.addAttribute("hotelslist", hotelslist);
		 
		
		return "hotels";}
		
	}
	
	
	
	
}
