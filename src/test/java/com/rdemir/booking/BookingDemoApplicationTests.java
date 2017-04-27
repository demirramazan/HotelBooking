package com.rdemir.booking;

import com.rdemir.booking.controller.HotelController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingDemoApplicationTests {
    @Autowired
    private HotelController controller;

    @Test
    public void contextLoads() {
        assertEquals(3, controller.getBookings().size());
    }

}
