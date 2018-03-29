package com.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.model.WineCategory;

public interface IWineCategoryService{

	public WineCategory findByCategoryDescription(String categoryDescription);
	public void saveWineCategory(WineCategory wineCatego);
	public List<WineCategory> searchWithNativeQuery(@Param("searchTerm") String searchTerm);
	public void deleteWineCategory(WineCategory wine);
	WineCategory findById(long id);
}
