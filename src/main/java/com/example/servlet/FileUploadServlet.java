package com.example.servlet;

import com.alibaba.fastjson.JSON;
import com.example.utils.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * 用来处理文件上传的Servlet
 * @author youngoo
 */
@WebServlet(name = "FileUploadServlet", value = "/FileUploadServlet")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入方法");
        String imageDir = request.getServletContext().getRealPath("image");
        File file = new File(imageDir);
        if (!file.exists()) {
            boolean b = file.mkdir();
        }
        Part image = request.getPart("file");
        UUID uuid = UUID.randomUUID();
        int i = image.getSubmittedFileName().indexOf(".");
        String filePath = imageDir +"\\" + uuid.toString() + image.getSubmittedFileName().substring(i);
        image.write(filePath);
        if (new File(filePath).exists()) {
            // 创建成功

            response.setContentType("application/json; charset=utf-8");
            HashMap<String, Object> data = new HashMap<>(1);
            String fileRelation = filePath.substring(filePath.lastIndexOf("image"));
            data.put("src", fileRelation);
            ResultInfo result = ResultInfo.builder()
                    .code(0)
                    .msg("成功")
                    .data(data)
                    .build();
            response.getWriter().println(JSON.toJSONString(result));
        }
    }
}