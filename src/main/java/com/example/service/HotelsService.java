package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotels;
import com.example.repository.HotelsRepository;

@Service
@Transactional
public class HotelsService {
	@Autowired
	private HotelsRepository hotelsRepository;
	
	public List<Hotels> searchByLessThanPrice(Integer price) {
		return hotelsRepository.findByPrice(price);
	}
	
	public List<Hotels> searchByLessThanPrice2(String price) {
		return hotelsRepository.findByPrice2(price);
	}

}
