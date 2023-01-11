package com.porfolio.app.service.projects;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.app.model.Project;
import com.porfolio.app.repository.ProjectsRepository;

@Service
public class ProjectService implements IProjectService{

    @Autowired
    public ProjectsRepository projectRepo;
    
    @Override
    public List<Project> getProjects() {
        return projectRepo.findAll();
    }

    @Override
    public void saveProject(Project project) {
        projectRepo.save(project);
    }

    @Override
    public void editProject(Project project) {
        projectRepo.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }

	@Override
	public Project getByProjectId(Long id) {
		// Obtener una educacion
		Optional<Project> opt = projectRepo.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Project> getProjectsByPerson(Long personId) {
		//Retornar lista
		return projectRepo.findByPersonId(personId);
	}
    
}
