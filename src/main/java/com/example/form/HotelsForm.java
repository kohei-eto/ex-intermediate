package com.example.form;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

public class HotelsForm {
	
	@Pattern(regexp = "^[0-9]*$", message="数字を入力してください" )
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
