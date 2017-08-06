package com.teach.koka.crud.end2end.resource;

import javax.validation.Valid;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teach.koka.crud.end2end.model.Student;


@Controller
@RequestMapping(value="/student")
public class StudentController {

	
	@RequestMapping(method=RequestMethod.GET)
	public String studentData(Model model){
		Student student = new Student();
		model.addAttribute("student",student);
		model.addAttribute("message","Welcome...");
		return "student-login";		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String postStudentData(@ModelAttribute("student") @Valid Student student,BindingResult result, Model model){
		if(result.hasErrors()){
			return "student-login";
		}
		String text ="Hey Welcome to MVC world...,"+student.getName();
		model.addAttribute("message",text);
		return "success";
	}
}
