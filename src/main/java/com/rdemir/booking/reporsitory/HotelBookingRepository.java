package com.rdemir.booking.reporsitory;

import com.rdemir.booking.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ramazan on 27.04.2017.
 */
@Repository
public interface HotelBookingRepository extends JpaRepository<HotelBooking,Long> {
    List<HotelBooking> findByPriceOfNigthLessThanEqual(double price);
}
