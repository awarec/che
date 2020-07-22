package model;

import model.ce.Str;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownLoad {
    public static void downNetWorkImgUtil(HttpServletResponse response ,String imgPath){
        try {
            URL url = new URL(imgPath);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            OutputStream fileOutputStream = response.getOutputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            response.reset();
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding("UTF-8");

            response.setHeader("Content-disposition", "attachment; filename=" + (imgPath.substring(imgPath.lastIndexOf("/") + 1, imgPath.length())));

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            byte[] context = output.toByteArray();
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
