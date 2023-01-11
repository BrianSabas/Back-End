package com.porfolio.app.service.explaboral;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.app.model.Education;
import com.porfolio.app.model.ExperienceLaboral;
import com.porfolio.app.repository.ExperienceLaboralRepository;

@Service
public class ExpLaboralService implements IExpLaboralService{
    
    @Autowired
    public ExperienceLaboralRepository expLabRepo;

    @Override
    public List<ExperienceLaboral> getExperiencesLab() {
        return expLabRepo.findAll();
    }

    @Override
    public void saveExperienceLaboral(ExperienceLaboral expLab) {
        expLabRepo.save(expLab);
    }

    @Override
    public void editExpLab(ExperienceLaboral expLab) {
        expLabRepo.save(expLab);
    }

    @Override
    public void deleteExpLab(Long id) {
        expLabRepo.deleteById(id);
    }	

	@Override
	public List<ExperienceLaboral> getExperiencesByPerson(Long personId) {
		return expLabRepo.findByPersonId(personId);
	}
	
	@Override
	public ExperienceLaboral getByExperienceId(Long id) {
		// Obtener una educacion
		Optional<ExperienceLaboral> opt = expLabRepo.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}
    
}
