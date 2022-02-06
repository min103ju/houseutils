package com.citizen.houseutils.service;

import com.citizen.houseutils.exception.ErrorCode;
import com.citizen.houseutils.exception.HouseUtilsException;
import com.citizen.houseutils.repository.ApartmentRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * author : citizen103
 */
@Service
@RequiredArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    @Transactional
    public Long getPriceOrThrow(Long apartmentId) {
        return apartmentRepository.findById(apartmentId)
            .orElseThrow(() -> new HouseUtilsException(ErrorCode.ENTITY_NOT_FOUND))
            .getPrice();
    }

}
