package com.solvd.taxi.dao;

import com.solvd.taxi.config.ConnectionPool;
import com.solvd.taxi.model.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM Payments";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Payment p = new Payment(
                        rs.getInt("payment_id"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("payment_date").toLocalDateTime(),
                        rs.getInt("method_id")
                );
                payments.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    public void deletePayment(int paymentId) {
        String sql = "DELETE FROM Payments WHERE payment_id = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, paymentId);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("🗑️ Payment deleted (ID " + paymentId + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
