import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }

        //A,B 정보 입력
        int[] degree = new int[N+1];
        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            degree[b]++;
        }

        //topology sort
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(degree[i]==0) q.offer(i);
        }
        while (!q.isEmpty()){
            int current = q.poll();
            System.out.println(current);
            int next_size = list.get(current).size(); //다음으로 갈 수 있는 노드 개수
            for(int i=0; i<next_size; i++){
                int next = list.get(current).get(i);
                degree[next]--;
                if(degree[next]==0) q.offer(next);
            }
        }
    }

}


