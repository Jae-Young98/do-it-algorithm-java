package ch5.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        long start = 1;
        long end = k;
        long result = 0;

        // 이진 탐색
        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;

            // 중앙값보다 작은 수 카운트
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n);
            }
            if (cnt < k) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
