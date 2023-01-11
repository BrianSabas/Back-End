package com.porfolio.app.repository;

import com.porfolio.app.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Brian
 */
public interface PersonRepository extends JpaRepository <Person, Integer> {
	
	public Person findPersonByUserId(Long id);

    public void deleteById(Long id);
    
}