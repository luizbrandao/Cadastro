package br.com.projeto.teste;

import br.com.projeto.dao.FuncionarioDAO;
import br.com.projeto.model.Funcionario;
import java.util.Iterator;
import java.util.List;

public class TestaFuncionario {

    public static void main(String[] args) {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setNome("Working");
            funcionario.setCpf("12345678910");
            funcionario.setCargo("dba");
            funcionario.setSenha("123456");
            
            FuncionarioDAO func = new FuncionarioDAO();
            func.inserirFuncionario(funcionario);
            System.out.println("funcionario salvo com sucesso");
            FuncionarioDAO func3 = new FuncionarioDAO();
            List<Funcionario> funcionarios = func3.getFuncionarios();
            Iterator<Funcionario> i = funcionarios.listIterator();
            while(i.hasNext()){
                Funcionario func2 = i.next();
                System.out.println(func2.getNome());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}