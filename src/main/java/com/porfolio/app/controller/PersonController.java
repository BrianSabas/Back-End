package com.porfolio.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porfolio.app.dto.PersonDTO;
import com.porfolio.app.model.Domicile;
import com.porfolio.app.model.Person;
import com.porfolio.app.service.person.IPersonService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "person")
public class PersonController {

	@Autowired
	private IPersonService PersonSvc;

	@GetMapping("/{userId}")
	public PersonDTO getPerson(@PathVariable(required = true, name = "userId") String id) {
		// Obtener los datos del usuario
		Person person = PersonSvc.getPersonByUserId(Long.valueOf(id));

		if (person != null) {
			PersonDTO response = new PersonDTO();

			response.setName(person.getName());
			response.setSurname(person.getSurname());
			response.setAddress(person.getDomicile().getAddress());
			response.setLocalidad(person.getDomicile().getLocalidad());
			response.setTel(person.getTel());
			response.setEmail(person.getEmail());
			response.setAboutMe(person.getAboutMe());

			return response;
		} else {
			return new PersonDTO();
		}
	};

	@PutMapping("/{userId}")
	public PersonDTO editPerson(@PathVariable(required = true, name = "userId") String id,
			@Validated @RequestBody PersonDTO request) {

		// Obtener los datos del usuario
		Person person = PersonSvc.getPersonByUserId(Long.valueOf(id));

		if (person != null) {
			// Actualizar los datos
			person.setName(request.getName());
			person.setSurname(request.getSurname());
			person.setTel(request.getTel());
			person.setAboutMe(request.getAboutMe());
			person.setEmail(request.getEmail());

			Domicile dom = new Domicile();

			dom.setLocalidad(request.getLocalidad());
			dom.setAddress(request.getAddress());

			person.setDomicile(dom);

			// Guardar la persona con los datos actualizados
			PersonSvc.savePerson(person);

			// Responder con la persona guardada
			person = PersonSvc.getPersonByUserId(Long.valueOf(id));

			//ModelMapper mapper = new ModelMapper();			
			//PersonDTO orderDTO = mapper.map(person, PersonDTO.class); 			
			//System.out.println("PersonDTO: " + orderDTO.toString());
			
			PersonDTO response = new PersonDTO();

			response.setName(person.getName());
			response.setSurname(person.getSurname());
			response.setAddress(person.getDomicile().getAddress());
			response.setLocalidad(person.getDomicile().getLocalidad());
			response.setTel(person.getTel());
			response.setEmail(person.getEmail());
			response.setAboutMe(person.getAboutMe());

			return response;
		} else {
			return new PersonDTO();
		}
	}

}
