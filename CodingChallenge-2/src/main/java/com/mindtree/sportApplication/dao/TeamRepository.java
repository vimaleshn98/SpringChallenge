package com.mindtree.sportApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.sportApplication.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{

}
