package ch3.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());

            // 새로운 값이 들어올 때마다 현재 수보다 큰 값을 덱에서 제거
            while (!deque.isEmpty() && deque.getLast().val > now) {
                deque.removeLast();
            }

            deque.addLast(new Node(now, i));

            // 범위에서 벗어난 값 제거
            if (deque.getFirst().idx < i - l + 1) {
                deque.removeFirst();
            }

            sb.append(deque.getFirst().val + " ");
        }
        System.out.println(sb);
    }

    static class Node {
        int val;
        int idx;

        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
