package ch6.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) { // 종료시간 같을 때
                    return o1[0] - o2[0]; // 시작시간 기준으로
                }
                return o1[1] - o2[1];
            }
        });
        int result = 0;
        int end = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] >= end) {
                end = arr[i][1];
                result++;
            }
        }
        System.out.println(result);
    }
}
