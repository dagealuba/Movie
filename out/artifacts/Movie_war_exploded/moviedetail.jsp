<%--
  Created by IntelliJ IDEA.
  User: AS
  Date: 2019/7/4
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>moviedetail</title>
</head>
<body>
movie detail：
<script>
${requestScope.message}

<c:forEach items="${requestScope.Movies }" var="u">
    ${u.movieId }-${u.name }-${u.time }
</c:forEach>
</script>
</body>
</html>
