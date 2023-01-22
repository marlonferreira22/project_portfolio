<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Lista de Projetos Cadastrados</title>
</head>
<body>
	<div align="center">
	    <h2>Lista de Projetos Cadastrados</h2>
	
	    <c:if test="${not empty projects}">
	        <table border="1" cellpadding="5">
	            <tr>
	                <td>Nome</td>
	                <td>Data Início</td>
	                <td>Previsão Término</td>
	                <td>Data Término</td>
	                <td>Status</td>
	                <td>Valor</td>
	                <td>Risco</td>
	                <td colspan="2" align="center">Ação</td>
	
	            </tr>
	
	
	            <c:forEach var="listValue" items="${projects}">
	
	                <tr>
	                    <td>${listValue.name}</td>
	                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${listValue.startDate}" /></td>
	                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${listValue.endPrevisionDate}" /></td>
	                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${listValue.endDate}" /></td>
	                    <td>${listValue.status}</td>
	                    <td>${listValue.budget}</td>
	                    <td>${listValue.risk}</td>
	                    <td><a href="/projectedit?id=<c:out value='${listValue.projectId}' />">Editar</a></td>
						<td><a href="/projectdelete?id=<c:out value='${listValue.projectId}' />">Excluir</a></td>
	                </tr>
	            </c:forEach>
	
	        </table>
	
	    </c:if>
    </div>
    <a href="/projectform">Cadastro</a>

</body>
</html>