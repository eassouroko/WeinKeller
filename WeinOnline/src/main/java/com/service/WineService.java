package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Wine;

import com.repository.WineRepository;
@Service("wineService")
public class WineService {
	private WineRepository wineRepository;
	
	  @Autowired
	    public WineService(WineRepository wineRepository) { 
	      this.wineRepository = wineRepository;
	    }
	    
		public Wine findByWineCode(String wineCode) {
			return wineRepository.findByWineCode(wineCode);
		}
		
		
		
		public void saveWine(Wine wine) {
			wineRepository.save(wine);
		}

}
