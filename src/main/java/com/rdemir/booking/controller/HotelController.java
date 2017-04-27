package com.rdemir.booking.controller;

import com.rdemir.booking.model.HotelBooking;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
public class HotelController {
    List<HotelBooking> hotelBookingList;

    public HotelController() {
        hotelBookingList = new ArrayList<HotelBooking>();

        hotelBookingList.add(new HotelBooking("Mavi Deniz", 150.50, 5, 10));
        hotelBookingList.add(new HotelBooking("Mariot", 200.50, 3, 5));
        hotelBookingList.add(new HotelBooking("Hilton", 275.8, 4, 10));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getBookings() {
        return hotelBookingList;
    }

    @RequestMapping(value = "/affordable/{price}")
    public List<HotelBooking> getAffordableBooking(@PathVariable double price) {
        return hotelBookingList.stream().filter(y -> y.getPriceOfNigth() <= price)
                .collect(Collectors.toList());
    }
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public  List<HotelBooking> createBooking(@RequestBody HotelBooking hotelBooking){
        hotelBookingList.add(hotelBooking);
        return hotelBookingList;
    }
}
