import com.wf.captcha.ArithmeticCaptcha;
import model.Inadd.In;
import model.ce.Str;

public class ceshi {

    public static void main(String[] args) {

//        int[] a=new int[3];
////        int[] b=new int[]{1,2,3,4,5};
////        a=b;
////        for (int i = 0; i < b.length; i++) {
////            System.out.println(a[i]+"");
////        }
////        int x=16;
////        int y=5;
////        System.out.println(x/y);
////        System.out.println((double)x/y);

        String a ="a";
        String b=a+"b" ;
        String c="ab";
        String d=new String(b);
        System.out.println(b==c);
        System.out.println(c==d);
        System.out.println(c==d.intern());
        System.out.println(b.intern()==d.intern());

        In in=new In();
        in.Ine();

    }
}
