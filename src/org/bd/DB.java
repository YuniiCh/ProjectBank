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
public class DB
{
	/*---------*/
	/* Données */
	/*---------*/

	/*----- Connexion -----*/
	private static Connection CX = null;

	/*----- Données de connexion -----*/
	private static final String URL ="jdbc:mysql://localhost:3306/citi";
	private static final String LOGIN = "root";
	private static final String PASSWORD = "0828cyn";


	/*----------*/
	/* Méthodes */
	/*----------*/

	/**
	 * Crée la connexion avec la base de données.
	 */
	private static void connexion() throws ClassNotFoundException, SQLException
        {
            /*----- Chargement du pilote pour la BD -----*/
            try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    }
            catch (ClassNotFoundException ex)
                    {
                    throw new ClassNotFoundException("Exception connexion() - Pilote MySql introuvable - " + ex.getMessage());
                    }

            /*----- Ouverture de la connexion -----*/
            try {
                    DB.CX = DriverManager.getConnection(URL,LOGIN,PASSWORD);
                    }
            catch (SQLException ex)
                    {
                    throw new SQLException("Exception connexion() - Problème de connexion à la base de données - " + ex.getMessage());
                    }
        }


	
	public static List<Company> readCompanies () throws Exception
        {
            List<Company> liste = new ArrayList<>();

            // Connexion
            if(CX == null)
                DB.connexion();

            // Requête SQL
            String sql = "SELECT * FROM Company";

            // Ouverture d'un espace de requête
            try(PreparedStatement st = CX.prepareStatement(sql)){
                ResultSet rs = st.executeQuery();

                // Lire le résultat
                while(rs.next()){
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

            }catch(SQLException sqle){
                throw new Exception("MessageBD.readCompanies() - "+ sqle.getMessage());
            }
            return liste;
        }
        
        public static Company findCompany (String IdC) throws Exception
        {
            Company c = new Company();

            // Connexion
            if(CX == null)
                DB.connexion();

            // Requête SQL
            String sql = "SELECT * FROM Company WHERE IdC = '"+IdC+"'";
            // Ouverture d'un espace de requête
            try(PreparedStatement st = CX.prepareStatement(sql)){
                ResultSet rs = st.executeQuery();

                // Lire le résultat
                while(rs.next()){
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

            }catch(SQLException sqle){
                throw new Exception("MessageBD.findCompany() - "+ sqle.getMessage());
            }
            return c;
        }
        
        public static List<Finance> readFinances () throws Exception
        {
            List<Finance> liste = new ArrayList<>();

            // Connexion
            if(CX == null)
                DB.connexion();

            // Requête SQL
            String sql = "SELECT * FROM Finance";

            // Ouverture d'un espace de requête
            try(PreparedStatement st = CX.prepareStatement(sql)){
                ResultSet rs = st.executeQuery();

                // Lire le résultat
                while(rs.next()){
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
                                            rs.getFloat("SCOSE"));
                    liste.add(f);
                }

            }catch(SQLException sqle){
                throw new Exception("MessageBD.readFinances() - "+ sqle.getMessage());
            }
            return liste;
        }
        
        

	/*----------------------------*/
	/* Programme principal (test) */
	/*----------------------------*/

	public static void main (String[] s)
	{
            
            /*List<Company> listC = new ArrayList<>();
            try {
                listC = DB.readCompanies();
            } catch (Exception ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (Company c : listC) System.out.println(c);*/
            
            List<Finance> listF = new ArrayList<>();
            try {
                listF = DB.readFinances();
            } catch (Exception ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (Finance f : listF) System.out.println(f);
      
            try {  
                System.out.println(DB.findCompany("US0378331005"));
            } catch (Exception ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

} /*----- Fin de la classe Bd -----*/