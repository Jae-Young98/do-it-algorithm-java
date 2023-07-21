package ch3.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int m = 0;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > m) {
                for (int j = m+1; j <= x; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                m = x;
            } else if (stack.peek() != x) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}
