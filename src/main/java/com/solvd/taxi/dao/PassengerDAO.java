package com.solvd.taxi.dao;

import com.solvd.taxi.config.ConnectionPool;
import com.solvd.taxi.model.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerDAO {

    public void insertPassenger(Passenger passenger) {
        String sql = "INSERT INTO Passengers (name, phone) VALUES (?, ?)";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, passenger.getName());
            ps.setString(2, passenger.getPhone());
            ps.executeUpdate();
            System.out.println("Passenger inserted: " + passenger.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePassengerPhone(int passengerId, String newPhone) {
        String sql = "UPDATE Passengers SET phone = ? WHERE passenger_id = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newPhone);
            ps.setInt(2, passengerId);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Passenger phone updated (ID " + passengerId + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePassenger(int passengerId) {
        String sql = "DELETE FROM Passengers WHERE passenger_id = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, passengerId);
            ps.executeUpdate();
            System.out.println("Passenger deleted: " + passenger.getName()) + " Id: " + passengerId;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Passenger> getAllPassengers() {
        List<Passenger> passengers = new ArrayList<>();
        String sql = "SELECT * FROM Passengers";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Passenger p = new Passenger(
                        rs.getInt("passenger_id"),
                        rs.getString("name"),
                        rs.getString("phone")
                );
                passengers.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passengers;
    }
}
