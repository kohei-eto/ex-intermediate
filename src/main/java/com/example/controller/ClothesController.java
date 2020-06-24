package com.example.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Clothes;
import com.example.form.ClothesForm;
import com.example.repository.ClothesRepository;
import com.example.service.ClothesService;

@Controller
@RequestMapping("/k")
public class ClothesController {
	@Autowired 
	private ClothesService ClothesService;
	
	@ModelAttribute
	public ClothesForm setUpForm() {
		return new ClothesForm(); 
	}
	
	@RequestMapping("")
	public String index(Model model) {
		
		
		
		Map<Integer, String> genderMap = new LinkedHashMap<>();
		genderMap.put(0, "Man");
		genderMap.put(1, "Woman");

		model.addAttribute("genderMap", genderMap);
		
		Map<Integer, String> colorMap = new LinkedHashMap<>();
		colorMap.put(1, "赤");
		colorMap.put(2, "青");
		colorMap.put(3, "白");
		colorMap.put(4, "黄");

		model.addAttribute("colorMap", colorMap);
		
		return "clothes";
	}
	
	@RequestMapping("/output")
	public String output(@Validated ClothesForm clothesForm,BindingResult result,Model model) {
		
		

		
		  if(result.hasErrors()) {
		  
		  return index(model); 
		  }
		 
		 
		
		
		
		List<Clothes>clothlist = ClothesService.searchByColorAndGender(clothesForm.getGender(), clothesForm.getColor());
		
		
		model.addAttribute("clothlist",clothlist);
		
		
		
		  

		Map<Integer, String> genderMap = new LinkedHashMap<>();
		genderMap.put(0, "Man");
		genderMap.put(1, "Woman");

		model.addAttribute("genderMap", genderMap);
		
		Map<Integer, String> colorMap = new LinkedHashMap<>();
		colorMap.put(1, "赤");
		colorMap.put(2, "青");
		colorMap.put(3, "白");
		colorMap.put(4, "黄");

		model.addAttribute("colorMap", colorMap);
		 
		 
		
		
		return "clothes";
		
		
		
		/*
		 * Clothes clothes = new Clothes();
		 * 
		 * BeanUtils.copyProperties(clothesForm, clothes);
		 * 
		 * List<String> genderList = new ArrayList<String>();
		 * 
		 * for(Integer genderCode : clothesForm.getGenderList()) { switch(genderCode) {
		 * case1: genderList.add("赤"); break; case2: genderList.add("青"); break; case3:
		 * genderList.add("白"); break; case4: genderList.add("黄"); break;
		 * 
		 * } }
		 * 
		 * clothes.setColorList(colorList);
		 */
		  
		  
		  
	
		 
	}
	
	
}
