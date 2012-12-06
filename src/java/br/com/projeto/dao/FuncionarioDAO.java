package br.com.projeto.dao;

import br.com.projeto.db.ConnectionFactory;
import br.com.projeto.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    Connection connection = null;

    public FuncionarioDAO() throws ClassNotFoundException {
        connection = new ConnectionFactory().getConnection();
    }

    public void inserirFuncionario(Funcionario funcionario) {
        try {
            String sql = "insert into funcionario (nome, cpf, cargo, senha) values (?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getCargo());
            stmt.setString(4, funcionario.getSenha());

            stmt.execute();
            stmt.close();
            System.out.println("Gravado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List getFuncionarios() {
        try {
            List<Funcionario> funcionarios = new ArrayList();
            String sql = "select * from funcionario";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setSenha(rs.getString("senha"));
                funcionarios.add(funcionario);
            }
            rs.close();
            stmt.close();
            return funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public List getFuncionario(Funcionario funcionario){
        try{
            List<Funcionario> funcionarios = new ArrayList();
            String sql = "select * from funcionarios where like ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,funcionario.getNome());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Funcionario func = new Funcionario();
                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setCargo(rs.getString("cargo"));
                func.setCpf(rs.getString("cpf"));
                func.setSenha(rs.getString("senha"));
                funcionarios.add(func);
            }
            rs.close();
            stmt.close();
            return funcionarios;
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}