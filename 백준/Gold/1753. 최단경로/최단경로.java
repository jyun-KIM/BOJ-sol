import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V,E,K;
    static int[] distance; //최단 거리 테이블
    static boolean[] visited;
    static ArrayList<Edge> list[]; //그래프 본체 저장
    static PriorityQueue<Edge> q = new PriorityQueue<Edge>(); //edge를 오름차순으로 정렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        visited = new boolean[V+1];
        distance = new int[V+1];
        for(int i = 1; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v,w));
        }
        q.add(new Edge(K,0));
        distance[K] = 0;
        while(!q.isEmpty()){
            Edge current = q.poll();
            if(visited[current.vertex]) continue;
            visited[current.vertex] = true;
            for(Edge edge : list[current.vertex]){
                int newCost = current.value + edge.value;
                int existingCost = distance[edge.vertex];
                if(newCost < existingCost){
                    distance[edge.vertex] = newCost;
                }
                q.add(new Edge(edge.vertex, distance[edge.vertex]));
            }
        }
        for(int i = 1; i <= V; i++) {
            if(distance[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(distance[i]);
        }

    }
    static class Edge implements Comparable<Edge> {
        int vertex, value;
        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge e) {
            if(this.value < e.value) return -1;
            else return 1;
        }
    }
}
