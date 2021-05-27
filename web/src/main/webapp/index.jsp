<%@ page contentType="text/html; charset=gb2312"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div style="margin: 150px 300px 50px 500px; color: #3aa3a7;">
    <div>
        <h2>WebShell Test</h2>
        <form action="/upload" method="post" enctype="multipart/form-data">
            <input type="file" name="file"><br>
            <input type="submit" value="上传文件" style="margin-top: 10px;"><br>
        </form>
    </div>
</div>
</body>
</html>