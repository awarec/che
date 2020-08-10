package model.apche;


import com.wf.captcha.ArithmeticCaptcha;
import model.ce.Str;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Apche {

    public void Ao(HttpServletRequest request, HttpServletResponse response)throws  Exception{
        ArithmeticCaptcha captcha=new ArithmeticCaptcha(130,48);
        System.out.println(captcha.toBase64());
        System.out.println(captcha.text());
        request.setAttribute("img",captcha.toBase64());
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }


}
