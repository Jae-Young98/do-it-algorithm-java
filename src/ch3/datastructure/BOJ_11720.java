package ch3.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] num = str.toCharArray();

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += num[i] - '0';
        }
        System.out.println(result);
    }
}
