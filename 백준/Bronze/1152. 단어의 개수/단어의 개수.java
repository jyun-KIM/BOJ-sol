import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String S = in.nextLine();
        in.close();

        StringTokenizer st = new StringTokenizer(S, " ");

        System.out.println(st.countTokens());
        
    }
}