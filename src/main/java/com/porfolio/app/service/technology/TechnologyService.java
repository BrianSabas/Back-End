package com.porfolio.app.service.technology;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.app.model.Technology;
import com.porfolio.app.repository.TechnologyRepository;

@Service
public class TechnologyService implements ITechnologyService {

    @Autowired
    public TechnologyRepository technoRepo;
    
    @Override
    public List<Technology> getTechnologies() {
        return technoRepo.findAll();
    }

    @Override
    public void saveTechnology(Technology techno) {
        technoRepo.save(techno);
    }

    @Override
    public void deleteTechnology(Long id) {
        technoRepo.deleteById(id);
    }

    @Override
    public void editTechnology(Technology techno) {
        technoRepo.save(techno);
    }

	@Override
	public List<Technology> getTechnologyByPerson(Long personId) {
		//Devolver lista
		return technoRepo.findByPersonId(personId);
	}

	@Override
	public Technology getByTechnologyId(Long id) {
		// Obtener una educacion
		Optional<Technology> opt = technoRepo.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}
    
}

