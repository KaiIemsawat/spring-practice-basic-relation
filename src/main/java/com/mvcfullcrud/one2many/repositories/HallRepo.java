package com.mvcfullcrud.one2many.repositories;

import com.mvcfullcrud.one2many.models.Hall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepo extends CrudRepository<Hall, Long> {
    List<Hall> findAll();

    List<Hall> findAllByOrderByNameDesc();
}
