package com.example.hotelbiz.persistence;


import com.example.hotelbiz.entities.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


@DataJpaTest
@Transactional
@RunWith(SpringRunner.class)
public class HotelRepositoryTest {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    private JdbcTemplate template;

    @Test
    public void save() {
        Hotel hotel = new Hotel("fredrik", 5, false);
        hotel = hotelRepository.save(hotel);
        assertNotNull(hotel.getId());
    }

    @Test
    public void getOne() throws Exception{
        template.query("select id from hotels", (rs, num) -> rs.getInt("id"))
                .forEach(id -> {
                    Hotel hotel = hotelRepository.getOne(id);
                    assertNotNull(hotel);
                    assertEquals(id, hotel.getId());
                });
  }
}