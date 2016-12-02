<!DOCTYPE html>
<html lang="en">
	<%@include file="includes.jsp" %>

    <body>
		<%@include file="header.jsp" %>
	
	    <div class="main">
			<div class="container">
				<div class="cont-main">
					<div class="bd-example" data-example-id="">
						<c:url var="loginUrl" value="/login" />
						<form action="${loginUrl}" method="post" class="form-horizontal" class="dev-register">
						
							<!-- TEST AND FIX!!!! -->
							<c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<p>Username ou password inválido.</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success">
									<p>Você deslogou com sucesso.</p>
								</div>
							</c:if>
							<c:if test="${param.registerSuccess != null}">
								<div class="alert alert-success">
									<p>Você foi registrado com sucesso.</p>
								</div>
							</c:if>
						
						
						    <div class="row">
						        <div class="col-xs-6">
						            <label for="exampleInputEmail1">Username</label>
						            <input type="text" class="form-control" autocomplete="off" id="username" name="username" aria-describedby="pass" placeholder="Seu username cadastrado">
						        </div>
						        
						        <div class="col-xs-6">
						            <label for="exampleInputEmail1">Senha</label>
						            <input type="password" class="form-control" id="pass" name="password" aria-describedby="pass" placeholder="Sua senha cadastrada">
						        </div>
						    </div>
						    
						    <div class="row">
                                <label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>  
						    </div>
							<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
								
							<div class="form-actions">
								<div class="btn-wrapper"><button class="btn btn-main btn-lg centered" role="button" type="submit">Login</button></div>
							</div>
						
						</form>
					</div>
				</div>
			</div>
		</div>

		<%@include file="footer.jsp" %>
		
	</body>
</html>