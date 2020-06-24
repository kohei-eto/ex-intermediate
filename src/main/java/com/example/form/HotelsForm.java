package com.example.form;

import javax.validation.constraints.NotBlank;

public class HotelsForm {
	
	@NotBlank(message = "入力は必須です")
	String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
