<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>SRUS – Another space</title>

<!-- Meta Data -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="format-detection" content="telephone=no" />
<meta name="format-detection" content="address=no" />
<meta name="author" content="ArtTemplates" />
<meta name="description" content="AnotherSpace — ADS" />

<!-- Twitter data -->
<meta name="twitter:card" content="summary_large_image">
<meta name="twitter:site" content="@ArtTemplates">
<meta name="twitter:title" content="AnotherSpace">
<meta name="twitter:description" content="AnotherSpace — ADS">
<meta name="twitter:image" content="/images/social.jpg">

<!-- Open Graph data -->
<meta property="og:title" content="ArtTemplate" />
<meta property="og:type" content="website" />
<meta property="og:url" content="your url website" />
<meta property="og:image" content="/images/social.jpg" />
<meta property="og:description" content="AnotherSpace — ADS" />
<meta property="og:site_name" content="AnotherSpace" />

<!-- Favicons -->
<link rel="apple-touch-icon" sizes="144x144"
	href="/images/favicons/apple-touch-icon-144x144.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="/images/favicons/apple-touch-icon-114x114.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="/images/favicons/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="57x57"
	href="/images/favicons/apple-touch-icon-57x57.png">
<link rel="shortcut icon" href="/images/favicons/favicon.png"
	type="image/png">

<!-- Styles -->
<link rel="stylesheet" type="text/css" href="/styles/style.css" />
<style>
#loading {
	width: 100%;
	height: 100%;
	top: 0;
	left: 0;
	position: fixed;
	display: block;
	opacity: 1;
	background: #ffffff;
	z-index: 99;
	text-align: center;
}

#loading>img {
	position: absolute;
	top: 50%;
	left: 50%;
	z-index: 100;
}

#loading>p {
	position: absolute;
	top: 57%;
	left: 43%;
	z-index: 101;
}
</style>
</head>
<body>
	<!-- Preloader -->
	<div class="preloader">
		<div class="preloader__wrap">
			<div class="preloader__progress">
				<span></span>
			</div>
		</div>
	</div>

	<div class="scroll-line"></div>

	<%@ include file="/WEB-INF/jsp/layout/topnavy.jsp"%>

	<!-- content -->
	<main class="main">
		<section class="container section section-first">
			<div class="row justify-content-center">
				<!-- Header post -->
				<header class="col-12 col-lg-12 col-xl-10 post-header">
					<div class="title title--overhead js-lines"></div>
					<h1 class="title title--h2 js-lines">카드 등록</h1>
				</header>


				<form action="/member/card" id="trans" class="row mt-2 mt-sm-4"
					method="post" id="fr" onsubmit="return check()">
					<input type="hidden" name="id" value="${sessionScope.id}">

					<div class="col-12">
						<div class="form-group">
							<label class="label" for="id">카드명(필수)</label> <input type="text"
								class="inputText" id="cardName" name="cardName"
								placeholder="카드명을 입력해주세요." required="required"
								autocomplete="off" pattern="[가-힣a-zA-Z0-9]{1,10}" maxlength="10">
						</div>
					</div>
					<div class="col-12 col-sm-20 mt-2 mt-sm-3 order-1 order-sm-1">
						<button type="submit" class="btn btn__medium w-100">카드 인증</button>
					</div>
				</form>
			</div>
		</section>
	</main>
	<!--로딩바 -->
	<div id="loading" style="margin-left: px;">
		<main class="main">
			<section class="container section section-first">
				<div class="row justify-content-center">
					<form action="/rental" class="row mt-2 mt-sm-4" method="get">
						<div class="col-12">
							<div class="form-group">
								<img src="/images/NFC.jpg" />
							</div>
							<div class="col-12 col-sm-20 mt-2 mt-sm-3 order-1 order-sm-1">
								<button type="submit" class="btn btn__medium w-100">뒤로</button>
							</div>
						</div>
					</form>
				</div>
			</section>
		</main>
	</div>
	<!-- /Content -->
	<!-- Footer -->
	<%@ include file="/WEB-INF/jsp/layout/bottom.jsp"%>

	<!-- JavaScripts -->
	<script src="/js/jquery-3.4.1.min.js"></script>
	<script src="/js/plugins.js"></script>
	<script src="/js/common.js"></script>
	<script>
		$(document).ready(function() {
			$('#loading').hide();
			$('#trans').submit(function() {

				$('#loading').show();
				return true;
			});
		});
	</script>
</body>
</html>