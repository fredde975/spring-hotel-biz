package com.example.hotelbiz.persistence;

import com.example.hotelbiz.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findByName(@Param("name") String name);
    List<Hotel> findByClassification(@Param("classificatopn") String classification);

}
