package equalTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: arithmatictest
 * @description: TODO
 * @author: LLS
 * @create: 2019-03-07 23:34
 **/
public class Main {
    public static void main(String[] args) {
        Peaple p1 = new Peaple();
        Peaple p2 = new Peaple();
        p1.setName("lls");
        p2.setName("lls");
        HashMap<Integer,Peaple> hashMap = new HashMap<>();
        hashMap.put(1,p1);
        hashMap.put(2,p2);
        Set<Map.Entry<Integer,Peaple>> set = hashMap.entrySet();
        for (Map.Entry entry : set) {
            System.out.println(entry.toString());
        }

//        System.out.println(treeSet.toArray());
        System.out.println(p1.equals(p2));
        System.out.println(p1 == p2);
    }
}
