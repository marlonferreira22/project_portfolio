<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Projeto cadastrado com sucesso!</title>
<style type="text/css">
    span {
        display: inline-block;
        width: 200px;
        text-align: left;
    }
</style>
</head>
<body>
    <div align="center">
        <h2>Projeto cadastrado com sucesso!</h2>
        <span>Nome:</span><span>${project.name}</span><br/>
        <span>Valor:</span><span>${project.budget}</span><br/>
        <span>Data Inicial:</span><span>${project.startDate}</span><br/>
        <span>Previsão Término:</span><span>${project.endPrevisionDate}</span><br/>
        <span>Data Término:</span><span>${project.endDate}</span><br/>
        <span>Status:</span><span>${project.status}</span><br/>
        <span>Risco:</span><span>${project.risk}</span><br/>
        <span>Descrição:</span><span>${project.description}</span><br/>
        <span>ID:</span><span>${project.projectId}</span><br/>
    </div>
    
    <a href="/projectform">Cadastrar Projeto</a><br/>
    <a href="/projectlist">Listar Projetos</a>
</body>
</html>