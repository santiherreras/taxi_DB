package com.solvd.taxi.model;

import java.time.LocalDateTime;

public class Booking {
    private int bookingId;
    private LocalDateTime bookingDate;
    private int passengerId;
    private int promotionId;

    public Booking(int bookingId, LocalDateTime bookingDate, int passengerId, int promotionId) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.passengerId = passengerId;
        this.promotionId = promotionId;
    }

    public int getBookingId() { return bookingId; }
    public LocalDateTime getBookingDate() { return bookingDate; }
    public int getPassengerId() { return passengerId; }
    public int getPromotionId() { return promotionId; }

    @Override
    public String toString() {
        return "Booking {id=" + bookingId + ", date=" + bookingDate + ", passengerId=" + passengerId + ", promoId=" + promotionId + "}";
    }
}
