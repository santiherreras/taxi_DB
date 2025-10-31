package com.solvd.taxi.dao;

import com.solvd.taxi.config.ConnectionPool;
import com.solvd.taxi.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

    public void insertCar(Car car) {
        String sql = "INSERT INTO Cars (license_plate, model, brand, year, company_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, car.getLicensePlate());
            ps.setString(2, car.getModel());
            ps.setString(3, car.getBrand());
            ps.setInt(4, car.getYear());
            ps.setInt(5, car.getCompanyId());
            ps.executeUpdate();
            System.out.println("✅ Car inserted: " + car.getLicensePlate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCarModel(int carId, String newModel) {
        String sql = "UPDATE Cars SET model = ? WHERE car_id = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newModel);
            ps.setInt(2, carId);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("✅ Car updated successfully (ID " + carId + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM Cars";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Car c = new Car(
                        rs.getInt("car_id"),
                        rs.getString("license_plate"),
                        rs.getString("model"),
                        rs.getString("brand"),
                        rs.getInt("year"),
                        rs.getInt("company_id")
                );
                cars.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
