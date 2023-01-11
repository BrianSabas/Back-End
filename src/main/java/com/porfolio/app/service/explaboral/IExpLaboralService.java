package com.porfolio.app.service.explaboral;

import com.porfolio.app.model.ExperienceLaboral;
import java.util.List;

public interface IExpLaboralService {
	   
    public List<ExperienceLaboral> getExperiencesLab();
    
    public void saveExperienceLaboral(ExperienceLaboral expLab);
    
    public void editExpLab(ExperienceLaboral expLab);
    
    public void deleteExpLab(Long id);	
	
	public List<ExperienceLaboral> getExperiencesByPerson(Long personId);
	
	public ExperienceLaboral getByExperienceId(Long id);
    
}
