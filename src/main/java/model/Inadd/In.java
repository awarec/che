package model.Inadd;

import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class In {

    public void Ine(){
        InetAddress inetAddress;
        InetAddress address3 ;


        {
            try {
                inetAddress = InetAddress.getLocalHost();

                System.out.println("计算机名:"+inetAddress.getHostName());
                System.out.println("ip:"+inetAddress.getHostAddress());
                byte[] bytes=inetAddress.getAddress();
                System.out.println(Arrays.toString(bytes));


                address3 = InetAddress.getByName("192.168.56.1");
                System.out.println("计算机名:"+address3.getHostName());
                System.out.println("ip:"+address3.getHostAddress());
                byte[] b=address3.getAddress();
                System.out.println(Arrays.toString(b));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }


}
