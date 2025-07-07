import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] A = new int[n];
        int[] anw = new int[n];
        for(int i=0;i<n;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && A[stk.peek()]<A[i]){
                int a = stk.pop();
                anw[a] = A[i];
            }
            stk.push(i);
            
        }
        while (!stk.isEmpty()) {
            anw[stk.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<n;i++){
            bw.write(anw[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}