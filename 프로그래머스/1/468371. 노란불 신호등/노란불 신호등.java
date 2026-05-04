import java.util.*;
// g->y->r 
// all y -> 정전 
class Solution {
    public int solution(int[][] signals) {
        // int answer = 0;
        int n = signals.length;
        int[] t = new int[n];
        //각 signal 주기 계산
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                t[i]+=signals[i][j];
            }
        }
        System.out.println(Arrays.toString(t));
        //주기의 최소공배수 lcm 계산
        int lcm = t[0];
        for(int i=1;i<n;i++){
            lcm = getLCM(lcm, t[i]);
        }
        //최소공배수까지 돌면서 각 sig가 어느 색인지 판단
        for(int i=1;i<=lcm;i++){
            boolean isY=true;
            for(int j=0;j<n;j++){
                int color = (i-1) % t[j];
                if(!(signals[j][0]<=color && color<signals[j][0]+signals[j][1])) {
                    isY = false;
                    break;
                }
            }
            if(isY) return i;
        }
        //모두 노란색이면 return 
        return -1;
    }
    
    // 최소공배수(lcm)
    public static int getLCM(int a, int b) {
        return (a * b) / getGCD(a, b);
    }

    // 최대공약수(gcd)
    public static int getGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}