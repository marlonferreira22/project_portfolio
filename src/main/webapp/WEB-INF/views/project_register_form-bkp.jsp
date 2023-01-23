<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de Registro de Projeto</title>

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
        <h2>Formulário de Registro de Projeto</h2>
        <form:form action="projectregister" method="post" modelAttribute="project">
            <form:label path="name">Nome:</form:label>
            <form:input path="name"/><br/>
            
            <form:label path="budget">Valor:</form:label>
            <form:input path="budget"/><br/>
            
            <form:label path="startDate">Data Início:</form:label>
            <form:input path="startDate"/><br/>
            
            <form:label path="endPrevisionDate">Previsão Término:</form:label>
            <form:input path="endPrevisionDate"/><br/>
             
            <form:label path="endDate">Data Término:</form:label>
            <form:input path="endDate"/><br/> 
             
            <form:label path="status">Status:</form:label>
            <form:select path="status" items="${statusList}" /><br/>
            
            <form:label path="risk">Risco:</form:label>
            <form:select path="risk" items="${riskList}" /><br/>
            
            <form:label path="people">Gerente:</form:label>
            <form:select path="people" items="${managerList}" multiple="true" itemValue="peopleId" itemLabel="name" /><br/>
             
            <form:label path="description">Descrição:</form:label>
            <form:textarea path="description" cols="25" rows="5"/><br/>
                 
            <form:button>Cadastrar</form:button>
        </form:form>
    </div>
</body>
</html>