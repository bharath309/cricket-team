package com.teach.koka.crud.end2end.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teach.koka.crud.end2end.model.Team;

@Repository
public class TeamRepositoryImpl implements TeamRepository{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void addTeam(Team team) {
		getCurrentSession().save(team);
	}

	public void updateTeam(Team team) {
		Team teamToUpdate = getTeam(team.getId());
		teamToUpdate.setName(team.getName());
		teamToUpdate.setRating(team.getRating());
		getCurrentSession().update(teamToUpdate);
		
	}

	public Team getTeam(int id) {
		Team team = (Team) getCurrentSession().get(Team.class,id);
		return team;
	}

	public void deleteTeam(int id) {
		Team team = getTeam(id);
		if(team != null){
			getCurrentSession().delete(team);
		}
		
	}

	public List<Team> getTeams() {
		return getCurrentSession().createQuery("from Team").list();

	}

	
	
}
