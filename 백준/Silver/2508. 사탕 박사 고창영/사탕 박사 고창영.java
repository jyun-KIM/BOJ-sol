import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int result =0;
    static Stack<Character> stk = new Stack<>();
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        
        for(int i=0;i<n;i++){
            bf.readLine();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            char[][] map = new char[r][c];
            for(int j=0;j<r;j++){
                map[j] = bf.readLine().toCharArray();
            }
            for(int k=0;k<r;k++){
                findCandy(map[k]);
            }
            for(int col=0;col<c;col++){
                char[] arr = new char[r];
                for(int row=0;row<r;row++){
                    arr[row] = map[row][col];
                }
                findCandy_row(arr);
            }
            System.out.println(result);
            result=0;
        }
        
    }

    private static void findCandy(char[] a){
        for(int i=2;i<a.length;i++){
            if(a[i]=='<'&&
              a[i-1]=='o'&&
              a[i-2]=='>'){
                result++;
              }
        }
    }
    private static void findCandy_row(char[] a){
        for(int i=2;i<a.length;i++){
            if(a[i]=='^'&&
              a[i-1]=='o'&&
              a[i-2]=='v'){
                result++;
              }
        }
    }
}
