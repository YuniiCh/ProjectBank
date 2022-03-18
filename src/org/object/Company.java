package org.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Company {
    String IdC;
    String EnglishName;
    String ChineseName;
    String CreateDate;
    String Industry;
    String SecurityCode;
    String SecurityType;
    Date ListingDate;
    String ListingExchange;
    String Chairman;
    String Employees;
    String Tel;
    String Fax;
    String Email;
    String Website;
    String RegisteredAddress;
    String OfficeAddress;
    List<Finance> financeRepport;
    
    // Constructor
    public Company() {
        this.financeRepport = new ArrayList<>();
    }
    public Company(String IdC, String EnglishName, String ChineseName, String CreateDate, String Industry, String SecurityCode, String SecurityType, Date ListingDate, String ListingExchange, String Chairman, String Employees, String Tel, String Fax, String Email, String Website, String RegisteredAddress, String OfficeAddress) {
        this.IdC = IdC;
        this.EnglishName = EnglishName;
        this.ChineseName = ChineseName;
        this.CreateDate = CreateDate;
        this.Industry = Industry;
        this.SecurityCode = SecurityCode;
        this.SecurityType = SecurityType;
        this.ListingDate = ListingDate;
        this.ListingExchange = ListingExchange;
        this.Chairman = Chairman;
        this.Employees = Employees;
        this.Tel = Tel;
        this.Fax = Fax;
        this.Email = Email;
        this.Website = Website;
        this.RegisteredAddress = RegisteredAddress;
        this.OfficeAddress = OfficeAddress;
        this.financeRepport = new ArrayList<>();
    }
    
    // Getter & Setter
    public String getIdC() {
        return IdC;
    }

    public void setIdC(String IdC) {
        this.IdC = IdC;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public void setEnglishName(String EnglishName) {
        this.EnglishName = EnglishName;
    }

    public String getChineseName() {
        return ChineseName;
    }

    public void setChineseName(String ChineseName) {
        this.ChineseName = ChineseName;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }

    public String getIndustry() {
        return Industry;
    }

    public void setIndustry(String Industry) {
        this.Industry = Industry;
    }

    public String getSecurityCode() {
        return SecurityCode;
    }

    public void setSecurityCode(String SecurityCode) {
        this.SecurityCode = SecurityCode;
    }

    public String getSecurityType() {
        return SecurityType;
    }

    public void setSecurityType(String SecurityType) {
        this.SecurityType = SecurityType;
    }

    public Date getListingDate() {
        return ListingDate;
    }

    public void setListingDate(Date ListingDate) {
        this.ListingDate = ListingDate;
    }

    public String getListingExchange() {
        return ListingExchange;
    }

    public void setListingExchange(String ListingExchange) {
        this.ListingExchange = ListingExchange;
    }

    public String getChairman() {
        return Chairman;
    }

    public void setChairman(String Chairman) {
        this.Chairman = Chairman;
    }

    public String getEmployees() {
        return Employees;
    }

    public void setEmployees(String Employees) {
        this.Employees = Employees;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String Website) {
        this.Website = Website;
    }

    public String getRegisteredAddress() {
        return RegisteredAddress;
    }

    public void setRegisteredAddress(String RegisteredAddress) {
        this.RegisteredAddress = RegisteredAddress;
    }

    public String getOfficeAddress() {
        return OfficeAddress;
    }

    public void setOfficeAddress(String OfficeAddress) {
        this.OfficeAddress = OfficeAddress;
    }

    public List<Finance> getFinanceRepport() {
        return financeRepport;
    }

    public void setFinanceRepport(List<Finance> financeRepport) {
        this.financeRepport = financeRepport;
    }
    
    // HashCode & equals

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.IdC);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Company other = (Company) obj;
        if (!Objects.equals(this.IdC, other.IdC)) {
            return false;
        }
        return true;
    }
    
    // toString
    @Override
    public String toString() {
        return "Company{" + "IdC=" + IdC + ", EnglishName=" + EnglishName + ", ChineseName=" + ChineseName + ", CreateDate=" + CreateDate + ", Industry=" + Industry + ", SecurityCode=" + SecurityCode + ", SecurityType=" + SecurityType + ", ListingDate=" + ListingDate + ", ListingExchange=" + ListingExchange + ", Chairman=" + Chairman + ", Employees=" + Employees + ", Tel=" + Tel + ", Fax=" + Fax + ", Email=" + Email + ", Website=" + Website + ", RegisteredAddress=" + RegisteredAddress + ", OfficeAddress=" + OfficeAddress + '}';
    }
}
