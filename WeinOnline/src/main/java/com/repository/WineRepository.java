package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Wine;

@Repository
public interface WineRepository extends JpaRepository<Wine, Long> {
	
	Wine findByWineCode(String wineCode);
	public List<Wine> findByWineCategoryId(long categoryid);
	
	@Query(value = "SELECT * FROM wine WHERE wine_name LIKE %:searchTerm%", nativeQuery = true)
	public List<Wine> searchWithNativeQuery(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT w FROM Wine w WHERE w.wineCategory LIKE %:searchTerm%")
    public List<Wine> searchWithJPQLQuery(@Param("searchTerm") String searchTerm);

	

}
