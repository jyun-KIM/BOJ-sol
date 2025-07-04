import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String dna = bf.readLine();  
        char[] randArr = dna.toCharArray();  

        st = new StringTokenizer(bf.readLine());
        int[] cond = new int[4];
        for (int i=0;i<4;i++){
            cond[i] = Integer.parseInt(st.nextToken());
        }

        int result=0;

        int[] myArr = new int[4];
        for(int i=0;i<p;i++){
                switch (randArr[i]) {
                    case 'A': 
                        myArr[0]++; break;
                    case 'C':
                        myArr[1]++; break;
                    case 'G':
                        myArr[2]++; break;
                    case 'T':
                        myArr[3]++; break;
                }
        }
            if (checkArr(cond, myArr)) result++;

        for(int i=1;i<=s-p;i++){
            switch (randArr[i-1]) {
                    case 'A': 
                        myArr[0]--; break;
                    case 'C':
                        myArr[1]--; break;
                    case 'G':
                        myArr[2]--; break;
                    case 'T':
                        myArr[3]--; break;
                }
            switch (randArr[i+p-1]) {
                    case 'A': 
                        myArr[0]++; break;
                    case 'C':
                        myArr[1]++; break;
                    case 'G':
                        myArr[2]++; break;
                    case 'T':
                        myArr[3]++; break;
                }
            if (checkArr(cond, myArr)) result++;
            
        }
        System.out.println(result);

        
        
    }

    private static boolean checkArr(int[] cond, int[] myArr){
        for(int i=0;i<4;i++){
            if(cond[i] > myArr[i]) return false;
        }
        return true;
    }

    
}

