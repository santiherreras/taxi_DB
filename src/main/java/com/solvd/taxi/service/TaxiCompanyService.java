package com.solvd.taxi.service;

import com.solvd.taxi.dao.TaxiCompanyDAO;
import com.solvd.taxi.model.TaxiCompany;

import java.util.List;

public class TaxiCompanyService {
    private final TaxiCompanyDAO companyDAO = new TaxiCompanyDAO();

    public List<TaxiCompany> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }
}
