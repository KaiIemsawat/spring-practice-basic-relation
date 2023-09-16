package com.mvcfullcrud.one2many.repositories;

import com.mvcfullcrud.one2many.models.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepo extends JpaRepository<Hall, Long> {
    List<Hall> findAll();

    List<Hall> findAllByOrderByNameDesc();
}
