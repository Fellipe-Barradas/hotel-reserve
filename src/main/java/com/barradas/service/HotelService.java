package com.barradas.service;

import com.barradas.domain.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);
    List<Hotel> findAll();
    Hotel findById(Long id);
    List<Hotel> findAllByName(String name);
    Hotel update(Hotel hotel);
    void delete(Long id);

}
