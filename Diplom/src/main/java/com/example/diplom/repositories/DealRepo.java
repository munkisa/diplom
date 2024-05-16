package com.example.diplom.repositories;

import com.example.diplom.entities.DealEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DealRepo extends JpaRepository<DealEntity, Long> {
    //Optional<DealEntity> findByDeal_id(Long deal_id);
}
