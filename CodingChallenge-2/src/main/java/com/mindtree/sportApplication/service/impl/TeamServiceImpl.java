package com.mindtree.sportApplication.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.sportApplication.dao.PlayerRepository;
import com.mindtree.sportApplication.dao.TeamRepository;
import com.mindtree.sportApplication.entity.Player;
import com.mindtree.sportApplication.entity.Team;
import com.mindtree.sportApplication.exceptions.ResourceNotFoundException;
import com.mindtree.sportApplication.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepo;
	
	@Autowired
	private PlayerRepository playerRepo;
	@Override
	public List<Team> getAllTeams() {
		return teamRepo.findAll();
	}

	@Override
	public Team addTeamDetails(Team team) {
		return teamRepo.save(team);
		
	}

	@Override
	public Team updateTeamLocation(String location, int id) {
		return teamRepo.findById(id).map(newTeam ->{
			newTeam.setLocation(location);
			return teamRepo.save(newTeam);
			
		}).orElseThrow(() -> new ResourceNotFoundException("Entered Team is Not Present"));
	}

	@Override
	public void deleteTeam(int id) {
		Team team=teamRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entered Mind is Not Present"));
		teamRepo.delete(team);

	}

	@Override
	public List<Player> getTeamssbyName(String name) {
		String nameOfTeam = "";
		List<Player> players = playerRepo.findAll();
		List<Player> teamPlayers = new ArrayList<Player>();
		for (Player player : players) {
			nameOfTeam = player.getTeam().getName();
			System.out.println(nameOfTeam);
			if (nameOfTeam.equals(name))
				teamPlayers.add(player);
			else {
				throw new ResourceNotFoundException("Entered Track is Not Present");
			}
		}
		return teamPlayers;
	}

}
