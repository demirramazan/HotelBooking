package com.rdemir.booking.controller;

import com.rdemir.booking.model.HotelBooking;
import com.rdemir.booking.reporsitory.HotelBookingRepository;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/booking")
@Api(name = "Hotel Booking API", description = "", stage = ApiStage.RC)
public class HotelControllerRepoSample {

    @Autowired
    private HotelBookingRepository bookingRepository;

    /*public HotelControllerRepoSample(HotelBookingRepository repository) {
        this.bookingRepository = repository;
    }*/

    @RequestMapping(value = "/alls", method = RequestMethod.GET)
    @ApiMethod(description = "all booking")
    public List<HotelBooking> getBookings() {
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordables/{price}")
    @ApiMethod(description = "affordable booking")
    public List<HotelBooking> getAffordableBooking(@ApiPathParam(name = "price") @PathVariable double price) {
        return bookingRepository.findByPriceOfNigthLessThanEqual(price);
    }

    @RequestMapping(value = "/creates", method = RequestMethod.POST)
    @ApiMethod(description = "create booking")
    public List<HotelBooking> createBooking(@RequestBody HotelBooking hotelBooking) {
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    @ApiMethod(description = "delete booking")
    public List<HotelBooking> deleteBooking(@ApiPathParam(name = "id")@PathVariable long id) {
        bookingRepository.delete(id);
        return bookingRepository.findAll();
    }
}
