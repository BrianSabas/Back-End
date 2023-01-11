package com.porfolio.app.service.projects;

import java.util.List;

import com.porfolio.app.model.Education;
import com.porfolio.app.model.Project;

public interface IProjectService {
    
    public List<Project> getProjects();
    
    public void saveProject(Project project);
    
    public void editProject(Project project);
    
    public void deleteProject(Long id);
    
    public List<Project> getProjectsByPerson(Long personId);
    
    public Project getByProjectId(Long id);
}

