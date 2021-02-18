package com.mindtree.sportApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.sportApplication.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
