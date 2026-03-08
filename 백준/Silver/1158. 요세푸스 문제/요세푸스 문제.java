import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Deque<Integer> queue = new LinkedList<>();
        bw.write("<");
        
        //queue 에 1~n pop
        for(int i=1;i<=n;i++){
            queue.add(i);
        }
        //while queue 길이>0
        while(queue.size()>1){
            //pop + push k-1번
            for(int i=0;i<(k-1);i++){
                queue.add(queue.poll());
            }
            //bw.write(pop+", ")
            bw.write(queue.poll()+", ");
        }
        bw.write(queue.poll()+">");
        bw.close();
        
    }
}