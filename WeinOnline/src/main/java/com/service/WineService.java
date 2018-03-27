package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Wine;

import com.repository.WineRepository;
@Service("wineService")
public class WineService {
	@Autowired
	private WineRepository wineRepository;
	
	 
	    public WineService(WineRepository wineRepository) { 
	      this.wineRepository = wineRepository;
	    }
	    
		public Wine findByWineCode(String wineCode) {
			return wineRepository.findByWineCode(wineCode);
		}
		
		
		
		public void saveWine(Wine wine) {
			if(!wineExists(wine)) {wineRepository.save(wine);
			
			}else {
				System.out.println(wine.getWineName()+ "already exists");
				
			}
		}
		/* Vorübergehend private zum Testzweck. Spaeter wird die Methode public **/
		private boolean wineExists(Wine wine) {
			boolean exists=false;
			Wine wineExists = wineRepository.findByWineCode(wine.getWineCode());
			if(wineExists!=null) exists=true;
			return exists;
		}
		
		public void updateWine(Wine wine) {
			
			Wine w = this.wineRepository.getOne(wine.getId());
			
			
			this.wineRepository.save(w);
			
		}
		
		public void deleteWine(Wine wine) {
			
			this.wineRepository.findByWineCode(wine.getWineCode());
		}

}
