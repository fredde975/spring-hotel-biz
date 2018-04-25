package com.example.hotelbiz.controllers;

import org.junit.Test;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.Assert.*;

public class HotelControllerTest {

    @Test
    public void sayHello() {
        HotelController hotelController = new HotelController();
        String result = hotelController.sayHello("Dolly", new BindingAwareModelMap());
        assertEquals("hello", result);
    }
}