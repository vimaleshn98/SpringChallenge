package com.mindtree.sportApplication.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Team {

	@Id
	private int id;
	@NotNull
	@Size(min=2,message="Name should be atleast 2 characters long")
	private String name;
	@Size(min=2,message="Location should be atleast 2 characters long")
	private String location;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "team", fetch = FetchType.LAZY)
	private List<Player> player;
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Team(int id, String name, String location, List<Player> player) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.player = player;
	}


	@JsonManagedReference
	public List<Player> getPlayer() {
		return player;
	}


	public void setPlayer(List<Player> player) {
		this.player = player;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
