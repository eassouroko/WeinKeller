package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.model.WineCategory;
import com.repository.WineCategoryRepository;
@Service("wineCategoryService")
public class WineCategoryService {
	 @Autowired
	private WineCategoryRepository wineCategoryRepository;
	
   
    public WineCategoryService(WineCategoryRepository wineCategoryRepository) { 
      this.wineCategoryRepository = wineCategoryRepository;
    }
    
	public WineCategory findByCategoryDescription(String categoryDescription) {
		return wineCategoryRepository.findByCategoryDescription(categoryDescription);
	}
	
	
	
	public void saveWineCategory(WineCategory wineCatego) {

		if (!alreadyExists(wineCatego)) {
			wineCategoryRepository.save(wineCatego);

		} else {
			System.out.println("The wine category :"+ wineCatego.getCategoryDescription()+ "already exists");

		}
	}
	/*In production the methode would be public**/
	private boolean alreadyExists(WineCategory wineCatego) {
		boolean exists=false;
		WineCategory categoryExists= wineCategoryRepository.findByCategoryDescription(wineCatego.getCategoryDescription());
		if( categoryExists!=null) exists=true;
		
		return  exists;
	}
	
	public List<WineCategory> searchWithNativeQuery(@Param("searchTerm") String searchTerm){
		return this.wineCategoryRepository.searchWithNativeQuery(searchTerm);
	}
	
	

}
