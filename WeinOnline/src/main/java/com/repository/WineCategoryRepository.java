package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Wine;
import com.model.WineCategory;
@Repository
public interface WineCategoryRepository extends JpaRepository<WineCategory,Long> {
	WineCategory findByCategoryDescription(String categoryDescription);
	WineCategory findById(long id);
	
	@Query(value = "SELECT * FROM winecategory WHERE category_description LIKE %:searchTerm%", nativeQuery = true)
	public List<WineCategory> searchWithNativeQuery(@Param("searchTerm") String searchTerm);
	

}
