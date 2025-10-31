package com.solvd.taxi.dao;

import com.solvd.taxi.config.ConnectionPool;
import com.solvd.taxi.model.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {

    public List<Review> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM Reviews";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Review r = new Review(
                        rs.getInt("review_id"),
                        rs.getInt("rating"),
                        rs.getString("comment"),
                        rs.getInt("passenger_id"),
                        rs.getInt("driver_id")
                );
                reviews.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    public void deleteReview(int reviewId) {
        String sql = "DELETE FROM Reviews WHERE review_id = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, reviewId);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("🗑️ Review deleted (ID " + reviewId + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
