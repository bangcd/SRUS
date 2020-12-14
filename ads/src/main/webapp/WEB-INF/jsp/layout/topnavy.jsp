<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <!-- Header -->
	<header class="header">
	    <nav class="navbar">
            <a class="logo-link" href="/rental">
                <img class="logotype" src="/images/ui/logo-black.svg" alt="Main">
		    </a>
		    <div class="navbar__menu">
		        <button class="hamburger" type="button">
				    <span></span>
					<span></span>
				</button>
			     <ul class="nav">
				    <li class="nav__item _is-current"><a class="nav__link" href="/member/certification"><span data-hover="CardUpdate">카드 갱신</span></a></li>
					<li class="nav__item"><a class="btn btn__medium" href="/login"><i class="btn-icon-left icon-bookmark"></i>로그인</a></li>
			    </ul>
	        </div>
	        <div>
	        <c:if test="${sessionScope.id ne null}">
	        	<a class="btn btn__medium" href="/logout"><i class="btn-icon-left icon-bookmark"></i>로그아웃</a>
	        </c:if>
	        <c:if test="${sessionScope.id eq null}"><a class="btn btn__medium" href="/login"><i class="btn-icon-left icon-bookmark"></i>로그인</a></c:if>
	        </div>
	    </nav>
	</header>
	<!-- /Header -->
</body>
</html>