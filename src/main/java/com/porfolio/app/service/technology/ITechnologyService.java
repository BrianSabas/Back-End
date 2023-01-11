package com.porfolio.app.service.technology;

import java.util.List;

import com.porfolio.app.model.Technology;

public interface ITechnologyService {
	
   public List<Technology> getTechnologies();
   
   public void saveTechnology(Technology techno);
   
   public void deleteTechnology(Long id);
   
   public void editTechnology(Technology techno);   
   
   public List<Technology> getTechnologyByPerson(Long personId);
   
   public Technology getByTechnologyId(Long id);
    
}
