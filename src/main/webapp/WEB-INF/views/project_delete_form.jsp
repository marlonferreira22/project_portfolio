<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirma a exclusão do projeto?</title>
<style type="text/css">
    label {
        display: inline-block;
        width: 200px;
        margin: 5px;
        text-align: left;
    }
    input[type=text], input[type=password], select {
        width: 200px;  
    }
    input[type=radio] {
        display: inline-block;
        margin-left: 45px;
    }
    input[type=checkbox] {
        display: inline-block;
        margin-right: 190px;
    }  
     
    button {
        padding: 10px;
        margin: 10px;
    }
</style>
</head>
<body>
    <div align="center">
        <h2>Confirma a exclusão do projeto?</h2>
        <form:form action="projectexclude" method="post" modelAttribute="project">
        	
            <form:input type="hidden" path="projectId"/>
            
            <form:label path="name">Nome:</form:label>
            <form:input path="name" readonly="true"/><br/>
            
            <form:label path="budget">Valor:</form:label>
            <form:input path="budget" readonly="true"/><br/>
            
            <form:label path="startDate">Data Início:</form:label>
            <form:input path="startDate" readonly="true"/><br/>
            
            <form:label path="endPrevisionDate">Previsão Término:</form:label>
            <form:input path="endPrevisionDate" readonly="true"/><br/>
             
            <form:label path="endDate">Data Término:</form:label>
            <form:input path="endDate" readonly="true"/><br/> 
            
            <form:label path="status">Status:</form:label>
            <form:input path="status" readonly="true"/><br/>

			<form:label path="risk">Risco:</form:label>
            <form:input path="risk" readonly="true"/><br/>
            
            <form:label path="people">Gerente:</form:label>
            <form:select path="people" items="${managerList}" multiple="true" itemValue="peopleId" itemLabel="name" readonly="true"/><br/> 
             
            <form:label path="description">Descrição:</form:label>
            <form:textarea path="description" cols="25" rows="5" readonly="true"/><br/>
                 
            <form:button>Confirmar</form:button>
        </form:form>
    </div>
    <a href="/projectlist">Listar Projetos</a>
</body>
</html>