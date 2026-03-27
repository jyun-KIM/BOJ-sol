import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int r=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] tree = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        int[] order = new int[n];
        int[] parent = new int[n+1];
        boolean[] visited = new boolean[n+1];
        int idx=0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(r);
        parent[r]=-1; //루트 표시 
        visited[r]=true;
        order[idx]=r;
        while(!queue.isEmpty()){
            int cur=queue.poll();
            //order에 넣고 방문 처리
            order[idx]=cur;
            idx++;
            //tree[cur]을 돌면서 
            for(int next:tree[cur]){
                if(visited[next]==false){
                    queue.add(next);
                    parent[next]=cur;
                    visited[next]=true;
                }
            }
            //방문하지 않았으면 큐에 넣기 
                //parent 표시 
        }

        //거꾸로 돌면서 서브트리 노드 개수를 배열에 저장 
        int[] subTree = new int[n+1];
        for(int i=n-1;i>0;i--){
            int child=order[i];
            int p = parent[child]; //부모
            subTree[p]+=subTree[child]+1;
        }

        for(int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            System.out.println(subTree[x]+1);
        }
    }
}