/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author Tecra
 */
public class DevConnexion {
    public static void save(DevData d){
        String user="root";
        String Password="";
        String url="jdbc:mysql://localhost:3306/mysql";
        Connection cnx=null;
        Statement st=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cnx=DriverManager.getConnection(url, user, Password);
            st=cnx.createStatement();
            String req= "insert into devdata1 values ('"+d.getDevloppeur() +" ','"+d.getJour()+ "', '"+d.getNbSctripts()+ "')";
            st.executeUpdate(req);
        }
        
         catch (ClassNotFoundException e) {
             System.out.println("impossible de charger le driver");
           
        } catch (SQLException ex) {
           // Logger.getLogger(DevConnexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur SQL"+ex.getMessage());
        }
        finally{
            try{
                cnx.close();
                st.close();
            }
            catch(SQLException ex){
                System.out.println("probléme de libération de ressouces");
            }
        }}

    /**
     *
     */
public static void load() {
//Information d'accès à la base de données
String user = "root";
String password = "";
String url = "jdbc:mysql://localhost/db";
Connection cn = null;
Statement st = null;
ResultSet rs = null;
try {
//Etape 1 : Chargement du driver
Class.forName("com.mysql.jdbc.Driver");
//Etape 2 : Récupération de la connexion
cn = (Connection) DriverManager.getConnection(url, user, password);
//Etape 3 : Création d'un statement
st = cn.createStatement();
String req = "select * from devdata";
//Etape 4 : Exécution de la requête
rs = st.executeQuery(req);
//Etape 5 : Parcours de ResultSet
while (rs.next()) {
System.out.println(rs.getString(1) + " " + rs.getString(2)+" "+rs.getInt(3));
}
} catch (SQLException e) {
System.out.println(e.getMessage());
} catch (ClassNotFoundException ex) {
System.out.println("Impossible de charger le driver");
} finally {
try {
//Etape 6 : Libérer les ressources de la mémoire
st.close();
cn.close();
} catch (SQLException ex) {
System.out.println("Impossible de libérer les ressources");
}
}
}  
   public static void main(String[] args) {
        
            // TODO code application logic here
            save(new DevData( "Alami" ,"lundi" ,1 ));
            load();
        
    }              
        
    }
    
    
   
    
