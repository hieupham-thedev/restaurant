package com.example.restaurant.repository;

import com.example.restaurant.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<DishEntity, String> {
}
