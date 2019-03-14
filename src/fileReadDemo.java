import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @program: arithmatictest
 * @description: TODO
 * @author: LLS
 * @create: 2019-03-11 15:06
 **/
public class fileReadDemo {
    public static void main(String[] args) throws IOException {
        read();
    }

    public static void read() throws IOException {
        File file = new File("C:\\Users\\LLS\\IdeaProjects\\arithmatictest\\src\\123.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        TreeMap<String,String> treeMap = new TreeMap<>();
        while (bufferedReader.read() != -1){
            String str = bufferedReader.readLine();
            System.out.println("str = " + str);
            String[] array = str.split(",");
            treeMap.put(array[0],array[1]);
        }
        Set<Map.Entry<String,String>> set = treeMap.entrySet();
        for(Map.Entry entry: set){
            System.out.println(entry.getKey()+"+"+entry.getValue());
        }
    }
}
