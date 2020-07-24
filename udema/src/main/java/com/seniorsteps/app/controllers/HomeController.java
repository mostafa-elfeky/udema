package com.seniorsteps.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seniorsteps.app.models.Lookup;
import com.seniorsteps.app.models.enums.LookupType;
import com.seniorsteps.app.repository.LookupRepository;

@Controller
public class HomeController {

	@Autowired
	LookupRepository lookupRepository;
	
	@GetMapping
	public ModelAndView home() {
		
		ModelAndView mav = new ModelAndView("index");
		
		List<Lookup> categories = lookupRepository.findByType(LookupType.CATEGORY.getType());
		
		mav.addObject("categories", categories);
		
		return mav;
	}
	
}
