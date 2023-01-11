package com.porfolio.app.repository;

import com.porfolio.app.model.Project;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Project,Long> {
	
	public List<Project> findByPersonId(Long id);

	public Optional<Project> findById(Long id);
    
}