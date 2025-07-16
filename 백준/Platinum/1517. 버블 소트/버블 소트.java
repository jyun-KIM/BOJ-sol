import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static long[] A, tmp;
    static long result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        A = new long[n + 1];
        tmp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        merge_sort(1, n);
        System.out.println(result);
    }

    private static void merge_sort(int s, int e) {
        if (s >= e) return;
        int m = (s + e) / 2;

        merge_sort(s, m);
        merge_sort(m + 1, e);

        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }

        int k = s;
        int idx1 = s;
        int idx2 = m + 1;

        while (idx1 <= m && idx2 <= e) {
            if (tmp[idx1] < tmp[idx2]) {
                A[k++] = tmp[idx1++];
            } else if (tmp[idx1] > tmp[idx2]) {
                result += (idx2 - k); 
                A[k++] = tmp[idx2++];
            } else {
                A[k++] = tmp[idx1++];  
            }
        }

        while (idx1 <= m) {
            A[k++] = tmp[idx1++];
        }

        while (idx2 <= e) {
            A[k++] = tmp[idx2++];
        }
    }
}
