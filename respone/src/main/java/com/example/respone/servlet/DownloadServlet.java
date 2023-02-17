package com.example.respone.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
@WebServlet("/download")
public class DownloadServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("开始下载");
        //1.获取请求参数，文件名称
        String filename= request.getParameter("file");
        System.out.println(filename);

        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext=this.getServletContext();
        String realPath = servletContext.getRealPath(".img"+filename);
        //2.2用字节流关联
        FileInputStream fis=new FileInputStream(realPath);
    }
}
