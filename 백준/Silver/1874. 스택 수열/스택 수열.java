import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer sf = new StringBuffer();
        int num = 1;
        boolean result = true;
        for(int i=0;i<A.length;i++){
            if(A[i]>=num){
                while (A[i]>=num) {
                    stack.push(num);
                    num++;
                    sf.append("+\n");
                }
                stack.pop();
                sf.append("-\n");
            }else{
                int m = stack.pop();
                    if(m>A[i]){
                        result=false;
                        System.out.println("NO");
                        break;
                    }else{
                        sf.append("-\n");
                    }
                }
            
        }
        if(result) System.out.println(sf.toString());
    
    }
}
