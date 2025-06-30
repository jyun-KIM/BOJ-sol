import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] arr = new int[N];

        for (int i=0; i<N; i++){
            arr[i] = in.nextInt();
        }

        in.close();

        Arrays.sort(arr);

        for (int i=0; i<N; i++){
            System.out.println(arr[i]);
        }
    }
}