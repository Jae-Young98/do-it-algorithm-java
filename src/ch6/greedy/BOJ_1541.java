package ch6.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = 0;
        String[] arr = str.split("-");
        for (int i = 0; i < arr.length; i++) {
            int temp = arrSum(arr[i]);
            if (i == 0) {
                result += temp;
            } else {
                result -= temp;
            }
        }
        System.out.println(result);
    }

    public static int arrSum(String str) {
        int sum = 0;
        String[] temp = str.split("\\+");
        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
