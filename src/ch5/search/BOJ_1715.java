package ch5.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int card1 = 0;
        int card2 = 0;
        int result = 0;

        while (pq.size() != 1) {
            card1 = pq.poll();
            card2 = pq.poll();
            result += card1 + card2;
            pq.offer(card1 + card2);
        }

        System.out.println(result);
    }
}
