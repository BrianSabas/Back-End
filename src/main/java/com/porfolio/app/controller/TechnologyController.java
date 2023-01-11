package com.porfolio.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.porfolio.app.dto.TechnologyDTO;
import com.porfolio.app.model.Person;
import com.porfolio.app.model.Technology;
import com.porfolio.app.service.person.IPersonService;
import com.porfolio.app.service.technology.ITechnologyService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "technology")
public class TechnologyController {

	@Autowired
	private ITechnologyService TechnologySvc;
	
	@Autowired
	private IPersonService PersonSvc;

	@PostMapping("/{userId}")
	public void addTechnology(@PathVariable(required = true, name = "userId") String id,
			@Validated @RequestBody TechnologyDTO request) {

		// Obtener los datos del usuario
		Person person = PersonSvc.getPersonByUserId(Long.valueOf(id));

		Technology tec = new Technology();
		
		tec.setName(request.getName());
		tec.setPorcentaje(request.getPorcentaje());

		// Agregar la persona
		tec.setPerson(person);

		// Guardar la experiencia
		TechnologySvc.saveTechnology(tec);
	}

	@PutMapping("/{technologyId}")
	public TechnologyDTO editTechnology(@PathVariable(required = true, name = "technologyId") String id,
			@Validated @RequestBody TechnologyDTO request) {
		//update technology
		TechnologyDTO dto = new TechnologyDTO();
		Technology tec = TechnologySvc.getByTechnologyId(Long.valueOf(id));
		
		if(tec != null) {
			tec.setName(request.getName());
			tec.setPorcentaje(request.getPorcentaje());
			
			//Guardar los cambios
			TechnologySvc.saveTechnology(tec);
			
			//Recuperar la entidad guardada
			tec = TechnologySvc.getByTechnologyId(Long.valueOf(id));
			
			dto.setId(tec.getId());
			dto.setName(tec.getName());
			dto.setPorcentaje(tec.getPorcentaje());	
		}		
		
		return dto;
	}
	
	@ResponseBody
	@GetMapping("/{technologyId}")
	public TechnologyDTO getTechnology(@PathVariable(required = true, name = "technologyId") String id) {		
		//Leer una educacion
		Technology tec = TechnologySvc.getByTechnologyId(Long.valueOf(id));	
		
		TechnologyDTO dto = new TechnologyDTO();
		
		dto.setId(tec.getId());
		dto.setName(tec.getName());
		dto.setPorcentaje(tec.getPorcentaje());
		
		return dto;
	}

	@ResponseBody
	@GetMapping("/all/{userId}")
	public List<TechnologyDTO> getTechnologies(@PathVariable(required = true, name = "userId") String id) {
		// Obtener los datos por el usuarioId
		Person person = PersonSvc.getPersonByUserId(Long.valueOf(id));
		
		// Obtener la lista de educacion por la personaId
		List<Technology> lstTec = TechnologySvc.getTechnologyByPerson(person.getId());

		// Armar la lista de respuesta
		List<TechnologyDTO> response = new LinkedList<TechnologyDTO>();

		for (Technology tec : lstTec) {
			TechnologyDTO dto = new TechnologyDTO();

			dto.setId(tec.getId());
			dto.setName(tec.getName());
			dto.setPorcentaje(tec.getPorcentaje());
			
			response.add(dto);
		}

		return response;
	}	

	@DeleteMapping("/{id}")
	public void deleteTechnology(@PathVariable long id) {
		TechnologySvc.deleteTechnology(id);
	}

}
