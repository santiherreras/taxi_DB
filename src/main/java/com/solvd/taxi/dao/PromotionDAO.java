package com.solvd.taxi.dao;

import com.solvd.taxi.config.ConnectionPool;
import com.solvd.taxi.model.Promotion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PromotionDAO {

    public List<Promotion> getAllPromotions() {
        List<Promotion> promotions = new ArrayList<>();
        String sql = "SELECT * FROM Promotions";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Promotion promo = new Promotion(
                        rs.getInt("promotion_id"),
                        rs.getString("code"),
                        rs.getString("description"),
                        rs.getDouble("discount_percentage")
                );
                promotions.add(promo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotions;
    }

    public void deletePromotion(int promoId) {
        String sql = "DELETE FROM Promotions WHERE promotion_id = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, promoId);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("🗑️ Promotion deleted (ID " + promoId + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
