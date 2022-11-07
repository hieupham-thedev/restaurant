package com.example.restaurant.service;

import com.example.restaurant.dto.DishDTO;
import com.example.restaurant.dto.ListingRequestDTO;
import com.example.restaurant.dto.ListingResponseDTO;

public interface DishService {
    ListingResponseDTO getAll(ListingRequestDTO requestDTO);

    DishDTO save(DishDTO dishDTO);
}
