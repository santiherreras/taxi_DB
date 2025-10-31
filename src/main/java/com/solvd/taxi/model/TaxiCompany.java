package com.solvd.taxi.model;

public class TaxiCompany {
    private int companyId;
    private String name;
    private String address;
    private String phone;

    public TaxiCompany() {}

    public TaxiCompany(int companyId, String name, String address, String phone) {
        this.companyId = companyId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getCompanyId() { return companyId; }
    public void setCompanyId(int companyId) { this.companyId = companyId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "TaxiCompany{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
