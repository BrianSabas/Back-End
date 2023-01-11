package com.porfolio.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porfolio.app.model.ExperienceLaboral;

public interface ExperienceLaboralRepository extends JpaRepository<ExperienceLaboral, Long> {

	public List<ExperienceLaboral> findByPersonId(Long id);

	public Optional<ExperienceLaboral> findById(Long id);

}
