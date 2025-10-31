package com.solvd.taxi.dao;

import com.solvd.taxi.config.ConnectionPool;
import com.solvd.taxi.model.TaxiCompany;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaxiCompanyDAO {

    public List<TaxiCompany> getAllCompanies() {
        List<TaxiCompany> list = new ArrayList<>();
        String sql = "SELECT * FROM TaxiCompany";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TaxiCompany c = new TaxiCompany(
                        rs.getInt("company_id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
