/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Info-Sys
 */
public class DbConnexion {
     final String url = "jdbc:mysql://127.0.0.1:3306/pidev";
    final String login = "root";
    final String password = "";
    Connection connexion;
    static DbConnexion instance;

    private DbConnexion() {
        try {
            connexion
                    = DriverManager.getConnection(url, login, password);
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion à la base de données");
        }
    }
    
    public static  DbConnexion getInstance(){
        if(instance == null)
            instance = new DbConnexion();
        return instance;
    }
    
    public Connection getConnection(){
        return connexion;
    }
}
