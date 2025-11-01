package com.solvd.taxi.service;

import com.solvd.taxi.dao.BookingDAO;
import com.solvd.taxi.model.Booking;

import java.util.List;

public class BookingService {
    private final BookingDAO bookingDAO = new BookingDAO();

    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }


}
