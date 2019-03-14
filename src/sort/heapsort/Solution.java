package sort.heapsort;

import java.util.ArrayList;

/**
 * @program: arithmatictest
 * @description: 找出最小的k个数
 * @author: LLS
 * @create: 2019-02-21 18:09
 **/
public class Solution {

    public ArrayList<Integer> findSmallestNums(int[] array, int k){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int len=k/2-1; len>=0; len--){
            adjust(array, len,k-1);
        }
        for(int j = k; j < array.length; j++){
            if(array[j] < array[0]){
                swap(array, j, 0);
                for(int len=k/2-1; len>=0; len--){
                    adjust(array, len,k-1);
                }
            }
        }
        for(int l = 0; l < k; l++){
            list.add(array[l]);
        }
        return list;
    }

    //使用大根堆
    private void adjust(int[] array, int pos, int length){
        int child = pos * 2 + 1;
        if(child < length && array[child] < array[child+1]) child++;
        if(array[child] > array[pos]) swap(array, child, pos);
    }

    private void swap(int[] array, int p1, int p2){
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }
}
