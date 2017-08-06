package com.teach.koka.crud.end2end.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teach.koka.crud.end2end.model.Student;
import com.teach.koka.crud.end2end.model.Team;
import com.teach.koka.crud.end2end.service.TeamService;

@Controller
@RequestMapping(value="/team")
public class TeamController {

	@Autowired
	private TeamService service;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addTeam(Model model) {
		Team team = new Team();
		model.addAttribute("team",team);
		return "registerPage";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addingTeam(@Valid @ModelAttribute Team team, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "registerPage";
		}
		service.addTeam(team);
		model.addAttribute("message","Team Added Successfully");
		return "homePage";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listOfTeams(Model model) {
		Team team = new Team();
		List<Team> teams = service.getTeams();
		model.addAttribute("teams",teams);
		return "displayPage";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String updateTeam(@PathVariable Integer id, Model model) {
		Team team = service.getTeam(id);
		model.addAttribute(team);
		return "updatePage";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public String updatingTeam(@Valid @ModelAttribute Team team, BindingResult result, @PathVariable Integer id, Model model) {
		if(result.hasErrors()){
			return "updatePage";
		}
		service.updateTeam(team);
		model.addAttribute("message","Team Updated Successfully");
		return "homePage";
	}
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteTeam(@PathVariable Integer id, Model model) {
		service.deleteTeam(id);
		model.addAttribute("message","Team with "+id +"successfully deleted.");
		return "homePage";
	}
	
	
	
}
