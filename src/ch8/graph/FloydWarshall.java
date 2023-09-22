package ch8.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FloydWarshall {
    static int n, m;
    static int[][] distance;
    /*
    sample input / node, edge
    5
    8
    0 1 5
    0 4 1
    0 2 7
    0 3 2
    1 2 3
    1 3 6
    2 3 10
    3 4 4
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        // 플로이드 초기 거리 테이블
        distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 자기 자신은 최소 비용 0
                if (i == j) {
                    distance[i][j] = 0;
                    continue;
                }
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            distance[s][e] = Math.min(distance[s][e], v);
            distance[e][s] = Math.min(distance[e][s], v);
        }
        // floyd-warshall
        for (int k = 0; k < n; k++) {
            // node i -> j
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // k번 째 노드를 거쳐가는 비용이 기존 비용보다 더 작을 경우 갱신
                    // 또는 연결이 안되어있으면 갱신
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        // print
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (distance[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
