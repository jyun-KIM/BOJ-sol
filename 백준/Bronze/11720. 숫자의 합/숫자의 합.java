
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();

        int sum=0;
        for (int i=0; i<n; i++){
            sum+=cNum[i]-'0';
        }
        System.out.println(sum);
    }
}

