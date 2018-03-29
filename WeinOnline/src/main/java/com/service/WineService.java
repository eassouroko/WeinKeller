package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.model.Wine;

import com.repository.WineRepository;
@Service("wineService")
public class WineService implements IWineService{
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
				System.out.println(wine.getWineName()+ " already exists");
				
			}
		}
		/* Vorübergehend private zum Testzweck. Spaeter wird die Methode public **/
		private boolean wineExists(Wine wine) {
			boolean exists=false;
			Wine wineExists = wineRepository.findByWineCode(wine.getWineCode());
			if(wineExists!=null) exists=true;
			return exists;
		}
		
		public void update(Wine wine) {

			if(wine != null)
				this.wineRepository.save(wine);
			
		}
		
		public void deleteWine(Wine wine) {
			
			this.wineRepository.findByWineCode(wine.getWineCode());
		}
		
		public List<Wine> searchWithNativeQuery(@Param("searchTerm") String searchTerm){
			return wineRepository.searchWithNativeQuery(searchTerm);
			
			
		}
		public List<Wine> searchWithJPQLQuery(@Param("searchTerm") String searchTerm){
			
			return wineRepository.searchWithJPQLQuery(searchTerm);
		}
		
		public List<Wine> findByWineCategoryId(Long categoryid){
			return this.wineRepository.findByWineCategoryId(categoryid);
			//this.wineRepository.
		}
		
		

}
