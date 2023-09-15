package com.mvcfullcrud.one2many.services;


import com.mvcfullcrud.one2many.models.University;
import com.mvcfullcrud.one2many.repositories.UniversityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepo universityRepo;

//    Add a university
    public University createUniversity (University newUniversity) {
        return universityRepo.save(newUniversity);
    }

//    Get all universities
    public List<University> findAllUniversities() {
        return universityRepo.findAll();
    }

//    Get one university by id
    public University findOneUniversityById(Long id) {
        Optional<University> optionalUniversity = universityRepo.findById(id);
        return optionalUniversity.orElseGet(() -> null);
    }

//    Update university
    public University updateUniversity(University updatedUniversity) {
        return universityRepo.save(updatedUniversity);
    }

//    Delete a university
    public void deleteUniversity(Long id) {
        universityRepo.deleteById(id);
    }
}
