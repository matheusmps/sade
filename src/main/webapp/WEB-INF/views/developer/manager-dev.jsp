<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<%@include file="includesDev.jsp" %>

    <body>

		<%@include file="headerDev.jsp" %>
       
        <div class="main">

        <!--- DEFAULT LOGGED PAGES TILL HERE -->
            <div id="main-cont" class="container">
                <div class="profile-box box-style">
                    <figure id="user-photo">
                        <ing src="">
                    </figure>
                    <div class="info">
                        <div class="profile-info-header">
                        	<c:if test="${not empty loggedinuser}">
                    			<h2>${loggedinuser.firstName} ${loggedinuser.lastName}</h2>
                    		</c:if>
                            <span>Membro do SADE desde 11/09/2015</span>
                        </div>
                        <div class="achievement">
                            <div class="ball"><span>5</span></div>
                            <p>Projeto(s) realizado(s)</p>
                        </div>
                        <div class="achievement">
                            <div class="ball"><span>1</span></div>
                            <p>Projeto(s) em andamento</p>
                        </div>
                    </div>
                </div>

                <div class="content box-style">
                	<form:form method="POST" modelAttribute="dev" class="form-dev-edit">
                        <fieldset>
                            <h2>Informações pessoais</h2>
                            <div class="row">     
                                <div class="col-xs-3">
                                    <label for="phone">Telefone res.</label>
                                    <form:input type="text" class="form-control" path="phoneNumber" autocomplete="off" id="phone" name="phone" value="${dev.phoneNumber}" aria-describedby="name" placeholder="Seu nome completo" />
                                </div>

                                <div class="col-xs-3">
                                    <label for="cellphone">Celular</label>
                                    <form:input type="text" class="form-control" path="cellphoneNumber" autocomplete="off" id="cellphone" name="cellphone" value="${dev.cellphoneNumber}" aria-describedby="name" placeholder="Seu nome completo" />
                                </div>

                                <div class="col-xs-6">
                                    <label for="address">Endereço</label>
                                    <form:input type="text" class="form-control" path="address" autocomplete="off" id="address" name="address" value="${dev.address}" aria-describedby="name" placeholder="Seu nome completo" />
                                </div>
                            </div>
                        </fieldset>

                        <fieldset>
                            <h2>Ensino</h2>
                            <div class="row">     
                                <div class="col-xs-6">
                                    <label for="phone">Insituição de ensino</label>
                                    <form:input type="text" class="form-control" path="educationInstitution" autocomplete="off" id="phone" name="phone" value="${dev.educationInstitution}" aria-describedby="name" placeholder="Onde você estuda?" />
                                </div>

                                <div class="col-xs-4">
                                    <label for="address">Curso</label>
                                    <form:input type="text" class="form-control" path="course" autocomplete="off" id="address" name="address" value="${dev.course}" aria-describedby="name" placeholder="Seu curso" />
                                </div>
                                <div class="col-xs-2">
                                    <label for="address">Ano</label>
                                    <form:input type="number" class="form-control" path="courseStartYear" autocomplete="off" id="address" name="address" value="${dev.courseStartYear}" aria-describedby="name" placeholder="Ano do curso" />
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-xs-4">
                                    <label for="available_hours">Disponibilidade (h/semana)</label>
                                    <form:input type="number" class="form-control" path="availableHours" autocomplete="off" id="available-hours" name="available_hours" value="${dev.availableHours}" aria-describedby="name" placeholder="Disponibilidade de trabalho" />
                                </div>
                                <div class="col-xs-4">
                                    <label for="college_hours">Horas graduação (h/semana)</label>
                                    <form:input type="number" class="form-control" path="courseHours" autocomplete="off" id="college_hours" name="college_hours" value="${dev.courseHours}" aria-describedby="name" placeholder="Horas da graduação" />
                                </div>
                                <div class="col-xs-4">
                                    <label for="internship_hours">Horas estágio (h/semana)</label>
                                    <form:input type="number" class="form-control" path="internshipHours" autocomplete="off" id="internship-hours" name="internship_hours" value="${dev.internshipHours}" aria-describedby="name" placeholder="Horas de estágio" />
                                </div>                                
                            </div>
                        </fieldset>
                        <div class="row">
                            <button class="btn btn-default btn-lg btn-main" type="submit">Atualizar</button>
                        </div>
                    </form:form>
                </div>
            </div>
        <!--- DEFAULT UNLOGGED PAGES TILL HERE -->
            <footer>
                <div class="container">
                    <p>CONPEC - SADE - Sistema de Acompanhamento de Desenvolvedores Externos</p>
                </div>
            </footer>
        </div>

        

    </body>
</html>