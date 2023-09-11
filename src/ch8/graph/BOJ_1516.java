package ch8.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        int[] indegree = new int[n + 1];
        int[] buildTime = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) {
                    break;
                }
                list.get(next).add(i);
                indegree[i]++;
            }
        }

        // 위상정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[n + 1];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : list.get(node)) {
                indegree[next]--;
                // 시간
                result[next] = Math.max(result[next], result[node] + buildTime[node]);
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(result[i] + buildTime[i]);
        }
    }
}

