<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<%@include file="includesMember.jsp" %>

    <body>
		<%@include file="headerMember.jsp" %>
	
	    <div id="main-cont" class="container">
	        <div class="profile-box box-style">
	            <figure id="user-photo">
	                <img src="images/default-photo.png">
	            </figure>
	            <div class="info">
	                <div class="profile-info-header">
	                    <h2>${loggedinuser.name}</h2>
	                    <span>Membro da Conpec desde </span>
	                    <span>Departamento: </span>
	                    <span>Participando de 3 projetos</span>
	                    <span>Acessar <a href="">WebPonto</a></span>
	                </div>
	            </div>
	        </div>
	
	        <div class="content box-style">
	            <form:form method="POST" modelAttribute="loggedinuser" class="form-dev-edit">
					<form:input type="hidden" path="id" id="id"/>

	                <fieldset>
	                    <h2>Informações pessoais</h2>
	                    <div class="row">     
	                        <div class="col-xs-3">
	                            <label for="username">Username</label>
	                            <form:input path="username" type="text" class="form-control" autocomplete="off" id="username" aria-describedby="name" placeholder="Seu username" disabled="true"/>
	                        </div>
	
	                        <div class="col-xs-3">
	                            <label for="firstName">Nome</label>
	                            <form:input path="firstName" type="text" class="form-control" autocomplete="off" id="firstName" placeholder="Seu nome" />
	                        </div>
	
	                        <div class="col-xs-3">
	                            <label for="address">Sobrenome</label>
	                            <form:input path="lastName" type="text" class="form-control" autocomplete="off" id="lastName" placeholder="Seu sobrenome" />
	                        </div>

	                        <div class="col-xs-3">
	                            <label for="address">CPF</label>
	                            <form:input path="cpf" type="text" class="form-control" autocomplete="off" id="cpf" placeholder="Seu cpf" />
	                        </div>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-6">
	                            <label for="address">E-mail</label>
	                            <form:input path="email" type="text" class="form-control" autocomplete="off" id="email" placeholder="Seu e-mail completo" />
	                        </div>
							<div class="col-xs-6">
	                            <label for="address">Password</label>
	                            <form:input path="password" type="password" class="form-control" autocomplete="off" id="password" placeholder="Seu password" />
	                        </div>
	                    </div>
	                </fieldset>
	                <div class="row">
	                    <button class="btn btn-default btn-lg btn-main" type="submit">Atualizar</button>
	                </div>
	            </form:form>
	        </div>
			<%@include file="../footer.jsp" %>
	    </div>

	</body>
</html>