package com.rdemir.booking.controller;

import com.rdemir.booking.model.HotelBooking;
import com.rdemir.booking.reporsitory.HotelBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/booking")
public class HotelControllerRepoSample {

    @Autowired
    private HotelBookingRepository bookingRepository;

    /*public HotelControllerRepoSample(HotelBookingRepository repository) {
        this.bookingRepository = repository;
    }*/

    @RequestMapping(value = "/alls", method = RequestMethod.GET)
    public List<HotelBooking> getBookings() {
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordables/{price}")
    public List<HotelBooking> getAffordableBooking(@PathVariable double price) {
        return bookingRepository.findByPriceOfNigthLessThanEqual(price);
    }

    @RequestMapping(value = "/creates", method = RequestMethod.POST)
    public List<HotelBooking> createBooking(@RequestBody HotelBooking hotelBooking) {
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public List<HotelBooking> deleteBooking(@PathVariable long id) {
        bookingRepository.delete(id);
        return bookingRepository.findAll();
    }
}
