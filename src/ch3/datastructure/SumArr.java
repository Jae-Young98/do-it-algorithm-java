package ch3.datastructure;

import java.io.IOException;

public class SumArr {
    public static void main(String[] args) {
        int[] arr = {15, 13, 10, 7, 3, 12};
        int[] sumArr = new int[arr.length];
        sumArr[0] = arr[0];

        // 합 배열 S[i] = S[i - 1] + A[i]
        for (int i = 1; i < arr.length; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
            System.out.print(sumArr[i] + " ");
        }
        System.out.println();

        // 구간 합 구하기 S[j] - S[i - 1] ex ) arr[2] ~ arr[5]
        int i = 2;
        int j = 5;
        System.out.println("구간 합 알고리즘 : " + (sumArr[j] - sumArr[i - 1]));

        // 직접 구하기
        int result = 0;
        for (int k = 2; k < arr.length; k++) {
            result += arr[k];
        }
        System.out.println("직접 구하기 : " + result);
    }
}
