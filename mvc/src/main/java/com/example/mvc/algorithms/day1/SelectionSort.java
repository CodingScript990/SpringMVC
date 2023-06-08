package com.example.mvc.algorithms.day1;

import java.util.Arrays;

// SelectionSort => Sort
public class SelectionSort {
    public static void main(String[] args) {
        // 25 12 18 24 2 21
        // result : 2 12 18 21 24 25
        int[] arrSelection = new int[]{25, 12, 18, 24, 2, 21};
        int n = arrSelection.length;

        // 제일 작은 원소를 찾아서 앞으로 보내기
        for (int i = 0; i < n - 1; i++) { // 1의 값이 총 정렬된 원소의 갯수를 말함
            // 제일 앞에를 원소를 현재 제일 작다고 설정함
            int minIdx = i;
            // i + 1부터 끝 원소까지 차근차근 비교하기
            for (int j = i + 1; j < n; j++) {
                // 제일 작은 숫자를 찾기
                if (arrSelection[j] < arrSelection[minIdx]) {
                    minIdx = j;
                }
            }
            // 제일 앞의 원소와 제일 적은 원소를 교한하기
            int temp = arrSelection[minIdx];
            arrSelection[minIdx] = arrSelection[i];
            arrSelection[i] = temp;
        }
        // SelectionSort Result
        System.out.println(Arrays.toString(arrSelection));
    }
}
