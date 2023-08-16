package ch7.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        // 최댓값과 최솟값의 차이만큼 배열
        boolean[] check = new boolean[(int)(max-min+1)];
        // 2의 제곱수인 4 부터 max보다 작은 값까지 반복
        for (long i = 2; i * i <= max; i++) {
            long pow = i*i; // 제곱수
            long start = min / pow;
            if (min % pow != 0) { // 나머지가 있으면 1을 더함
                start++;
            }
            for (long j = start; pow * j <= max; j++) {
                check[(int)((j * pow) - min)] = true;
            }
        }
        int result = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!check[i]) {
                result++;
            }
        }
        System.out.println(result);
    }
}
