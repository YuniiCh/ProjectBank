package org.bd;

import org.object.Company;
import org.object.Finance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe en charge de la base de données.
 */
public class DB {

    /*----- 连接数据库 -----*/
    private static Connection CX = null;

    /*----- 准备连接数据 -----*/
    private static final String URL = "jdbc:mysql://localhost:3306/citi";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "0828cyn";

    /**
     * 创建连接
     */
    private static void connexion() throws ClassNotFoundException, SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("Exception connexion() - Pilote MySql introuvable - " + ex.getMessage());
        }

        /*----- 建立连接 -----*/
        try {
            DB.CX = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException ex) {
            throw new SQLException("Exception connexion() - Problème de connexion à la base de données - " + ex.getMessage());
        }
    }

    /**
     *
     * @return
     */
    public static int countCompany() throws Exception {
        int nbCompany = 0;
        // 检查建立连接
        if (CX == null) {
            DB.connexion();
        }

        // SQL
        String sql = "SELECT count(*) FROM Company";

        // 执行SQL
        try (PreparedStatement st = CX.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                nbCompany = rs.getInt(1);
            }
        } catch (SQLException sqle) {
            throw new Exception("MessageBD.countCompany() - " + sqle.getMessage());
        }
        return nbCompany;
    }

    public static int countFinanceByIDCompany(String idC) throws Exception {
        int nbFinance = 0;
        // 检查建立连接
        if (CX == null) {
            DB.connexion();
        }

        // SQL
        String sql = "SELECT count(*) FROM Finance WHERE idC =" + idC;

        // 执行SQL
        try (PreparedStatement st = CX.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                nbFinance = rs.getInt(1);
            }
        } catch (SQLException sqle) {
            throw new Exception("MessageBD.countFinanceByIDCompany() - " + sqle.getMessage());
        }
        return nbFinance;
    }

    public static List<Company> readCompanies(int nbPerPage, int thispage) throws Exception {
        List<Company> liste = new ArrayList<>();

        // 检查建立连接
        if (CX == null) {
            DB.connexion();
        }

        // SQL
        String sql = "SELECT * FROM Company LIMIT " + (thispage - 1) * nbPerPage + ", " + nbPerPage;
        System.out.println(sql);

        // 执行SQL
        try (PreparedStatement st = CX.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            // 读取结果 
            while (rs.next()) {
                Company c = new Company(rs.getString("IdC"),
                        rs.getString("EnglishName"),
                        rs.getString("ChineseName"),
                        rs.getString("CreateDate"),
                        rs.getString("Industry"),
                        rs.getString("SecurityCode"),
                        rs.getString("SecurityType"),
                        rs.getDate("ListingDate"),
                        rs.getString("ListingExchange"),
                        rs.getString("Chairman"),
                        rs.getString("Employees"),
                        rs.getString("Tel"),
                        rs.getString("Fax"),
                        rs.getString("Email"),
                        rs.getString("Website"),
                        rs.getString("RegisteredAddress"),
                        rs.getString("OfficeAddress"));
                liste.add(c);
            }

        } catch (SQLException sqle) {
            throw new Exception("MessageBD.readCompanies() - " + sqle.getMessage());
        }
        return liste;
    }

    public static Company findCompany(String IdC) throws Exception {
        Company c = new Company();

        // 检查建立连接
        if (CX == null) {
            DB.connexion();
        }

        // SQL
        String sql = "SELECT * FROM Company WHERE IdC = '" + IdC + "'";
        // 执行SQL
        try (PreparedStatement st = CX.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            // 读取结果
            while (rs.next()) {
                c = new Company(rs.getString("IdC"),
                        rs.getString("EnglishName"),
                        rs.getString("ChineseName"),
                        rs.getString("CreateDate"),
                        rs.getString("Industry"),
                        rs.getString("SecurityCode"),
                        rs.getString("SecurityType"),
                        rs.getDate("ListingDate"),
                        rs.getString("ListingExchange"),
                        rs.getString("Chairman"),
                        rs.getString("Employees"),
                        rs.getString("Tel"),
                        rs.getString("Fax"),
                        rs.getString("Email"),
                        rs.getString("Website"),
                        rs.getString("RegisteredAddress"),
                        rs.getString("OfficeAddress"));
            }

        } catch (SQLException sqle) {
            throw new Exception("MessageBD.findCompany() - " + sqle.getMessage());
        }
        return c;
    }

    public static List<Finance> readFinances() throws Exception {
        List<Finance> liste = new ArrayList<>();

        // Connexion
        if (CX == null) {
            DB.connexion();
        }

        // Requête SQL
        String sql = "SELECT * FROM Finance";

        // Ouverture d'un espace de requête
        try (PreparedStatement st = CX.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            // Lire le résultat
            while (rs.next()) {
                Finance f = new Finance(rs.getInt("IdF"),
                        rs.getDate("Date"),
                        rs.getFloat("liabilities"),
                        rs.getFloat("assets"),
                        rs.getFloat("current_assets"),
                        rs.getFloat("current_liabilities"),
                        rs.getFloat("inventories"),
                        rs.getFloat("shareholders_equity"),
                        rs.getFloat("profits_payable"),
                        rs.getFloat("Short_loans"),
                        rs.getFloat("Long_loans"),
                        rs.getFloat("net_profit"),
                        rs.getFloat("Operating_profit"),
                        rs.getFloat("Operating_cost"),
                        rs.getFloat("Income_tax_paid"),
                        rs.getFloat("AEADNGL"),
                        rs.getFloat("Selling_expenses"),
                        rs.getFloat("business_tariff_and_annex"),
                        rs.getFloat("CPDDP"),
                        rs.getFloat("NCFOA"),
                        rs.getFloat("Cash_from_borrow"),
                        rs.getFloat("CRAB"),
                        rs.getFloat("CPFAIALA"),
                        rs.getFloat("DFAOGAPBA"),
                        rs.getFloat("Deferred_assets"),
                        rs.getFloat("SCOSE"),
                        DB.findCompany(rs.getString("IdC")));
                liste.add(f);
            }

        } catch (SQLException sqle) {
            throw new Exception("MessageBD.readFinances() - " + sqle.getMessage());
        }
        return liste;
    }

//Find a company's financial data
    public static List<Finance> readFinanceByID(String idC, int nbPerPage, int thispage) throws Exception {
        List<Finance> liste = new ArrayList<>();
        // Connexion
        if (CX == null) {
            DB.connexion();
        }

        // Requête SQL
        String sql = "SELECT * FROM Finance WHERE idC = '" + idC + "' LIMIT" + (thispage - 1) * nbPerPage  + ", " + nbPerPage;

        // Ouverture d'un espace de requête
        try (PreparedStatement st = CX.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            // Lire le résultat
            while (rs.next()) {
                Finance f = new Finance(rs.getInt("IdF"),
                        rs.getDate("Date"),
                        rs.getFloat("liabilities"),
                        rs.getFloat("assets"),
                        rs.getFloat("current_assets"),
                        rs.getFloat("current_liabilities"),
                        rs.getFloat("inventories"),
                        rs.getFloat("shareholders_equity"),
                        rs.getFloat("profits_payable"),
                        rs.getFloat("Short_loans"),
                        rs.getFloat("Long_loans"),
                        rs.getFloat("net_profit"),
                        rs.getFloat("Operating_profit"),
                        rs.getFloat("Operating_cost"),
                        rs.getFloat("Income_tax_paid"),
                        rs.getFloat("AEADNGL"),
                        rs.getFloat("Selling_expenses"),
                        rs.getFloat("business_tariff_and_annex"),
                        rs.getFloat("CPDDP"),
                        rs.getFloat("NCFOA"),
                        rs.getFloat("Cash_from_borrow"),
                        rs.getFloat("CRAB"),
                        rs.getFloat("CPFAIALA"),
                        rs.getFloat("DFAOGAPBA"),
                        rs.getFloat("Deferred_assets"),
                        rs.getFloat("SCOSE"),
                        DB.findCompany(rs.getString("IdC")));

                liste.add(f);
            }

        } catch (SQLException sqle) {
            throw new Exception("MessageBD.readFinances() - " + sqle.getMessage());
        }
        return liste;
    }

    /*----------------------------*/
 /* Programme principal (test) */
 /*----------------------------*/
    public static void main(String[] s) {

        /* // test readCompanies
            List<Company> listC = new ArrayList<>();
            try {
                listC = DB.readCompanies();
            } catch (Exception ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (Company c : listC) System.out.println(c);
            
            // test readFinances
            List<Finance> listF = new ArrayList<>();
            try {
                listF = DB.readFinances();
            } catch (Exception ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (Finance f : listF) System.out.println(f);
            
            // test findCompany
            try {  
                System.out.println(DB.findCompany("US0378331005"));
            } catch (Exception ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        // test readFinancesByIdC
        List<Finance> F2 = new ArrayList<>();
        try {
            F2 = DB.readFinanceByID("US2605571031", 10, 1);
        } catch (Exception ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Finance f : F2) {
            System.out.println(f);
        }

    }

}
/*----- Fin de la classe Bd -----*/
