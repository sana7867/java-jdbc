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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EXOJDBC2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db";
        String utilisateur = "root";
        String motDePasse = "";

        try {
            Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse);
            Statement statement = connection.createStatement();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez une requête SQL : ");
            String query = scanner.nextLine();

            boolean isResultSet = statement.execute(query);

            if (isResultSet) {
                ResultSet resultSet = statement.getResultSet();
                ResultSetMetaData metaData = resultSet.getMetaData();

                int columnCount = metaData.getColumnCount();
                System.out.println("Nombre de colonnes dans le résultat : " + columnCount);

                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnType = metaData.getColumnTypeName(i);
                    System.out.println("Nom de la colonne : " + columnName + ", Type de données : " + columnType);
                }

                System.out.println("Contenu de la table :");

                while (resultSet.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(resultSet.getString(i) + "\t");
                    }
                    System.out.println();
                }

                resultSet.close();
            } else {
                int rowCount = statement.getUpdateCount();
                System.out.println("Nombre de lignes modifiées : " + rowCount);
            }

            // Fermeture des ressources
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
