package org.bd;

import org.object.Company;
import org.object.Finance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
        String sql = "SELECT count(*) FROM Finance WHERE idC='" + idC + "'";

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
    public static List<Finance> readFinanceByID(String idC) throws Exception {
        List<Finance> liste = new ArrayList<>();
        // Connexion
        if (CX == null) {
            DB.connexion();
        }

        // Requête SQL
        String sql = "SELECT * FROM Finance WHERE idC='" + idC + "'";

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

//Find all Data for Report by ccompany id
    public static HashMap<String, Float> findAvgData() throws ClassNotFoundException, SQLException, Exception {
        List<Float> liste = new ArrayList<>();
        HashMap<String, Float> data = new HashMap();
        // Connexion
        if (CX == null) {
            DB.connexion();
        }

        // Requête SQL
        String sql = "SELECT(AVG(rate_liabi_ass)*0.1 + AVG(rate_current)*0.2+AVG(ebitda)*0.1)*0.4+(AVG(return_net_assets)+AVG(return_net_assets))*0.15*0.3+\n"
                + "       (AVG(total_asset_turnover)*0.8+ +AVG(current_asset_turnover*0.12))*0.2 + (AVG(sale_growth_rate*0.06 ) +AVG(capital_accumule_rate*0.04))*0.1 +\n"
                + "       (AVG(return_net_assets)*0.2+AVG(rate_sale_profit)*0.1+AVG(total_asset_turnover)*0.2+AVG(NCFOA)*0.2+AVG(net_loan_flow)*0.3)*0.5+AVG(Debt_Service_Coverage_Ratio) AS avgCredit,\n"
                + "       AVG(sale_growth_rate) AS sale_growth_rate,AVG(cp_ratio) AS cp_ratio, AVG(age) AS age, AVG(marketing_expense_ratio) AS marketing_expense_ratio,"
                + " AVG(t.account_receivable) as account_receivable,"
                + " AVG(t.operating_profit) AS operating_profit,AVG(t.working_capital) AS t.working_capital\n"
                + "FROM(\n" +
"        SELECT IdC, ROUND(DATEDIFF(CURRENT_DATE, CreateDate)/365) AS age FROM company WHERE CreateDate IS NOT NULL\n" +
"    ) t3 right join (\n" +
"    SELECT t1.IdC, rate_liabi_ass, rate_current, ebitda, rate_sale_profit, NCFOA,net_loan_flow, Debt_Service_Coverage_Ratio,marketing_expense_ratio,cp_ratio,\n" +
"           return_net_assets, total_asset_turnover, current_asset_turnover,sale_growth_rate, capital_accumule_rate, account_receivable,operating_profit,working_capital\n" +
"    FROM (\n" +
"             SELECT t.IdC, AVG(t.rate_liabi_ass) AS rate_liabi_ass, AVG(t.rate_current) AS rate_current, AVG(t.ebitda) AS ebitda,\n" +
"                    AVG(t.rate_sale_profit) AS rate_sale_profit, AVG(NCFOA) AS NCFOA,\n" +
"                    AVG(t.net_loan_flow) AS net_loan_flow, AVG(t.Debt_Service_Coverage_Ratio) AS Debt_Service_Coverage_Ratio,\n" +
"                    AVG(t.marketing_expense_ratio) AS marketing_expense_ratio, AVG(t.cp_ratio) AS cp_ratio, AVG(t.account_receivable) as account_receivable,\n" +
"                    AVG(t.operating_profit) AS operating_profit,AVG(t.working_capital) AS working_capital\n" +
"             FROM (\n" +
"                      SELECT IdC,(liabilities/assets) AS rate_liabi_ass , (current_assets/current_liabilities) AS rate_current,\n" +
"                             (net_profit + Income_tax_paid + DFAOGAPBA +Deferred_assets + profits_payable - SCOSE) AS ebitda,\n" +
"                             (Operating_profit - Operating_cost - business_tariff_and_annex) AS rate_sale_profit,\n" +
"                             NCFOA, Cash_from_borrow - CRAB AS net_loan_flow, NCFOA/liabilities AS Debt_Service_Coverage_Ratio,\n" +
"                             Selling_expenses/Operating_profit AS marketing_expense_ratio, CPFAIALA / (assets - liabilities)  AS cp_ratio,\n" +
"                          account_receivable, operating_profit,(current_assets-current_liabilities) as working_capital\n" +
"                      FROM finance\n" +
"                      WHERE (MONTH(Date) = '12' OR Month(Date) = '01')\n" +
"                  ) t\n" +
"             WHERE t.rate_liabi_ass <> 0\n" +
"               AND t.rate_sale_profit <>0\n" +
"               AND t.Debt_Service_Coverage_Ratio <>0\n" +
"               AND marketing_expense_ratio <> 0\n" +
"               AND cp_ratio > 0\n" +
"             GROUP BY t.IdC\n" +
"         ) t1 left join (\n" +
"        SELECT f2.IdC,  AVG(f2.net_profit/((f1.shareholders_equity + f2.shareholders_equity)/2) )AS return_net_assets,AVG(f2.Operating_profit / ((f2.assets + f1.assets)/2)) AS total_asset_turnover,\n" +
"               AVG(f2.Operating_profit/((f2.current_assets+f1.current_assets)/2)) AS current_asset_turnover, AVG((f2.Operating_profit - f1.Operating_profit) /f1.Operating_profit) AS sale_growth_rate,\n" +
"               AVG((f2.shareholders_equity - f1.shareholders_equity)/f1.shareholders_equity) AS capital_accumule_rate\n" +
"        FROM citi.finance f1, citi.finance f2\n" +
"        WHERE (MONTH(f1.Date) = '12' OR Month(f1.Date) = '01')\n" +
"          AND YEAR(f1.Date) = YEAR(f2.Date)-1\n" +
"          AND f1.IdC = f2.IdC\n" +
"          AND f1.Operating_profit <> 0\n" +
"          AND f1.shareholders_equity <> 0\n" +
"        GROUP BY f2.IdC\n" +
"        ORDER BY f2.IdC ASC\n" +
"    ) t2 on t1.IdC=t2.IdC\n" +
") t4 on t3.IdC = t4.Id";

        // Ouverture d'un espace de requête
        try (PreparedStatement st = CX.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            // Lire le résultat
//            while (rs.next()) {
//                liste.add(rs.getFloat("age"));
//                liste.add(rs.getFloat("return_net_assets"));
//                liste.add(rs.getFloat("total_asset_turnover"));
//                liste.add(rs.getFloat("current_asset_turnover"));
//                liste.add(rs.getFloat("sale_growth_rate"));
//                liste.add(rs.getFloat("capital_accumule_rate"));
//                liste.add(rs.getFloat("rate_liabi_ass"));
//                liste.add(rs.getFloat("rate_current"));
//                liste.add(rs.getFloat("ebitda"));
//                liste.add(rs.getFloat("rate_sale_profit"));
//                liste.add(rs.getFloat("NCFOA"));
//                liste.add(rs.getFloat("Debt_Service_Coverage_Ratio"));
//                liste.add(rs.getFloat("marketing_expense_ratio"));
//                liste.add(rs.getFloat("cp_ratio"));
//
//                datas.put(rs.getString("t3.IdC"), liste);
//            }
            while (rs.next()) {
                data.put("credit", rs.getFloat("avgCredit"));
                data.put("age", rs.getFloat("age"));
                data.put("sale_growth_rate", rs.getFloat("sale_growth_rate"));
                data.put("marketing_expense_ratio", rs.getFloat("marketing_expense_ratio"));
                data.put("cp_ratio", rs.getFloat("cp_ratio"));
            }

        } catch (SQLException sqle) {
            throw new Exception("MessageBD.findData() - " + sqle.getMessage());
        }
        return data;
    }

//Find all Data for Report by ccompany id
    public static HashMap<String, HashMap<String, Float>> findData() throws ClassNotFoundException, SQLException, Exception {
        HashMap<String, HashMap<String, Float>> datas = new HashMap<>();
        List<Float> liste = new ArrayList<>();
        HashMap<String, Float> data = new HashMap();
        // Connexion
        if (CX == null) {
            DB.connexion();
        }

        // Requête SQL
        String sql = "SELECT (rate_liabi_ass*0.1+rate_current* 0.2 + ebitda*0.1)*0.4 + (return_net_assets+ return_net_assets)*0.15*0.3 +\n" +
"       (total_asset_turnover*0.8+current_asset_turnover*0.12)*0.2+(sale_growth_rate*0.06 + capital_accumule_rate*0.04)*0.1 +\n" +
"       (return_net_assets*0.2+rate_sale_profit*0.1+total_asset_turnover*0.2+NCFOA*0.2+net_loan_flow*0.3)*0.5 + Debt_Service_Coverage_Ratio AS credit,\n" +
"       sale_growth_rate,cp_ratio, age, marketing_expense_ratio, account_receivable,operating_profit,working_capital\n" +
"FROM(\n" +
"        SELECT IdC, ROUND(DATEDIFF(CURRENT_DATE, CreateDate)/365) AS age FROM company WHERE CreateDate IS NOT NULL\n" +
"    ) t3 right join (\n" +
"    SELECT t1.IdC, rate_liabi_ass, rate_current, ebitda, rate_sale_profit, NCFOA,net_loan_flow, Debt_Service_Coverage_Ratio,marketing_expense_ratio,cp_ratio,\n" +
"           return_net_assets, total_asset_turnover, current_asset_turnover,sale_growth_rate, capital_accumule_rate, account_receivable,operating_profit,working_capital\n" +
"    FROM (\n" +
"             SELECT t.IdC, AVG(t.rate_liabi_ass) AS rate_liabi_ass, AVG(t.rate_current) AS rate_current, AVG(t.ebitda) AS ebitda,\n" +
"                    AVG(t.rate_sale_profit) AS rate_sale_profit, AVG(NCFOA) AS NCFOA,\n" +
"                    AVG(t.net_loan_flow) AS net_loan_flow, AVG(t.Debt_Service_Coverage_Ratio) AS Debt_Service_Coverage_Ratio,\n" +
"                    AVG(t.marketing_expense_ratio) AS marketing_expense_ratio, AVG(t.cp_ratio) AS cp_ratio, AVG(t.account_receivable) as account_receivable,\n" +
"                    AVG(t.operating_profit) AS operating_profit,AVG(t.working_capital) AS working_capital\n" +
"             FROM (\n" +
"                      SELECT IdC,(liabilities/assets) AS rate_liabi_ass , (current_assets/current_liabilities) AS rate_current,\n" +
"                             (net_profit + Income_tax_paid + DFAOGAPBA +Deferred_assets + profits_payable - SCOSE) AS ebitda,\n" +
"                             (Operating_profit - Operating_cost - business_tariff_and_annex) AS rate_sale_profit,\n" +
"                             NCFOA, Cash_from_borrow - CRAB AS net_loan_flow, NCFOA/liabilities AS Debt_Service_Coverage_Ratio,\n" +
"                             Selling_expenses/Operating_profit AS marketing_expense_ratio, CPFAIALA / (assets - liabilities)  AS cp_ratio,\n" +
"                          account_receivable, operating_profit,(current_assets-current_liabilities) as working_capital\n" +
"                      FROM finance\n" +
"                      WHERE (MONTH(Date) = '12' OR Month(Date) = '01')\n" +
"                  ) t\n" +
"             WHERE t.rate_liabi_ass <> 0\n" +
"               AND t.rate_sale_profit <>0\n" +
"               AND t.Debt_Service_Coverage_Ratio <>0\n" +
"               AND marketing_expense_ratio <> 0\n" +
"               AND cp_ratio > 0\n" +
"             GROUP BY t.IdC\n" +
"         ) t1 left join (\n" +
"        SELECT f2.IdC,  AVG(f2.net_profit/((f1.shareholders_equity + f2.shareholders_equity)/2) )AS return_net_assets,AVG(f2.Operating_profit / ((f2.assets + f1.assets)/2)) AS total_asset_turnover,\n" +
"               AVG(f2.Operating_profit/((f2.current_assets+f1.current_assets)/2)) AS current_asset_turnover, AVG((f2.Operating_profit - f1.Operating_profit) /f1.Operating_profit) AS sale_growth_rate,\n" +
"               AVG((f2.shareholders_equity - f1.shareholders_equity)/f1.shareholders_equity) AS capital_accumule_rate\n" +
"        FROM citi.finance f1, citi.finance f2\n" +
"        WHERE (MONTH(f1.Date) = '12' OR Month(f1.Date) = '01')\n" +
"          AND YEAR(f1.Date) = YEAR(f2.Date)-1\n" +
"          AND f1.IdC = f2.IdC\n" +
"          AND f1.Operating_profit <> 0\n" +
"          AND f1.shareholders_equity <> 0\n" +
"        GROUP BY f2.IdC\n" +
"        ORDER BY f2.IdC ASC\n" +
"    ) t2 on t1.IdC=t2.IdC\n" +
") t4 on t3.IdC = t4.IdC;";

        // Ouverture d'un espace de requête
        try (PreparedStatement st = CX.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            // Lire le résultat
            while (rs.next()) {
                data.put("credit", rs.getFloat("credit"));
                data.put("age", rs.getFloat("age"));
                data.put("sale_growth_rate", rs.getFloat("sale_growth_rate"));
                data.put("marketing_expense_ratio", rs.getFloat("marketing_expense_ratio"));
                data.put("cp_ratio", rs.getFloat("cp_ratio"));

                datas.put(rs.getString("t3.IdC"), data);
            }

        } catch (SQLException sqle) {
            throw new Exception("MessageBD.findData() - " + sqle.getMessage());
        }
        return datas;
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
//        List<Finance> F2 = new ArrayList<>();
//        try {
//            F2 = DB.readFinanceByID("US2605571031");
//        } catch (Exception ex) {
//            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        for (Finance f : F2) {
//            System.out.println(f);
//        }
//test data
        HashMap<String, Float> data = new HashMap<>();
        try {
            data = DB.findAvgData();
            for (float fl : data.values()) {
                System.out.println(fl);
            }
        } catch (Exception ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
/*----- Fin de la classe Bd -----*/
