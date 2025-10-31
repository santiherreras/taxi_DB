package com.solvd.taxi.model;

public class Review {
    private int reviewId;
    private int rating;
    private String comment;
    private int passengerId;
    private int driverId;

    public Review(int reviewId, int rating, String comment, int passengerId, int driverId) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.comment = comment;
        this.passengerId = passengerId;
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "Review {id=" + reviewId + ", rating=" + rating + ", comment='" + comment + "'}";
    }
}
