<%@ page contentType="text/html; charset=gb2312"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>Test</h2>
<form action="/upload" method="post" enctype="multipart/form-data">
    <label>选择一个文件：</label>
    <input type="file" name="file"><br>
    <input type="submit" value="上传"><br>
</form>
</body>
</html>