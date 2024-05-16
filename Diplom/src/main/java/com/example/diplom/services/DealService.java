package com.example.diplom.services;

import com.example.diplom.entities.DealEntity;
import com.example.diplom.repositories.DealRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DealService {
    DealRepo dealRepo;

    public void saveDeal(DealEntity deal) {
        dealRepo.save(deal);
    }

    public List<DealEntity> getDeals() {
        return dealRepo.findAll();
    }

    public void chargeDeal() {

    }
}
