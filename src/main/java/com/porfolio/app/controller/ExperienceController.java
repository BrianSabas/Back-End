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

import com.porfolio.app.dto.ExperienceLaboralDTO;
import com.porfolio.app.model.ExperienceLaboral;
import com.porfolio.app.model.Person;
import com.porfolio.app.service.explaboral.IExpLaboralService;
import com.porfolio.app.service.person.IPersonService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "experience")
public class ExperienceController {
	@Autowired
	private IExpLaboralService ExpLaboralSvc;
	
	@Autowired
	private IPersonService PersonSvc;

	@PostMapping("/{userId}")
	public void addExperienceLaboral(@PathVariable(required = true, name = "userId") String id,
			@Validated @RequestBody ExperienceLaboralDTO request) {

		// Obtener los datos del usuario
		Person person = PersonSvc.getPersonByUserId(Long.valueOf(id));

		ExperienceLaboral xp = new ExperienceLaboral();

		xp.setNombreEmpresa(request.getNombreEmpresa());
		xp.setTrabajoActual(request.getTrabajoActual());
		xp.setFechaInicio(request.getFechaInicio());
		xp.setFechaFin(request.getFechaFin());
		xp.setDescripcion(request.getDescripcion());
		
		//Agregar la persona
		xp.setPerson(person);
		
		//Guardar la experiencia
		ExpLaboralSvc.saveExperienceLaboral(xp);
	}


	@PutMapping("/{experienceId}")
	public ExperienceLaboralDTO editExperienceLaboral(@PathVariable(required = true, name = "experienceId") String id,
			@Validated @RequestBody ExperienceLaboralDTO request) {
		//update Experience
		ExperienceLaboralDTO dto = new ExperienceLaboralDTO();
		ExperienceLaboral xp = ExpLaboralSvc.getByExperienceId(Long.valueOf(id));
		
		if(xp != null) {
			xp.setNombreEmpresa(request.getNombreEmpresa());
			xp.setTrabajoActual(request.getTrabajoActual());
			xp.setFechaInicio(request.getFechaInicio());
			xp.setFechaFin(request.getFechaFin());
			xp.setDescripcion(request.getDescripcion());
			
			//Guardar los cambios
			ExpLaboralSvc.saveExperienceLaboral(xp);
			
			//Recuperar la entidad guardada
			xp = ExpLaboralSvc.getByExperienceId(Long.valueOf(id));
			
			dto.setId(xp.getId());
			dto.setNombreEmpresa(xp.getNombreEmpresa());
			dto.setTrabajoActual(xp.getTrabajoActual());
			dto.setFechaInicio(xp.getFechaInicio());
			dto.setFechaFin(xp.getFechaFin());
			dto.setDescripcion(xp.getDescripcion());
		}	
		
		return dto;
	}
	
	@ResponseBody
	@GetMapping("/{experienceId}")
	public ExperienceLaboralDTO getEducation(@PathVariable(required = true, name = "experienceId") String id) {		
		//Leer una educacion
		ExperienceLaboral xp = ExpLaboralSvc.getByExperienceId(Long.valueOf(id));	
		
		ExperienceLaboralDTO dto = new ExperienceLaboralDTO();
		
		dto.setId(xp.getId());
		dto.setNombreEmpresa(xp.getNombreEmpresa());
		dto.setTrabajoActual(xp.getTrabajoActual());
		dto.setFechaInicio(xp.getFechaInicio());
		dto.setFechaFin(xp.getFechaFin());
		dto.setDescripcion(xp.getDescripcion());
		
		return dto;
	}

	@ResponseBody
	@GetMapping("/all/{userId}")
	public List<ExperienceLaboralDTO> getExperiences(@PathVariable(required = true, name = "userId") String id) {
		// Obtener los datos por el usuarioId
		Person person = PersonSvc.getPersonByUserId(Long.valueOf(id));

		// Obtener la lista de educacion por la personaId
		List<ExperienceLaboral> lstExp = ExpLaboralSvc.getExperiencesByPerson(person.getId());

		// Armar la lista de respuesta
		List<ExperienceLaboralDTO> response = new LinkedList<ExperienceLaboralDTO>();

		for (ExperienceLaboral xp : lstExp) {
			ExperienceLaboralDTO dto = new ExperienceLaboralDTO();

			dto.setId(xp.getId());
			dto.setNombreEmpresa(xp.getNombreEmpresa());
			dto.setTrabajoActual(xp.getTrabajoActual());
			dto.setFechaInicio(xp.getFechaInicio());
			dto.setFechaFin(xp.getFechaFin());
			dto.setDescripcion(xp.getDescripcion());

			response.add(dto);
		}

		return response;
	}

	@DeleteMapping("/{id}")
	public void deleteExpLab(@PathVariable long id) {
		ExpLaboralSvc.deleteExpLab(id);
	}

}
