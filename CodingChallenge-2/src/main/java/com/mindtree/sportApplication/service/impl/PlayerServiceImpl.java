package com.mindtree.sportApplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.sportApplication.dao.PlayerRepository;
import com.mindtree.sportApplication.entity.Player;
import com.mindtree.sportApplication.entity.Team;
import com.mindtree.sportApplication.exceptions.ResourceNotFoundException;
import com.mindtree.sportApplication.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired
	private PlayerRepository playerRepo;

	@Override
	public List<Player> getAllPlayers() {
		return playerRepo.findAll();
	}

	@Override
	public Player addPlayerDetails(Player newTrack) {
		return playerRepo.save(newTrack);
	}

	@Override
	public Player updatePlayer(Player player, int id) {
		return playerRepo.findById(id).map(newPlayer ->{
			newPlayer.setId(player.getId());
			newPlayer.setName(player.getName());
			newPlayer.setAge(player.getAge());
			newPlayer.setRole(player.getRole());
			return playerRepo.save(newPlayer);
			
		}).orElseThrow(() -> new ResourceNotFoundException("Entered Player is Not Present"));
	}

	@Override
	public void deletePlayer( int id) {
		Player player=playerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entered Mind is Not Present"));
		playerRepo.delete(player);
	}

}
