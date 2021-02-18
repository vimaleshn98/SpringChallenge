package com.mindtree.sportApplication.service;

import java.util.List;

import com.mindtree.sportApplication.entity.*;

public interface TeamService {

	public List<Team> getAllTeams();
	public Team addTeamDetails(Team team);
	public Team updateTeamLocation(String location,int id);
	public void deleteTeam(int id);
	public List<Player>getTeamssbyName(String name);
}
