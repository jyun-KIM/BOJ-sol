import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Stack<Character> stk = new Stack<>();

        int len = input.length();
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            stk.push(c);

            if (stk.size() >= 4) {
                int sz = stk.size();
                if (stk.get(sz - 4) == 'P' &&
                    stk.get(sz - 3) == 'P' &&
                    stk.get(sz - 2) == 'A' &&
                    stk.get(sz - 1) == 'P') {

                    for (int j = 0; j < 4; j++) {
                        stk.pop();
                    }
                    stk.push('P');
                }
            }
        }

        if (stk.size() == 1 && stk.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
