package com.barradas.service.impl;

import com.barradas.domain.Hotel;
import com.barradas.domain.User;
import com.barradas.dto.FilterDTO;
import com.barradas.repository.HotelRepository;
import com.barradas.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Filter;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Page<Hotel> findAllWithFilter(Pageable pageable, FilterDTO filterDTO) {
        int maxPrice = filterDTO.maxPrice() == 0 ? Integer.MAX_VALUE : filterDTO.maxPrice();
        return hotelRepository.findAllByPriceBetween(pageable, filterDTO.minPrice(), maxPrice);
    }

    @Override
    public Hotel findById(Long id) {
        return hotelRepository
                .findById(id)
                .orElseThrow(()-> new NoSuchElementException("Hotel not found"));
    }

    @Override
    public List<Hotel> findAllByName(String name) {
        return hotelRepository.findAllByName(name);
    }

    @Override
    public Hotel update(Hotel hotel) {
        Hotel hotelToUpdate = findById(hotel.getId());
        if(hotelToUpdate == null) {
            throw new NoSuchElementException("Hotel not found");
        }
        updateHotelData(hotel, hotelToUpdate);
        return hotelRepository.save(hotelToUpdate);
    }

    @Override
    public void delete(Long id) {
        if(!hotelRepository.existsById(id)) {
            throw new NoSuchElementException("Hotel not found");
        }
        hotelRepository.deleteById(id);
    }

    private void updateHotelData(Hotel hotel, Hotel hotelToUpdate) {
        hotelToUpdate.setName(hotel.getName());
        hotelToUpdate.setDescription(hotel.getDescription());
        hotelToUpdate.setPrice(hotel.getPrice());
        hotelToUpdate.setCreationDate(hotel.getCreationDate());
        hotelToUpdate.setCity(hotel.getCity());
        hotelToUpdate.setState(hotel.getState());
    }
}
