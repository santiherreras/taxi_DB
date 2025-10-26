package com.solvd.taxi.dao;



import com.solvd.taxi.config.ConnectionPool;
import com.solvd.taxi.model.Driver;
import java.sql.*;
import java.util.*;
import java.time.*;

public class DriverDAO {

    public List<Driver> getAllDrivers() {
        List<Driver> list = new ArrayList<>();
        String sql = "SELECT * FROM Drivers";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Driver d = new Driver(
                        rs.getInt("driver_id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getDate("hire_date") != null ? rs.getDate("hire_date").toLocalDate() : null,
                        rs.getInt("company_id")
                );
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
