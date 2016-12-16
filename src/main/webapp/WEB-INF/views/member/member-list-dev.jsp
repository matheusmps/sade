<!DOCTYPE html>
<html lang="en">
	<%@include file="includesMember.jsp" %>

    <body>
		<%@include file="headerMember.jsp" %>
	
	    <div class="main">
			<div id="main-cont" class="container">
                <div class="box-title box-style">
                    <h1>Desenvolvedores cadastrados</h1>
<%-- 					<%@include file="member-list-dev-filter.jsp" %> --%>
                </div>

                <div class="content box-style">
                    <h2>Desenvolvedores</h2>
                    <div class="list-dev">
                    
                    	<c:forEach items="${devs}" var="dev">
                    		<a href="<c:url value="dev/${dev.id}" />">
		                        <div class="list-dev-item">
		                            <div class="list-dev-photo">
		                                <img src="<c:url value="/static/images/default-photo.png" />">
		                            </div>
		
		                            <div class="list-dev-item-info">
		                                <div class="list-dev-item-left">
		                                    <h5 class="list-dev-name">${dev.name}</h5>
		                                    <span>Projetos: 14 Hora</span><span>Horas/semana: ${dev.availableHours}</span>
		                                </div>
		
		                                <div class="list-dev-item-right">
		                                    <h5 class="list-dev-subtitle">Principais skills</h5>
		                                    <span>Java, PHP, Javascript, AngularJS</span>
		                                </div>
		                            </div>
		                        </div>
                    		</a>
                    	</c:forEach>
                        
                    </div>
                </div>
			<%@include file="../footer.jsp" %>
		</div>
		
	</body>
</html>