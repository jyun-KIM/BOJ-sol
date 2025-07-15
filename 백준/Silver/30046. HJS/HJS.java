import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String P = bf.readLine();
        String Q = bf.readLine();
        String R = bf.readLine();

        for(int h=1; h<=9;h++){
            for(int j=1;j<=9;j++){
                for(int s=1;s<=9;s++){
                    if(h!=j && j!=s && h!=s){
                        if(compare(P,Q,h,j,s)>0 && compare(Q,R,h,j,s)>0){
                            System.out.println("HJS! HJS! HJS!");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Hmm...");
        
    }

    private static int compare(String s1, String s2, int h, int j, int s){
        for(int i=0;i<s1.length();i++){
            int val1 = getValue(s1.charAt(i), h,j,s);
            int val2 = getValue(s2.charAt(i), h,j,s);

            if(val1 < val2) return -1; //s1<s2
            if(val1>val2) return 1; //s1>s2
        }
        return 0;
    }

    private static int getValue(char c, int h, int j, int s) {
        switch(c) {
            case 'H': return h;
            case 'J': return j;
            case 'S': return s;
            default: return -1;
        }
    }
}