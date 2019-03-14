import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.ListIterator;

public class HelloWorld {
    public static void main(String[] args) {
//        System.out.println(reverse6("hello"));
//        StringBuffer stringBuffer = new StringBuffer("hello");
//        String str = stringBuffer.reverse().toString();
//        System.out.println("str = " + str);
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static String reverse6(String s) {
        char[] str = s.toCharArray();
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            str[begin] = (char) (str[begin] ^ str[end]);
            str[end] = (char) (str[begin] ^ str[end]);
            str[begin] = (char) (str[end] ^ str[begin]);
            begin++;
            end--;
        }
        return new String(str);
    }
}