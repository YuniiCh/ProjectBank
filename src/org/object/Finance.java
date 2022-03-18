package org.object;

import java.util.Date;


public class Finance {
    int IdF;
    Date DateF;
    float liabilities;
    float assets;
    float current_assets;
    float current_liabilities;
    float inventories;
    float shareholders_equity;
    float profits_payable;
    float Short_loans;
    float Long_loans;
    float net_profit;
    float Operating_profit;
    float Operating_cost;
    float Income_tax_paid;
    float AEADNGL;
    float Selling_expenses;
    float business_tariff_and_annex;
    float CPDDP;
    float NCFOA;
    float Cash_from_borrow;
    float CRAB ;
    float CPFAIALA;
    float DFAOGAPBA;
    float Deferred_assets;
    float SCOSE;
    Company company;

    public Finance() {
    }

    public Finance(int IdF, Date DateF, float liabilities, float assets, float current_assets, float current_liabilities, float inventories, float shareholders_equity, float profits_payable, float Short_loans, float Long_loans, float net_profit, float Operating_profit, float Operating_cost, float Income_tax_paid, float AEADNGL, float Selling_expenses, float business_tariff_and_annex, float CPDDP, float NCFOA, float Cash_from_borrow, float CRAB, float CPFAIALA, float DFAOGAPBA, float Deferred_assets, float SCOSE) {
        this.IdF = IdF;
        this.DateF = DateF;
        this.liabilities = liabilities;
        this.assets = assets;
        this.current_assets = current_assets;
        this.current_liabilities = current_liabilities;
        this.inventories = inventories;
        this.shareholders_equity = shareholders_equity;
        this.profits_payable = profits_payable;
        this.Short_loans = Short_loans;
        this.Long_loans = Long_loans;
        this.net_profit = net_profit;
        this.Operating_profit = Operating_profit;
        this.Operating_cost = Operating_cost;
        this.Income_tax_paid = Income_tax_paid;
        this.AEADNGL = AEADNGL;
        this.Selling_expenses = Selling_expenses;
        this.business_tariff_and_annex = business_tariff_and_annex;
        this.CPDDP = CPDDP;
        this.NCFOA = NCFOA;
        this.Cash_from_borrow = Cash_from_borrow;
        this.CRAB = CRAB;
        this.CPFAIALA = CPFAIALA;
        this.DFAOGAPBA = DFAOGAPBA;
        this.Deferred_assets = Deferred_assets;
        this.SCOSE = SCOSE;
    }
    
    // Setter & Getter

    public int getIdF() {
        return IdF;
    }

    public void setIdF(int IdF) {
        this.IdF = IdF;
    }

    public Date getDateF() {
        return DateF;
    }

    public void setDateF(Date DateF) {
        this.DateF = DateF;
    }

    public float getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(float liabilities) {
        this.liabilities = liabilities;
    }

    public float getAssets() {
        return assets;
    }

    public void setAssets(float assets) {
        this.assets = assets;
    }

    public float getCurrent_assets() {
        return current_assets;
    }

    public void setCurrent_assets(float current_assets) {
        this.current_assets = current_assets;
    }

    public float getCurrent_liabilities() {
        return current_liabilities;
    }

    public void setCurrent_liabilities(float current_liabilities) {
        this.current_liabilities = current_liabilities;
    }

    public float getInventories() {
        return inventories;
    }

    public void setInventories(float inventories) {
        this.inventories = inventories;
    }

    public float getShareholders_equity() {
        return shareholders_equity;
    }

    public void setShareholders_equity(float shareholders_equity) {
        this.shareholders_equity = shareholders_equity;
    }

    public float getProfits_payable() {
        return profits_payable;
    }

    public void setProfits_payable(float profits_payable) {
        this.profits_payable = profits_payable;
    }

    public float getShort_loans() {
        return Short_loans;
    }

    public void setShort_loans(float Short_loans) {
        this.Short_loans = Short_loans;
    }

    public float getLong_loans() {
        return Long_loans;
    }

    public void setLong_loans(float Long_loans) {
        this.Long_loans = Long_loans;
    }

    public float getNet_profit() {
        return net_profit;
    }

    public void setNet_profit(float net_profit) {
        this.net_profit = net_profit;
    }

    public float getOperating_profit() {
        return Operating_profit;
    }

    public void setOperating_profit(float Operating_profit) {
        this.Operating_profit = Operating_profit;
    }

    public float getOperating_cost() {
        return Operating_cost;
    }

    public void setOperating_cost(float Operating_cost) {
        this.Operating_cost = Operating_cost;
    }

    public float getIncome_tax_paid() {
        return Income_tax_paid;
    }

    public void setIncome_tax_paid(float Income_tax_paid) {
        this.Income_tax_paid = Income_tax_paid;
    }

    public float getAEADNGL() {
        return AEADNGL;
    }

    public void setAEADNGL(float AEADNGL) {
        this.AEADNGL = AEADNGL;
    }

    public float getSelling_expenses() {
        return Selling_expenses;
    }

    public void setSelling_expenses(float Selling_expenses) {
        this.Selling_expenses = Selling_expenses;
    }

    public float getBusiness_tariff_and_annex() {
        return business_tariff_and_annex;
    }

    public void setBusiness_tariff_and_annex(float business_tariff_and_annex) {
        this.business_tariff_and_annex = business_tariff_and_annex;
    }

    public float getCPDDP() {
        return CPDDP;
    }

    public void setCPDDP(float CPDDP) {
        this.CPDDP = CPDDP;
    }

    public float getNCFOA() {
        return NCFOA;
    }

    public void setNCFOA(float NCFOA) {
        this.NCFOA = NCFOA;
    }

    public float getCash_from_borrow() {
        return Cash_from_borrow;
    }

    public void setCash_from_borrow(float Cash_from_borrow) {
        this.Cash_from_borrow = Cash_from_borrow;
    }

    public float getCRAB() {
        return CRAB;
    }

    public void setCRAB(float CRAB) {
        this.CRAB = CRAB;
    }

    public float getCPFAIALA() {
        return CPFAIALA;
    }

    public void setCPFAIALA(float CPFAIALA) {
        this.CPFAIALA = CPFAIALA;
    }

    public float getDFAOGAPBA() {
        return DFAOGAPBA;
    }

    public void setDFAOGAPBA(float DFAOGAPBA) {
        this.DFAOGAPBA = DFAOGAPBA;
    }

    public float getDeferred_assets() {
        return Deferred_assets;
    }

    public void setDeferred_assets(float Deferred_assets) {
        this.Deferred_assets = Deferred_assets;
    }

    public float getSCOSE() {
        return SCOSE;
    }

    public void setSCOSE(float SCOSE) {
        this.SCOSE = SCOSE;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
    // HashCode & equals

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.IdF;
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
        final Finance other = (Finance) obj;
        if (this.IdF != other.IdF) {
            return false;
        }
        return true;
    }
    
    // toString

    @Override
    public String toString() {
        return "Finance{" + "IdF=" + IdF + ", DateF=" + DateF + ", liabilities=" + liabilities + ", assets=" + assets + ", current_assets=" + current_assets + ", current_liabilities=" + current_liabilities + ", inventories=" + inventories + ", shareholders_equity=" + shareholders_equity + ", profits_payable=" + profits_payable + ", Short_loans=" + Short_loans + ", Long_loans=" + Long_loans + ", net_profit=" + net_profit + ", Operating_profit=" + Operating_profit + ", Operating_cost=" + Operating_cost + ", Income_tax_paid=" + Income_tax_paid + ", AEADNGL=" + AEADNGL + ", Selling_expenses=" + Selling_expenses + ", business_tariff_and_annex=" + business_tariff_and_annex + ", CPDDP=" + CPDDP + ", NCFOA=" + NCFOA + ", Cash_from_borrow=" + Cash_from_borrow + ", CRAB=" + CRAB + ", CPFAIALA=" + CPFAIALA + ", DFAOGAPBA=" + DFAOGAPBA + ", Deferred_assets=" + Deferred_assets + ", SCOSE=" + SCOSE + '}';
    }
    
}
