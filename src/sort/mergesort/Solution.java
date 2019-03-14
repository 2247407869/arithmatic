package sort.mergesort;

import java.util.ArrayList;

/**
 * @program: arithmatictest
 * @description: 归并排序
 * @author: LLS
 * @create: 2019-02-21 18:09
 **/
public class Solution {

    public int[] sort(int[] array){
        return separate(array,0,array.length -1);
    }

    public int[] separate(int[] array, int start, int end){
        if(end <= start){
            return array;
        }
        int mid = start + (end - start) / 2 + 1;
        separate(array, start, mid -1);
        separate(array,mid,end);
        return merge(array, start, mid, end);
    }

    public int[] merge(int[] array, int start, int mid, int end){
        int[] newArray = new int[end - start + 1];
        int leftFlag = start;
        int rightFlag = mid;
        int newArrayFlag = 0;
        while(leftFlag <= mid - 1 && rightFlag <= end){
            if(array[leftFlag] < array[rightFlag]){
                newArray[newArrayFlag++] = array[leftFlag++];
            } else {
                newArray[newArrayFlag++] = array[rightFlag++];
            }
        }
        while(leftFlag <= mid - 1){
            newArray[newArrayFlag++] = array[leftFlag++];
        }
        while(rightFlag <= end){
            newArray[newArrayFlag++] = array[rightFlag++];
        }
        for(int i = 0 ; i < newArray.length ; i++){
            array[start + i] = newArray[i];
        }
        return array;
    }
}
