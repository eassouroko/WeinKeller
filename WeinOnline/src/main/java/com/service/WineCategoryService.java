package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.WineCategory;
import com.repository.WineCategoryRepository;
@Service("wineCategoryService")
public class WineCategoryService {
private WineCategoryRepository wineCategoryRepository;
	
    @Autowired
    public WineCategoryService(WineCategoryRepository wineCategoryRepository) { 
      this.wineCategoryRepository = wineCategoryRepository;
    }
    
	public WineCategory findByCategoryDescription(String categoryDescription) {
		return wineCategoryRepository.findByCategoryDescription(categoryDescription);
	}
	
	
	
	public void saveWineCategory(WineCategory wineCatego) {
		wineCategoryRepository.save(wineCatego);
	}

}
