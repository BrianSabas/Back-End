package com.porfolio.app.repository;

import com.porfolio.app.model.Education;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education,Integer> {

    public void deleteById(Long id);
    
    public List<Education> findByPersonId(Long id);
    
    public Optional<Education> findById(Long id);
    
}
