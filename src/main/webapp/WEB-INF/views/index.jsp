<!DOCTYPE html>
<html lang="en">
	<%@include file="includes.jsp" %>

    <body>
		<%@include file="header.jsp" %>

        <div class="main">
            <div class="container">
                <div class="cont-main">
                    <h1 class="main-title">DESENVOLVA CONOSCO</h1>
                    <p class="main-description">O SADE É O SISTEMA DE ACOMPANHAMENTO DE DESENVOLVEDORES EXTERNOS, E ATRAVÉS DELE SELECIONAMOS DEVS PARA NOSSOS PROJETOS</p>
                    <div class="btn-wrapper"><a id="cadastro_cv" class="btn btn-main btn-lg centered" href="<c:url value='/register' />" role="button">Cadastre seu currículo</a></div>
                </div>
            </div>

            <div class="select-area">
                <div class="container">
					<div class="btn-wrapper">
						<a id="login" class="btn btn-select-area btn-lg" href="<c:url value='/login' /> " role="button">Login</a>
					</div>
                </div>
            </div>
            
	        <%@include file="footer.jsp" %>
        </div>

    </body>
</html>
