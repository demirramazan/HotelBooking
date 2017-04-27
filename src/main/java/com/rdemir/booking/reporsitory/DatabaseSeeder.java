package com.rdemir.booking.reporsitory;

import com.rdemir.booking.model.HotelBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramazan on 27.04.2017.
 */
@Component
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    private HotelBookingRepository bookingRepository;

    @Override
    public void run(String... strings) throws Exception {
        List<HotelBooking> hotelBookingList = new ArrayList<HotelBooking>();

        hotelBookingList.add(new HotelBooking("Mavi Deniz", 150.50, 5, 10));
        hotelBookingList.add(new HotelBooking("Mariot", 200.50, 3, 5));
        hotelBookingList.add(new HotelBooking("Hilton", 275.8, 4, 10));

        bookingRepository.save(hotelBookingList);
    }
}
