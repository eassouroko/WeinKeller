package com.repository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Wine;
@Repository
public interface WineRepository extends CrudRepository<Wine,Long> {
   Wine findByWineCode(String wineCode);
}
