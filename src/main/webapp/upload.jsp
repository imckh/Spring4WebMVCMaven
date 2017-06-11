<%--
  Created by IntelliJ IDEA.
  User: CKH
  Date: 2017/6/10
  Time: 9:28
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<%--上传页面，需要注意的是form 的两个属性必须提供--%>
<%--method="post" 和 enctype="multipart/form-data" 缺一不可--%>
<%--上传组件 增加一个属性 accept="image/*" 表示只能选择图片进行上传--%>
<%--留意 <input type="file" name="image" accept="image/*" /> 这个image，后面会用到这个image--%>
    <form action="${pageContext.request.contextPath}/uploadImage" method="post" enctype="multipart/form-data">
        选择图片: <input type="file" name="image" accept="image/*"> <br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
