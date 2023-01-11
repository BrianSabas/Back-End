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

import com.porfolio.app.dto.ProjectDTO;
import com.porfolio.app.model.Person;
import com.porfolio.app.model.Project;
import com.porfolio.app.service.person.IPersonService;
import com.porfolio.app.service.projects.IProjectService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "project")
public class ProjectController {
	@Autowired
	private IProjectService ProjectSvc;

	@Autowired
	private IPersonService PersonSvc;

	@PostMapping("/{userId}")
	public void addProject(@PathVariable(required = true, name = "userId") String id,
			@Validated @RequestBody ProjectDTO request) {

		// Obtener los datos del usuario
		Person person = PersonSvc.getPersonByUserId(Long.valueOf(id));

		Project pro = new Project();

		pro.setProjectName(request.getProjectName());
		pro.setAboutProject(request.getAboutProject());

		// Agregar la persona
		pro.setPerson(person);

		// Guardar el proyecto
		ProjectSvc.saveProject(pro);
	}

	@PutMapping("/{projectId}")
	public ProjectDTO editProject(@PathVariable(required = true, name = "projectId") String id,
			@Validated @RequestBody ProjectDTO request) {
		//update project
		ProjectDTO dto = new ProjectDTO();
		Project pro = ProjectSvc.getByProjectId(Long.valueOf(id));
		
		if(pro != null) {
			pro.setProjectName(request.getProjectName());
			pro.setAboutProject(request.getAboutProject());
			
			//Guardar los cambios
			ProjectSvc.saveProject(pro);
			
			//Recuperar la entidad guardada
			pro = ProjectSvc.getByProjectId(Long.valueOf(id));
			
			dto.setId(pro.getId());
			dto.setProjectName(pro.getProjectName());
			dto.setAboutProject(pro.getAboutProject());			
		}		
		
		return dto;
	}
	
	@ResponseBody
	@GetMapping("/{projectId}")
	public ProjectDTO getProject(@PathVariable(required = true, name = "projectId") String id) {		
		//Leer una educacion
		Project pro = ProjectSvc.getByProjectId(Long.valueOf(id));	
		
		ProjectDTO dto = new ProjectDTO();
		
		dto.setId(pro.getId());
		dto.setProjectName(pro.getProjectName());
		dto.setAboutProject(pro.getAboutProject());
		
		return dto;
	}

	@ResponseBody
	@GetMapping("/all/{userId}")
	public List<ProjectDTO> getProjects(@PathVariable(required = true, name = "userId") String id) {
		// Obtener los datos por el usuarioId
		Person person = PersonSvc.getPersonByUserId(Long.valueOf(id));
		
		// Obtener la lista de educacion por la personaId
		List<Project> lstPro = ProjectSvc.getProjectsByPerson(person.getId());

		// Armar la lista de respuesta
		List<ProjectDTO> response = new LinkedList<ProjectDTO>();

		for (Project pro : lstPro) {
			ProjectDTO dto = new ProjectDTO();

			dto.setId(pro.getId());
			dto.setProjectName(pro.getProjectName());
			dto.setAboutProject(pro.getAboutProject());
			
			response.add(dto);
		}

		return response;
	}

	@DeleteMapping("/{id}")
	public void deleteProject(@PathVariable long id) {
		ProjectSvc.deleteProject(id);
	}

}
