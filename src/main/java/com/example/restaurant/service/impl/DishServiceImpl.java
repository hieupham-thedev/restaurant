package com.example.restaurant.service.impl;

import com.example.restaurant.dto.DishDTO;
import com.example.restaurant.dto.ListingRequestDTO;
import com.example.restaurant.dto.ListingResponseDTO;
import com.example.restaurant.entity.DishEntity;
import com.example.restaurant.repository.DishRepository;
import com.example.restaurant.service.DishService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Override
    public ListingResponseDTO getAll(ListingRequestDTO requestDTO) {
        int pageSize = requestDTO.getEnd() - requestDTO.getStart();
        int pageNumber = requestDTO.getEnd() / pageSize - 1;
        Sort sort = Sort.by(Sort.Direction.fromString(requestDTO.getOrder()), requestDTO.getSort());
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<DishEntity> dishEntities = dishRepository.findAll(pageable);
        List<DishDTO> dishDTOs = dishEntities.getContent().stream().map(dishEntity -> {
            DishDTO dishDTO = new DishDTO();
            BeanUtils.copyProperties(dishEntity, dishDTO);
            return dishDTO;
        }).collect(Collectors.toList());
        ListingResponseDTO responseDTO = new ListingResponseDTO();
        responseDTO.setData(dishDTOs);
        responseDTO.setTotal(dishEntities.getTotalElements());
        return responseDTO;
    }

    @Override
    public DishDTO save(DishDTO dishDTO) {
        DishEntity dishEntity = new DishEntity();
        BeanUtils.copyProperties(dishDTO, dishEntity);
        dishRepository.save(dishEntity);
        BeanUtils.copyProperties(dishEntity, dishDTO);
        return dishDTO;
    }
}
