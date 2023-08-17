package ch7.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = n;

        for (long p = 2; p <= Math.sqrt(n); p++) {
            if (n % p == 0) { // 소인수인지
                result = result - result / p;
                while (n % p == 0) { // 아닐때까지 나눔
                    n /= p;
                }
            }
        }
        if (n > 1) { // 아직 소인수 구성이 남아 있을 때
            result = result - result / n;
        }
        System.out.println(result);
    }
}
