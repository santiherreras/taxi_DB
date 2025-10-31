package com.solvd.taxi.model;

public class Promotion {
    private int promotionId;
    private String code;
    private String description;
    private double discountPercentage;

    public Promotion(int promotionId, String code, String description, double discountPercentage) {
        this.promotionId = promotionId;
        this.code = code;
        this.description = description;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString() {
        return "Promotion {id=" + promotionId + ", code='" + code + "', discount=" + discountPercentage + "%}";
    }
}
