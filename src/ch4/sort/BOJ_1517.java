package ch4.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1517 {
    public static int[] sorted, arr;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        sorted = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        mergeSort(arr, 0, n - 1);
        System.out.println(result);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                sorted[idx] = arr[l];
                idx++;
                l++;
            } else {
                sorted[idx] = arr[r];
                result += r - idx;
                idx++;
                r++;
            }
        }

        if (l > mid) {
            while (r <= right) {
                sorted[idx] = arr[r];
                idx++;
                r++;
            }
        } else {
            while (l <= mid) {
                sorted[idx] = arr[l];
                idx++;
                l++;
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }
}
