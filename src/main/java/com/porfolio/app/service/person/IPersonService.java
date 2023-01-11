
package com.porfolio.app.service.person;

import com.porfolio.app.model.Person;
import java.util.List;

public interface IPersonService {

	public Person getPersonByUserId(Long userId);

	public List<Person> getPersons();

	public void savePerson(Person pers);
	
	public void deletePerson(Long id);

}