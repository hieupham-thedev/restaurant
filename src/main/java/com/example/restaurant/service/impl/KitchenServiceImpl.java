package com.example.restaurant.service.impl;

import com.example.restaurant.dto.KitchenDTO;
import com.example.restaurant.dto.ListingRequestDTO;
import com.example.restaurant.dto.ListingResponseDTO;
import com.example.restaurant.entity.KitchenEntity;
import com.example.restaurant.repository.KitchenRepository;
import com.example.restaurant.service.KitchenService;
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
public class KitchenServiceImpl implements KitchenService {

    @Autowired
    private KitchenRepository kitchenRepository;

    @Override
    public KitchenDTO save(KitchenDTO kitchenDTO) {
        KitchenEntity kitchenEntity = new KitchenEntity();
        BeanUtils.copyProperties(kitchenDTO, kitchenEntity);
        kitchenRepository.save(kitchenEntity);
        BeanUtils.copyProperties(kitchenEntity, kitchenDTO);
        return kitchenDTO;
    }

    @Override
    public ListingResponseDTO getAll(ListingRequestDTO requestDTO) {
        int pageSize = requestDTO.getEnd() - requestDTO.getStart();
        int pageNumber = requestDTO.getEnd() / pageSize - 1;
        Sort sort = Sort.by(Sort.Direction.fromString(requestDTO.getOrder()), requestDTO.getSort());
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<KitchenEntity> kitchenEntities = kitchenRepository.findAll(pageable);
        List<KitchenDTO> kitchenDTOs = kitchenEntities.getContent().stream().map(kitchenEntity -> {
            KitchenDTO kitchenDTO = new KitchenDTO();
            BeanUtils.copyProperties(kitchenEntity, kitchenDTO);
            return kitchenDTO;
        }).collect(Collectors.toList());
        ListingResponseDTO responseDTO = new ListingResponseDTO();
        responseDTO.setData(kitchenDTOs);
        responseDTO.setTotal(kitchenEntities.getTotalElements());
        return responseDTO;
    }
}
