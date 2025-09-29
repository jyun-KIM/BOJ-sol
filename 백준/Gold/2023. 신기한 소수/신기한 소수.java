import java.io.IOException;
import java.util.Scanner;

class Main {
    static int N;

    private static void DFS(int num, int digits){
        if(digits == N){
            if(isPrime(num))
                System.out.println(num);
        }
        for(int i=1; i<10; i++){
            if(i%2==0) continue;
            if(isPrime(num*10 + i)){
                DFS(num*10 + i, digits+1);
            }
        }
    }

    private static boolean isPrime(int num) {
        for(int i=2; i<=num/2; i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();

        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);

    }
}