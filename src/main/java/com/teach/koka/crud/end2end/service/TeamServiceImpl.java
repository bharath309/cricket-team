package com.teach.koka.crud.end2end.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teach.koka.crud.end2end.dao.TeamRepository;
import com.teach.koka.crud.end2end.model.Team;

@Service
@Transactional
public class TeamServiceImpl implements TeamService{
	
	@Autowired
	private TeamRepository teamRepository;

	public void addTeam(Team team) {
		teamRepository.addTeam(team);
	}

	public void updateTeam(Team team) {
		
		teamRepository.updateTeam(team);
	}

	public Team getTeam(int id) {
		
		return teamRepository.getTeam(id);
	}

	public void deleteTeam(int id) {
		teamRepository.deleteTeam(id);
		
	}

	public List<Team> getTeams() {
		return teamRepository.getTeams();
	}

}
