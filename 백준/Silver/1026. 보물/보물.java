import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] A = new Integer[N];
        int[] B = new int[N];

        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        for(int i=0; i<N; i++){
            B[i] = sc.nextInt();
        }

        Arrays.sort(B);
        Arrays.sort(A, Collections.reverseOrder());
        int result = 0;

        for(int i=0; i<N; i++){
            result += A[i] * B[i];
        }
        System.out.println(result);

    }
}