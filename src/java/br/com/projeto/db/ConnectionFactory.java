package br.com.projeto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException{
        try{
            System.out.println("Conectando ao banco!");
            return DriverManager.getConnection("jdbc:derby:Banco");
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
