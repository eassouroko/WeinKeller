package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.WineCategory;
@Repository
public interface WineCategoryRepository extends CrudRepository<WineCategory,Long> {
	WineCategory findByCategoryDescription(String categoryDescription);
	

}
