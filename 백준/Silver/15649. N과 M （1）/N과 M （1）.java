import java.util.Scanner;

class Main {
    static int N, M;
    static boolean[] V; //숫자 사용 여부 저장
    static int[] S; //수열 정보 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = new boolean[N + 1];
        S = new int[N];
        backTracking(0);
    }
    private static void backTracking(int length){
        if(length == M){
            printArray();
        }
        for(int i=1; i<=N; i++){
            if(!V[i]){
                V[i] = true;
                S[length] = i;
                backTracking(length+1);
                V[i] = false;
            }
        }

    }
    private static void printArray(){
        for(int i=0; i<M; i++){
            System.out.print(S[i]+" ");
        }
        System.out.println();
    }
}
