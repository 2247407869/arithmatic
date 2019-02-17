public class Solution {
    private static int[] array = new int[256];
    public Solution(){
        for(int i = 0; i < array.length; i++){
            array[i] = 0;
        }
    }
    public static int Longest(char[] ch)
    {
        for(int i = 0; i < ch.length; i++){
            if(array[ch[i]] == 0)array[ch[i]] = -(i+1);
            else if(array[ch[i]] < 0)array[ch[i]] += i+1;
        }

        int max = Integer.MIN_VALUE;
        for (int k : array) {
            if (k > max) {
                max = k;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        char[] array = {'a','b','c','d','c','f','b','a','e',};
        System.out.println(Longest(array));
    }

}