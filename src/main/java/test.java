import model.email;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

    public static void main(String[] args) {

//        email.email();
        String a="^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$";
//        Pattern p = Pattern.compile("^1[3456789]\\d{9}$");
        Pattern p = Pattern.compile("^1[3-9]\\d{9}$");

        Scanner scanner= new  Scanner(System.in);
        String let=scanner.next();
        Matcher matcher=p.matcher(let);
        System.out.println(matcher.matches());

    }
}
