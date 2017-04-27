package com.rdemir.booking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
public class HotelBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private long id;
    @Getter
    private String hotelName;
    @Getter
    private double priceOfNigth;
    @Getter
    private int numberOfNigth;
    @Getter
    private int numberOfRoom;

    public HotelBooking() {
    }
//
    public HotelBooking(String hotelName, double priceOfNigth, int numberOfNigth, int numberOfRoom) {
        this.hotelName = hotelName;
        this.numberOfNigth = numberOfNigth;
        this.priceOfNigth = priceOfNigth;
        this.numberOfRoom = numberOfRoom;
    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getHotelName() {
//        return hotelName;
//    }
//
//    public double getPriceOfNigth() {
//        return priceOfNigth;
//    }
//
//    public int getNumberOfNigth() {
//        return numberOfNigth;
//    }
//
//    public int getNumberOfRoom() {
//        return numberOfRoom;
//    }

    public double getTotalPrice() {
        return priceOfNigth * numberOfNigth;
    }
}
