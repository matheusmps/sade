<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
	<%@include file="includes.jsp" %>
	<style>
		.row{margin-bottom: 15px;}
	</style>

    <body>
		<%@include file="header.jsp" %>
	
	    <div class="main">
			<div class="container">
				<div class="cont-main">
				<h1 class="general-title">CADASTRO DE DESENVOLVEDOR</h1>
                    <div class="bd-example" data-example-id="">
                   		<form:form method="POST" modelAttribute="developer" class="form-horizontal">
                            <div class="row">
                                <div class="col-xs-6">
                                    <label for="exampleInputEmail1">Nome completo</label>
                                    <form:input type="text" class="form-control" autocomplete="off" id="firstName" path="firstName" aria-describedby="firstName" placeholder="Seu nome" />
                                    <div class="has-error">
										<form:errors path="firstName" class="help-inline"/>
									</div>
                                </div>
                                <div class="col-xs-6">
                                    <label for="exampleInputEmail1">Sobrenome</label>
                                    <form:input type="text" class="form-control" autocomplete="off" id="lastName" path="lastName" aria-describedby="lastName" placeholder="Seu sobrenome" />
                                    <div class="has-error">
										<form:errors path="lastName" class="help-inline"/>
									</div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-6">
                                    <label for="exampleInputEmail1">Endereço</label>
                                    <input type="text" class="form-control" autocomplete="off" id="address" name="address" aria-describedby="address" placeholder="Seu endereço completo">
                                    <div class="has-error">
										<form:errors path="address" class="help-inline"/>
									</div>
                                </div>
                                <div class="col-xs-6">
                                    <label for="exampleInputEmail1">Celular</label>
                                    <input type="text" class="form-control" autocomplete="off" id="cellphoneNumber" name="cellphoneNumber" aria-describedby="cellphoneNumber" placeholder="Seu celular">
                                    <div class="has-error">
										<form:errors path="cellphoneNumber" class="help-inline"/>
									</div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-xs-6">
                                    <label for="exampleInputEmail1">CPF</label>
                                    <input type="text" class="form-control" autocomplete="off" id="cpf" name="cpf" aria-describedby="cpf" placeholder="Seu CPF">
                                    <div class="has-error">
										<form:errors path="cpf" class="help-inline"/>
									</div>
                                </div>
                                <div class="col-xs-6">
                                    <label for="exampleInputEmail1">E-mail</label>
                                    <input type="email" class="form-control" autocomplete="off" id="email" name="email" aria-describedby="email" placeholder="Seu e-mail">
                                    <div class="has-error">
										<form:errors path="email" class="help-inline"/>
									</div>
                                </div>
                                
                            </div>
                          
                            <div class="row">
                            	<div class="col-xs-6">
                                    <label for="exampleInputEmail1">Username</label>
                                    <form:input type="text" class="form-control" autocomplete="off" id="username" path="username" aria-describedby="username" placeholder="Seu username" />
                                    <div class="has-error">
										<form:errors path="username" class="help-inline"/>
									</div>
                                </div>
                                <div class="col-xs-6">
                                    <label for="exampleInputEmail1">Senha</label>
                                    <input type="password" class="form-control" id="password" name="password" aria-describedby="pass" placeholder="Senha para acesso ao SADE">
                                </div>
                            </div>
                            <div class="row">
                                <div class="btn-wrapper"><button class="btn btn-main btn-lg centered" href="" role="button" type="submit" value="Register">Cadastrar</button></div>
                            </div>
                   		</form:form>
                    </div>
				</div>
			</div>
			<%@include file="footer.jsp" %>
		</div>
		
	</body>
</html>