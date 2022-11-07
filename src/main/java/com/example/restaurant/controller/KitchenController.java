package com.example.restaurant.controller;

import com.example.restaurant.dto.KitchenDTO;
import com.example.restaurant.dto.ListingRequestDTO;
import com.example.restaurant.dto.ListingResponseDTO;
import com.example.restaurant.service.KitchenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/api")
public class KitchenController {

    private static final Logger logger = LoggerFactory.getLogger(KitchenController.class);

    @Autowired
    private KitchenService kitchenService;

    @GetMapping("/kitchens")
    public ResponseEntity getAllKitchens(@RequestParam Map<String, String> requestParam) {
        ObjectMapper mapper = new ObjectMapper();
        ListingRequestDTO requestDTO = mapper.convertValue(requestParam, ListingRequestDTO.class);
        logger.info("Get kitchens with request dto {}", requestDTO);
        ListingResponseDTO responseDTO = kitchenService.getAll(requestDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Total-Count", String.valueOf(responseDTO.getTotal()));
        ResponseEntity responseEntity = new ResponseEntity(responseDTO.getData(), headers, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/kitchens")
    public ResponseEntity createKitchen(@RequestBody KitchenDTO kitchenDTO) {
        KitchenDTO responseKitchenDTO = kitchenService.save(kitchenDTO);
        return ResponseEntity.ok(responseKitchenDTO);
    }
}
