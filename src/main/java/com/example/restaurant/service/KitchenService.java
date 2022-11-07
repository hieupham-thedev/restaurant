package com.example.restaurant.service;

import com.example.restaurant.dto.KitchenDTO;
import com.example.restaurant.dto.ListingRequestDTO;
import com.example.restaurant.dto.ListingResponseDTO;

import java.util.List;

public interface KitchenService {

    KitchenDTO save(KitchenDTO kitchenDTO);

    ListingResponseDTO getAll(ListingRequestDTO requestDTO);
}
