<%--
  Created by IntelliJ IDEA.
  User: CKH
  Date: 2017/6/9
  Time: 19:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>add Product</title>
</head>
<body>
<%--在web目录下 增加商品的页面addProduct.jsp--%>
<%--注意：产品名称input的name要使用name，而不是 product.name--%>
<form action="${pageContext.request.contextPath}/addProduct" method="post">
    <label>
    产品名称 ：<input type="text" name="name" value="">
    </label><br/>
    <label>
    产品价格：<input type="text" name="price" value="">
    </label><br/>
    <input type="submit" value="增加商品">
</form>
</body>
</html>
