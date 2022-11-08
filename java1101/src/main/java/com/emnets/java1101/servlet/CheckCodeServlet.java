package com.emnets.java1101.servlet;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


/**
 * 验证码
 */
@WebServlet(name = "CheckCodeServlet", value = "/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  1.创建一个对象，在内存中图片
        int width = 100;
        int height = 50;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);

        //  2.美化图片
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.pink);
        graphics.fillRect(0,0,width,height);

        graphics.setColor(Color.blue);
        graphics.drawRect(0,0,width-1,height-1);

        String  str = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxvbnm0123456789";
        Random ran = new Random();
        for(int i=1;i<=4;i++){
            // 随机角标

            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);
            graphics.drawString(ch+"",width/5*i,height/2);
        }

        //  画干扰线
        graphics.setColor(Color.GREEN);

        for(int i=0;i<10;i++){
            int x1 = ran.nextInt(width);
            int y1 = ran.nextInt(width);
            int x2 = ran.nextInt(height);
            int y2 = ran.nextInt(height);

            graphics.drawLine(x1,y1,x2,y2);
        }



        //  3.将图片输出到展示页
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

}
