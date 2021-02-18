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
import com.mindtree.sportApplication.entity.Team;
import com.mindtree.sportApplication.exceptions.ResourceNotFoundException;
import com.mindtree.sportApplication.service.impl.TeamServiceImpl;



@RestController
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamServiceImpl teamService;

	@GetMapping("/all")
	public List<Team> getAllTeams() {
		return teamService.getAllTeams();
	}
	
	@GetMapping("getPlayersByTeam/{name}")
	public ResponseEntity<?> getTeamsByName(@PathVariable String name) {
		List<Player> li=null;
		System.out.println("Getting Team details by name");
		try {
			li = teamService.getTeamssbyName(name);
			return new ResponseEntity(li,HttpStatus.ACCEPTED);
		} catch (Exception e) {
			//throw new ResourceNotFoundException("Team not found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	

	@PostMapping("/add")
	public ResponseEntity<?> addTeam(@Valid  @RequestBody Team team) {
		Map<String, Object> map = new LinkedHashMap<>();
		try {
			Team teams = teamService.addTeamDetails(team);
			map.put("Team added", teams);
			map.put("Message", "Successfully Added");
			return new ResponseEntity<>(map, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateBy/{id}")
	public ResponseEntity<?> updateMind(@RequestBody String location,@PathVariable int id){
		System.out.println(location);
		Map<String, Object> map = new LinkedHashMap<>();
		try {
			Team teams = teamService.updateTeamLocation(location, id);
			map.put("Track updated", teams);
			map.put("Message", "Successfully Updated");
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteBy/{id}")
	public ResponseEntity<?> deleteMind(@RequestBody Team team,@PathVariable int id){
		Map<String, Object> map = new LinkedHashMap<>();
		try {
			 teamService.deleteTeam(id);
			map.put("Message", "Team Deleted");
			map.put("Message", "Successfully Deleted");
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
	}
	
}
