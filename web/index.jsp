<%-- 
    Document   : index
    Created on : 06/12/2012, 16:02:58
    Author     : Luiz
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciamento de Funcionarios</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="container marketing">
            <div class="">
                <div class="row">
                    <a href="cadastrar.jsp" class="btn btn-primary">Adicionar Funcionario</a>
                    <h2>Lista de Funcionários Cadastrados</h2>
                    <jsp:useBean id="dao" class="br.com.projeto.dao.FuncionarioDAO"/>
                    <table class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <td>ID</td>
                                <td>Nome</td>
                                <td>Ações</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="funcionario" items="${dao.funcionarios}">
                                <tr>
                                    <td>${funcionario.id}</td>
                                    <td>${funcionario.nome}</td>
                                    <td><a class="btn btn-primary" href="#">Editar</a> <a class="btn btn-danger" href="#">Apagar</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>