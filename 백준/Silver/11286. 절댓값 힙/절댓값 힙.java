import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq =  new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(Math.abs(o1) == Math.abs(o2)) return o1-o2;
                else return Math.abs(o1)-Math.abs(o2);
            }
        });

        for(int i=0;i<n;i++){
            int x = Integer.parseInt(bf.readLine());
            if(x!=0){
                pq.add(x);
            }else if(x==0 && !pq.isEmpty()){
                pq.comparator();
                bw.write(pq.poll()+"\n");
            }
            else{
                bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();
        bf.close();
        
    }
}