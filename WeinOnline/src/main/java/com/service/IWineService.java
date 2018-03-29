package com.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.model.Wine;

public interface IWineService {

	public Wine findByWineCode(String wineCode);
	public void saveWine(Wine wine);
	public void update(Wine wine);
	public void deleteWine(Wine wine);
	public List<Wine> searchWithNativeQuery(@Param("searchTerm") String searchTerm);
	public List<Wine> searchWithJPQLQuery(@Param("searchTerm") String searchTerm);
	public List<Wine> findByWineCategoryId(Long categoryid);
}
