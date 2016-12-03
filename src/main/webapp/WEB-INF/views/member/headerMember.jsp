<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
    <nav id="top-bar" class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-header">
            <img src="">
            <a class="user-name navbar-brand" href="#">${loggedinuser.name}</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="top-menu navbar-form navbar-right">
                <li>
                    <a href="<c:url value="/logout" />">Sair</a>
                </li>
            </ul>
        </div>
    </nav>

    <nav id="sub-bar" class="navbar navbar-fixed-top">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#toggle-menu" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <h1 class="page-title">&raquo; Meu perfil</h1>
        <ul id="main-menu">
            <div class="container">
                <li>
                    <a href="<c:url value="/member/" />">Meu perfil</a>
                </li>
                <li>
                    <a href="<c:url value="/member/list-dev" />">Listar Devs</a>
                </li>
                <li>
                    <a href="">Cadastrar Membro</a>
                </li>
            </div>
        </ul>
    </nav>

    <div id="toggle-menu">
        
    </div>
</header>