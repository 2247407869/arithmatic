public class GetNumberOfK {

    public static void main(String[] args) {
        int[] a = {3,3,3,3};
        System.out.println(GetNumberOfK(a,4));
    }

    public static int GetNumberOfK(int[] array, int k) {
        if(array == null || array.length == 0){
            return 0;
        }
        int left = findLeft(array, k, 0, array.length-1);
        int right = findRight(array, k, 0, array.length-1);
        return right - left + 1;
    }
    public static int findLeft(int[] array, int k, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if(array[mid]>k){
            return findLeft(array, k, start, mid-1);
        }else if(array[mid]<k){
            return findLeft(array, k, mid+1, end);
        }else if(mid-1 >=0 && array[mid-1] == k){
            return findLeft(array, k, start, mid-1);
        }else{
            return mid;
        }
    }

    public static int findRight(int[] array, int k, int start, int end){
        int length = array.length;
        while(start<=end){
            int mid = (start + end) >> 1;
            if(array[mid]>k){
                end = mid-1;
            }else if(array[k]<k){
                start = mid +1;
            }else if(mid+1<length && array[mid+1]==k){
                start = mid +1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
