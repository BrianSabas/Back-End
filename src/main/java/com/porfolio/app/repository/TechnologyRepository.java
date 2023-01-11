package com.porfolio.app.repository;

import com.porfolio.app.model.Technology;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology,Long>  {
    
	public List<Technology> findByPersonId(Long id);

	public Optional<Technology> findById(Long id);
	
}