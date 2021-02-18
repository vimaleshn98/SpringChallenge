package com.mindtree.sportApplication.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.sportApplication.entity.Player;
import com.mindtree.sportApplication.service.impl.PlayerServiceImpl;



@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerServiceImpl playerService;

	@GetMapping("/all")
	public List<Player> getAllPlayers() {
		return playerService.getAllPlayers();
	}

	@PostMapping("/add")
	public ResponseEntity<?> addPlayer(@Valid @RequestBody Player player) {
		Map<String, Object> map = new LinkedHashMap<>();
		try {
			Player playr = playerService.addPlayerDetails(player);
			map.put("Player added", playr);
			map.put("Message", "Successfully Added");
			return new ResponseEntity<>(map, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateBy/{id}")
	public ResponseEntity<?> updatePlayer(@Valid @RequestBody Player player,@PathVariable int id){
		Map<String, Object> map = new LinkedHashMap<>();
		try {
			Player mnd = playerService.updatePlayer(player, id);
			map.put("Player updated", mnd);
			map.put("Message", "Successfully Updated");
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteBy/{id}")
	public ResponseEntity<?> deletePlayer(@PathVariable(value="id") int id){
		Map<String, Object> map = new LinkedHashMap<>();
		try {
			playerService.deletePlayer(id);
			map.put("Message", "Player Deleted");
			map.put("Message", "Successfull");
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			map.put("Message", "Something Went Wrong");
			map.put("Message", "Player is Not Deleted");
			return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
	}

}
