package com.barradas.repository;

import com.barradas.domain.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query("FROM Hotel h WHERE lower(h.name) LIKE lower(concat('%',:name, '%'))")
    List<Hotel> findAllByName(String name);

    @Query("FROM Hotel h WHERE h.price >= :minPrice AND h.price <= :maxPrice")
    Page<Hotel> findAllByPriceBetween(Pageable pageable, int minPrice, int maxPrice);
}
