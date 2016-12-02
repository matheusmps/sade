<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
    <nav class="navbar">
        <div class="container">
            <div id="logo-sade">
                <img src="<c:url value='/static/images/sade-logo.png' />"  />
            </div>

            <div id="logo-conpec">
                <img src="<c:url value='/static/images/conpec-logo.png' />" />
            </div>
            
            <c:if test="${not empty loggedinuser}">
	            <span>Olá <strong>${loggedinuser.firstName}</strong></span> 
	            <span style="float: right;"><a href="<c:url value="/logout" />">Logout</a></span>
            </c:if>
        </div>
    </nav>
</header>