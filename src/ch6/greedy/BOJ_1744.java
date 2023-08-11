package ch6.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();

        int one = 0;
        int zero = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                plusPq.offer(num);
            } else if (num == 1) {
                one++;
            } else if (num == 0) {
                zero++;
            } else {
                minusPq.offer(num);
            }
        }

        while (plusPq.size() > 1) {
            int first = plusPq.poll();
            int second = plusPq.poll();
            result += first * second;
        }
        if (!plusPq.isEmpty()) {
            result += plusPq.poll();
        }

        while (minusPq.size() > 1) {
            int first = minusPq.poll();
            int second = minusPq.poll();
            result += first * second;
        }
        if (!minusPq.isEmpty()) {
            if (zero == 0) {
                result += minusPq.poll();
            }
        }
        result += one;
        System.out.println(result);
    }
}
