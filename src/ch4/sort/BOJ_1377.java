package ch4.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        data[] arr = new data[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new data(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(arr);

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (result < arr[i].index - i) {
                result = arr[i].index - i;
            }
        }
        System.out.println(result + 1);
    }
}

class data implements Comparable<data> {
    int value;
    int index;

    public data(int value, int index) {
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(data o) {
        return this.value - o.value;
    }
}
