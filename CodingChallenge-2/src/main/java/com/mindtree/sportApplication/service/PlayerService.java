package com.mindtree.sportApplication.service;

import java.util.List;

import com.mindtree.sportApplication.entity.Player;



public interface PlayerService {

	public List<Player> getAllPlayers();
	public Player addPlayerDetails(Player player);
	public Player updatePlayer(Player player,int id);
	public void deletePlayer(int id);
	
}
