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

import com.porfolio.app.dto.EducationDTO;
import com.porfolio.app.model.Education;
import com.porfolio.app.model.Person;
import com.porfolio.app.service.education.IEducationService;
import com.porfolio.app.service.person.IPersonService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "education")
public class EducationController {

	@Autowired
	private IEducationService EducationSvc;

	@Autowired
	private IPersonService PersonSvc;

	@PostMapping("/{userId}")
	public void addEducation(@PathVariable(required = true, name = "userId") String id,
			@Validated @RequestBody EducationDTO request) {

		// Obtener los datos del usuario
		Person person = PersonSvc.getPersonByUserId(Long.valueOf(id));

		Education edu = new Education();

		edu.setCareerFinished(request.getCareerFinished());
		edu.setCareerName(request.getCareerName());
		edu.setHighSchoolFinished(request.getHighSchoolFinished());
		edu.setHighSchoolName(request.getHighSchoolName());

		// Agregar la persona
		edu.setPerson(person);

		// Guardar la educacion
		EducationSvc.saveEducation(edu);
	}

	@PutMapping("/{educationId}")
	public EducationDTO editEducation(@PathVariable(required = true, name = "educationId") String id,
			@Validated @RequestBody EducationDTO request) {
		//update Education
		EducationDTO dto = new EducationDTO();
		Education edu = EducationSvc.getByEducationId(Long.valueOf(id));
		
		if(edu != null) {
			edu.setCareerFinished(request.getCareerFinished());
			edu.setCareerName(request.getCareerName());
			edu.setHighSchoolFinished(request.getHighSchoolFinished());
			edu.setHighSchoolName(request.getHighSchoolName());
			
			//Guardar la educacion
			EducationSvc.saveEducation(edu);
			
			//Recuperar la entidad guardada
			edu = EducationSvc.getByEducationId(Long.valueOf(id));			
			
			dto.setId(edu.getId());
			dto.setCareerFinished(edu.getCareerFinished());
			dto.setCareerName(edu.getCareerName());
			dto.setHighSchoolFinished(edu.getHighSchoolFinished());
			dto.setHighSchoolName(edu.getHighSchoolName());
		}	
		
		return dto;
	}

	@ResponseBody
	@GetMapping("/{educationId}")
	public EducationDTO getEducation(@PathVariable(required = true, name = "educationId") String id) {		
		//Leer una educacion
		Education edu = EducationSvc.getByEducationId(Long.valueOf(id));	
		
		EducationDTO dto = new EducationDTO();
		
		dto.setId(edu.getId());
		dto.setCareerFinished(edu.getCareerFinished());
		dto.setCareerName(edu.getCareerName());
		dto.setHighSchoolFinished(edu.getHighSchoolFinished());
		dto.setHighSchoolName(edu.getHighSchoolName());
		
		return dto;
	}
	
	@ResponseBody
	@GetMapping("/all/{userId}")
	public List<EducationDTO> getEducations(@PathVariable(required = true, name = "userId") String id) {
		// Obtener los datos por el usuarioId
		Person person = PersonSvc.getPersonByUserId(Long.valueOf(id));

		// Obtener la lista de educacion por la personaId
		List<Education> lstEduc = EducationSvc.getEducationsByPerson(person.getId());

		// Armar la lista de respuesta
		List<EducationDTO> response = new LinkedList<EducationDTO>();

		for (Education edu : lstEduc) {
			EducationDTO dto = new EducationDTO();

			dto.setId(edu.getId());
			dto.setCareerFinished(edu.getCareerFinished());
			dto.setCareerName(edu.getCareerName());
			dto.setHighSchoolFinished(edu.getHighSchoolFinished());
			dto.setHighSchoolName(edu.getHighSchoolName());

			response.add(dto);
		}

		return response;
	}

	@DeleteMapping("/{id}")
	public void deleteEducation(@PathVariable(required = true, name = "id") long id) {
		EducationSvc.deleteEducation(id);
	}

}
