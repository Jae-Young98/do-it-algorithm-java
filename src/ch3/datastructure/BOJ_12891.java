package ch3.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891 {
    static int s;
    static int p;
    static char[] str;
    static int[] checkArr = new int[4];
    static int[] myArr = new int[4];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        str = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < p; i++) {
            Add(str[i]);
        }

        CheckNum();

        for (int i = p; i < s; i++) {
            int j = i - p; // 나가는 문자
            // 나가는 문자 처리
            Remove(str[j]);

            // 들어 오는 문자
            Add(str[i]);

            CheckNum();
        }
        System.out.println(result);
    }

    public static void Add(char c) {
        if (c == 'A') {
            myArr[0]++;
        } else if (c == 'C') {
            myArr[1]++;
        } else if (c == 'G') {
            myArr[2]++;
        } else if (c == 'T') {
            myArr[3]++;
        }
    }

    public static void Remove(char c) {
        if (c == 'A') {
            myArr[0]--;
        } else if (c == 'C') {
            myArr[1]--;
        } else if (c == 'G') {
            myArr[2]--;
        } else if (c == 'T') {
            myArr[3]--;
        }
    }

    public static void CheckNum() {
        for (int i = 0; i < 4; i++) {
            if (myArr[i] < checkArr[i]) {
                return;
            }
        }
        result++;
    }
}
