package com.example.hotelbiz.persistence;


import com.example.hotelbiz.entities.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.hamcrest.HamcrestArgumentMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.containsInAnyOrder;
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
    public void getOneV1() throws Exception{
        template.query("select id from hotels", (rs, num) -> rs.getInt("id"))
                .forEach(id -> {
                    Hotel hotel = hotelRepository.getOne(id);
                    assertNotNull(hotel);
                    assertEquals(id, hotel.getId());
                });
  }

    @Test
    public void getOneV2() throws Exception{
        template.query("select id from hotels", (rs, num) -> rs.getInt("id"))
                .forEach(id -> {
                    Optional<Hotel> optionalHotel = hotelRepository.findById(id);
                    assertTrue(optionalHotel.isPresent());
                    assertEquals(id, optionalHotel.get().getId());
                });
    }

    @Test
    public void findAllTest(){
        List<String> dbNames = hotelRepository.findAll().stream()
                .map(Hotel::getName)
                .collect(Collectors.toList());
        dbNames.forEach(System.out::println);
        assertThat(dbNames, containsInAnyOrder("Grand Hotel", "Marriot", "iBiz", "Scandic", "Stadt"));
    }
}