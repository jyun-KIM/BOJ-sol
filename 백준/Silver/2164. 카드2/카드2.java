import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> que = new LinkedList<>();
        for(int i=1;i<=n;i++){
            que.add(i);
        }
        while (que.size()>1) {
            que.poll();
            que.add(que.poll());
        }
        System.out.println(que.poll());
    }
}