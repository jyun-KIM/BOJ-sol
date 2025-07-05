import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter; 
import java.io.IOException;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> deq = new LinkedList<>();
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            int now = Integer.parseInt(st.nextToken()); //현재 보고있는 값
            while (!deq.isEmpty() && deq.getLast().val > now) {
                deq.removeLast();
            }
            deq.addLast(new Node(i, now));
            if(deq.getLast().idx - deq.getFirst().idx >= L){
                // System.out.printf("last: %d, first: %d\n",deq.getLast().idx, deq.getFirst().idx);
                deq.removeFirst();
            }
            bw.write(deq.getFirst().val + " ");
            
        }
        bw.flush();
        bw.close();
        
    }
    static class Node{
        int idx;
        int val;

        Node(int idx, int val){
        this.idx = idx;
        this.val = val;
        }
    }
    

    
}

