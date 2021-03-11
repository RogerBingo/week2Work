<head>
<jsp:directive.include file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
	<title>My Home Page</title>
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/register">
		i d:<label><input name="id" style="margin-left:10px;"/></label><br>
		用户:<label><input name="name" style="margin-left:10px;"/></label><br>
		密码:<label><input name="password" style="margin-left:10px;"/></label><br>
		电话:<label><input name="phoneNumber" style="margin-left:10px;"/></label><br>
		<input type="submit" value="登录" style="position: absolute; left: 50px; top:60px;">
	</form>
</body>