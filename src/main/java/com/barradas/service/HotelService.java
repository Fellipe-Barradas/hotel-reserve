package com.barradas.service;

import com.barradas.domain.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);
    Page<Hotel> findAll(Pageable pageable);
    Hotel findById(Long id);
    List<Hotel> findAllByName(String name);
    Hotel update(Hotel hotel);
    void delete(Long id);

}
