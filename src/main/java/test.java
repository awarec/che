import model.ce.Str;
import model.email;
import model.er.Address;
import model.merag_pictures.Pictures;
import model.oss.OssUtil;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

    public static void main(String[] args) {

//        email.email();
//        String a="^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$";
////        Pattern p = Pattern.compile("^1[3456789]\\d{9}$");
//        Pattern p = Pattern.compile("^1[3-9]\\d{9}$");
//
//        Scanner scanner= new  Scanner(System.in);
//        String let=scanner.next();
//        Matcher matcher=p.matcher(let);
//        System.out.println(matcher.matches());
//        String ss="D:\\file\\files\\20200716\\1-A2.png";
//        FileInputStream file= null;
//        try {
//            file = new FileInputStream(ss);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        String name="1-A2.png";
//        OssUtil.uploadImageToOSS(name,file);

        String ss=" file:///D:/file/files/20200716/1-A2.png";
        String merchant=" file:///D:/code/111.png";
//        Class c=ss.getClass().getEnclosingClass();
//        boolean f=false;
//        System.out.println();
//        System.out.println(c);
        System.out.println( System.getProperty("Address.java"));
        File file=new File("model.er.Address");
//        String path=file.getAbsolutePath();
        String absPath1 = file.getAbsolutePath();//获取文件的绝对路径，即全路径 返回的是String对象
//        path=file.getPath();
        System.out.println(absPath1);
        String classPath = test.class.getResource("/").getPath();
        System.out.println(classPath);
        Pictures.generateCode(ss,"5","123",merchant);
        System.out.println( Class.class.getClass().getResource("/").getPath());

        //获取类加载的根路径
        File file3 = new File(Address.class.getClass().getResource("/").getPath());
        System.out.println(file3);
//
//        //获取当前类的所在工程路径
//        File file4 = new File(this.getClass().getResource("").getPath());
//        System.out.println(file4);
        File file1=new File("");
        try {
            String s=file1.getCanonicalPath();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();

        }


    }
}
