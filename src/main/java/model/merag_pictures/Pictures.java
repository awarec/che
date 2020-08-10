package model.merag_pictures;

import model.ce.Str;
//import sun.security.pkcs11.wrapper.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class Pictures {                 //二维码地址       //名字          用户名            商户logo
    public  static String generateCode(String codeUrl, String userId, String userName ,String merchant ) {
        Font font = new Font("Arial", Font.PLAIN , 72);// 添加字体的属性设置


        String imgName ="D:\\code\\5.png";
        try {
            // 加载本地图片
            String imageLocalUrl =  "D:\\code\\diandan.png";
            BufferedImage imageLocal = ImageIO.read(new File(imageLocalUrl));
            // 加载用户的二维码
            BufferedImage imageCode = ImageIO.read(new URL(codeUrl));
            // 加载用户的二维码
            BufferedImage mer = ImageIO.read(new URL(merchant));
            // 以本地图片为模板
            Graphics2D g = imageLocal.createGraphics();
            // 在模板上添加用户二维码(地址,左边距,上边距,图片宽度,图片高度,未知)
            g.drawImage(imageCode, 100, imageLocal.getHeight() - 620, 400, 400, null);

            g.drawImage(mer, 50, imageLocal.getHeight() - 860, 60, 60, null);
            // 设置文本样式
            g.setFont(font);
            g.setColor(Color.BLACK);
            // 截取用户名称的最后一个字符
            String lastChar = userName.substring(userName.length() - 1);
            // 拼接新的桌号
            String newUserName = "A1101";

            // 拼接新的桌号           左边距                         上下
            g.drawString(newUserName, 210, imageLocal.getHeight() - 680);

            Font font1 = new Font("思源黑体", Font.BOLD , 30);// 添加字体的属性设置
            g.setFont(font1);
            //名称
            g.drawString("天水洗浴", 115, imageLocal.getHeight() - 820);
            // 完成模板修改
            g.dispose();
            // 获取新文件的地址
            File outputfile = new File(imgName);
            // 生成新的合成过的用户二维码并写入新图片
            ImageIO.write(imageLocal, "png", outputfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回给页面的图片地址(因为绝对路径无法访问)
//        imgName =  "codeImg/" + userId + ".png";
//        System.out.println(imgName);
        return imgName;
    }
}
