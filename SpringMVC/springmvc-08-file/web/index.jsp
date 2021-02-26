<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="uploadFile">
    <input type="text" name="username">
    <input type="submit" value="上传">
  </form>

  </body>
</html>
