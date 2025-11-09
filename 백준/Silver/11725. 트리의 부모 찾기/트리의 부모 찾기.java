import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    //필요한 자료구조 선언
    static ArrayList<Integer>[] tree;
    static int[] isVisited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        //트리 초기화
        tree = new ArrayList[N+1];
        for(int i=1; i<=N;i++){
            tree[i] = new ArrayList<>();
        }

        //트리 생성
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        //탐색
        isVisited = new int[N+1];
        dfs(1);

        //정답 출력
        for(int i=2; i<N+1; i++){
            System.out.println(isVisited[i]);
        }

    }
    static void dfs(int current){
        for(int child:tree[current]){
            if(isVisited[child]==0){ //방문 안 함
                isVisited[child] = current;
                dfs(child);
            }
        }
    }
}
