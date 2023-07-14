package ch3.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n, m, remainder;
        long result = 0;
        long[] sumArr;
        long[] count;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 합 배열 및 나머지가 같은 인덱스의 수 카운팅용 배열 선언
        sumArr = new long[n];
        count = new long[m];

        // 합 배열 만들기
        st = new StringTokenizer(br.readLine());
        sumArr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            remainder = (int)(sumArr[i] % m);
            // 0 ~ i 구간 합 % m 이 0인 경우 결과값 더하기
            if (remainder == 0) {
                result++;
            }
            // 나머지가 같은 인덱스의 수 카운팅
            count[remainder]++;
        }

        // sumArr[j] % m == sumArr[i-1] % m 을 만족하는 (i, j)
        // count[i]에서 2가지를 뽑는 경우의 수 카운팅
        for (int i = 0; i < m; i++) {
            if (count[i] > 1) {
                result += (count[i] * (count[i] - 1) / 2);
            }
        }
        System.out.println(result);
    }
}
