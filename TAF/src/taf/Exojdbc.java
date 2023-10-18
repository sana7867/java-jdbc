/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taf;

/**
 *
 * @author Tecra
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exojdbc {
   
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mysql";
        String utilisateur = "root";
        String motDePasse = "";

        try {
            Connection conn = DriverManager.getConnection(url, utilisateur, motDePasse);
            Statement st = conn.createStatement();

            // (a) La personne ayant réalisé le nombre maximum de script en une journée
            String queryA = "SELECT Developpeurs, jour, max(NBScripts) as max_scripts FROM devdata GROUP BY jour";
            ResultSet resultA = st.executeQuery(queryA);

            while (resultA.next()) {
                String developpeur = resultA.getString("Developpeurs");
                String jour = resultA.getString("jour");
                int maxScripts = resultA.getInt("max_scripts");
                System.out.println("Personne: " + developpeur + ", Jour: " + jour + ", Max Scripts: " + maxScripts);
            }

            // (b) La liste des personnes triée dans l'ordre décroissant selon leur nombre de scripts
            String queryB = "SELECT Developpeurs, sum(NBScripts) as total_scripts FROM devdata GROUP BY Developpeurs ORDER BY total_scripts DESC";
            ResultSet resultB = st.executeQuery(queryB);

            while (resultB.next()) {
                String developpeur = resultB.getString("Developpeurs");
                int totalScripts = resultB.getInt("total_scripts");
                System.out.println("Personne: " + developpeur + ", Total Scripts: " + totalScripts);
            }

            // (2) Calculer et afficher le nombre total de scripts réalisés en une semaine
            String queryTotalScripts = "SELECT sum(NBScripts) as total_scripts FROM devdata WHERE jour BETWEEN 'date_debut_semaine' AND 'date_fin_semaine'";
            ResultSet resultTotalScripts = st.executeQuery(queryTotalScripts);

            while (resultTotalScripts.next()) {
                int totalScripts = resultTotalScripts.getInt("total_scripts");
                System.out.println("Nombre total de scripts réalisés en une semaine: " + totalScripts);
            }

            // (3) Calculer pour un programmeur donné le nombre total de scripts réalisés
            String nomProgrammeur = "nom_du_programmeur";
            String queryTotalScriptsProgrammeur = "SELECT sum(NBScripts) as total_scripts FROM devdata WHERE Developpeurs = '" + nomProgrammeur + "'";
            ResultSet resultTotalScriptsProgrammeur = st.executeQuery(queryTotalScriptsProgrammeur);

            while (resultTotalScriptsProgrammeur.next()) {
                int totalScripts = resultTotalScriptsProgrammeur.getInt("total_scripts");
                System.out.println("Nombre total de scripts réalisés par " + nomProgrammeur + ": " + totalScripts);
            }

            // Fermeture des ressources
            resultA.close();
            resultB.close();
            resultTotalScripts.close();
            resultTotalScriptsProgrammeur.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    
