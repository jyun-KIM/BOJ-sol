import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = new int[arr.length];
        int n=0;
        int i=0;
        while (i<arr.length){
            if (n==0){
                stk[n]=arr[i];
                n++;
                i++;
            } else if (n!=0 && stk[n-1]<arr[i]){
                stk[n]=arr[i];
                n++;
                i++;
            }else{
                n--;
            }
        }
        return Arrays.copyOf(stk, n);
    }
}