package sort.mergesort;

import java.util.Arrays;

/**
 * @program: arithmatictest
 * @description:
 * @author: LLS
 * @create: 2019-02-21 18:10
 **/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {3,4,5,1,2};
        System.out.print(Arrays.toString(solution.sort(array)));
    }
}
