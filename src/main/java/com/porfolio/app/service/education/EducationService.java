package com.porfolio.app.service.education;

import com.porfolio.app.model.Education;
import com.porfolio.app.repository.EducationRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService{

    @Autowired 
    public EducationRepository eduRepo;
    
    @Override
    public List<Education> getEducations() {
        return eduRepo.findAll();
    }

    @Override
    public void saveEducation(Education educ) {
        eduRepo.save(educ);
    }

    @Override
    public void editEducation(Education educ) {
        eduRepo.save(educ);
    }

    @Override
    public void deleteEducation(Long id) {
        eduRepo.deleteById(id);
    }

	@Override
	public List<Education> getEducationsByPerson(Long personId) {
		//Devolver lista
		return eduRepo.findByPersonId(personId);
	}

	@Override
	public Education getByEducationId(Long id) {
		// Obtener una educacion
		Optional<Education> opt = eduRepo.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}
    
}