package com.mvcfullcrud.one2many.repositories;


import com.mvcfullcrud.one2many.models.University;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepo extends CrudRepository<University, Long> {
    List<University> findAll();

    List<University> findAllByOrderByNameDesc(); // <- SELECT * FROM universities ORDER BY name DESC
}
