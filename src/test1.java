import java.util.LinkedHashMap;

//第一个只出现一次的字符
public class test1 {

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("124212"));
    }

    public static int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
        for(int i = 0; i<str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                int times = map.get(str.charAt(i));
                map.put(str.charAt(i),++times);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        int position = -1;
        for(int i = 0; i<str.length(); i++){
            if(map.get(str.charAt(i))==1){
                position = i;
                break;
            }
        }
        return position;
    }
}
