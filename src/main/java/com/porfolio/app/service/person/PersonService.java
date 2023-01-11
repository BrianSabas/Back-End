package com.porfolio.app.service.person;

import com.porfolio.app.model.Person;
import com.porfolio.app.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {

	@Autowired
	public PersonRepository personRepo;
	
	@Override
	public Person getPersonByUserId(Long userId) {
		//Leer los datos de la persona
		return personRepo.findPersonByUserId(userId);
	}

	@Override
	public List<Person> getPersons() {
		return personRepo.findAll();
	}

	@Override
	public void savePerson(Person pers) {
		personRepo.save(pers);
	}

	@Override
	public void deletePerson(Long id) {
		personRepo.deleteById(id);
	}


}