package ch3.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int k = 0; k < n; k++) {
            int target = arr[k];
            int i = 0;
            int j = n - 1;
            while (i < j) {
                if (arr[i] + arr[j] == target) {
                    // 서로 다른 두 수 체크
                    if (i != k && j != k) {
                        count++;
                        // 좋은 수 체크용
                        // sb.append(arr[k] + " ");
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (arr[i] + arr[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(count);
        // System.out.println(sb);
    }
}
