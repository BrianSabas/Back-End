/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.app.service.education;

import com.porfolio.app.model.Education;
import java.util.List;

public interface IEducationService {
	
    public List<Education> getEducations();

	public void saveEducation(Education educ);
	
    public void editEducation(Education educ);
    
    public void deleteEducation(Long id);
    
    public List<Education> getEducationsByPerson(Long personId);
    
    public Education getByEducationId(Long id);
}
