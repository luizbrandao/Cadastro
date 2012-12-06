/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.servlet;

import br.com.projeto.dao.FuncionarioDAO;
import br.com.projeto.model.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz
 */
public class Funcionarios extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            Funcionario func = new Funcionario();
            func.setNome(req.getParameter("nome"));
            func.setCargo(req.getParameter("cargo"));
            func.setCpf(req.getParameter("cpf"));
            func.setSenha(req.getParameter("senha"));
            if (req.getParameter("confsenha").equals(func.getSenha())) {
                FuncionarioDAO dao = new FuncionarioDAO();
                dao.inserirFuncionario(func);
                PrintWriter out = res.getWriter();
                out.println("Funcionario " + func.getNome() + " Cadastrado com Sucesso");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            Funcionario func = new Funcionario();
            func.setNome(req.getParameter("nome"));
            func.setCargo(req.getParameter("cargo"));
            func.setCpf(req.getParameter("cpf"));
            func.setSenha(req.getParameter("senha"));

            FuncionarioDAO dao = new FuncionarioDAO();
            dao.inserirFuncionario(func);
            PrintWriter out = res.getWriter();
            out.println("Funcionario " + func.getNome() + " Cadastrado com Sucesso");
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}