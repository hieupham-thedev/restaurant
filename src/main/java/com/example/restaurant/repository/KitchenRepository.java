package com.example.restaurant.repository;

import com.example.restaurant.entity.KitchenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitchenRepository extends JpaRepository<KitchenEntity, String> {
}
