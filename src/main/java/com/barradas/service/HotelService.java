package com.barradas.service;

import com.barradas.domain.Hotel;
import com.barradas.dto.FilterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);
    Page<Hotel> findAllWithFilter(Pageable pageable, FilterDTO filterDTO);
    Hotel findById(Long id);
    List<Hotel> findAllByName(String name);
    Hotel update(Hotel hotel);
    void delete(Long id);

}
