package com.teach.koka.crud.end2end.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teach.koka.crud.end2end.model.Student;


@Controller
public class LandingPageController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String landingPage(Model model){
		return "homePage";	
	}
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String indexPage(Model model){
		return "homePage";
		
	}
	
}
