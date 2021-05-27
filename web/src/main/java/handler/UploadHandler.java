package handler;

import utils.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/***
 * @FileName    : UploadHandler.java
 * @Author      : citang
 * @Date        : 2021/5/27 9:40 上午
 * @Description : description the function of the file
 */

@MultipartConfig
public class UploadHandler extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("测试页面");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part part = req.getPart("file");
        String header = part.getHeader("content-disposition");
        String path = header.substring(header.indexOf("filename=") + 10, header.length() - 1);

        String name = UploadUtils.getRealName(path);

        String realPath = this.getServletContext().getRealPath("/upload");
        File file = new File(realPath);

        if (!file.exists()) {
            file.mkdirs();
        }

        // 获取输入流
        InputStream inputStream = part.getInputStream();
        // 定义输出流
        FileOutputStream outputStream = new FileOutputStream(new File(file, name));

        // 从输入流中读入数据并写到输出字节流中
        int len = -1;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }

        // 关闭资源
        outputStream.close();
        inputStream.close();

        // 删除临时文件
        part.delete();

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("上传成功");
    }
}
