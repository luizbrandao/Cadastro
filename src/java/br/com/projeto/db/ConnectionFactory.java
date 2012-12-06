package br.com.projeto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException{
        try{
            System.out.println("Conectando ao banco!");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            return DriverManager.getConnection("jdbc:derby://localhost:1527/Banco");
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
