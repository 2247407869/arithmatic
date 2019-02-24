package sort;

/**
 * @program: arithmatictest
 * @description: 最小堆
 * @author: LLS
 * @create: 2019-02-21 18:09
 **/
public class MinHeapTest {

    public static int[] minHeapSort(int[] array){
        for(int i = array.length / 2 - 1; i>=0; i--){
            adjust(array, i,array.length);
        }
        return array;
    }

    public static int[] adjust(int[] array, int pos, int length){
        return array;
    }
}
