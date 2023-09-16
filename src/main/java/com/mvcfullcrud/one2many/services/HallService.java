package com.mvcfullcrud.one2many.services;

import com.mvcfullcrud.one2many.models.Hall;
import com.mvcfullcrud.one2many.repositories.HallRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallService {

    @Autowired
    private HallRepo hallRepo;

    public Hall createHall(Hall newHall) {
        return hallRepo.save(newHall);
    }

    public List<Hall> findAllHalls() {
        return hallRepo.findAll();
    }

    public List<Hall> findAllHallsReverse() {
        return hallRepo.findAllByOrderByNameDesc();
    }

    public Hall findHallById(Long id) {
        Optional<Hall> optionalHall = hallRepo.findById(id);
        return optionalHall.orElseGet(() -> null);
    }

    public void save(Hall theHall) {
        hallRepo.save(theHall);
    }

}
