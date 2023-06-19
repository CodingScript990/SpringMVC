package com.example.mvc.algorithms.sort;

import java.util.Arrays;

// BubbleSort => Algorithms
public class BubbleSort {
    public static void main(String[] args) {
        //          36 12 18 15 41 19
        // result : 12 15 18 19 36 41
        int[] arrBubble = new int[]{36, 12, 18, 15, 41, 19};
        int n = arrBubble.length;

        // 첫번째 원소와 인접한 원소를 비교하기
        // 두번째 원소와 세번째 원소를 비교하기
        // n - 1번째 원소와 n번째 원소를 비교하기

        // 반복 횟수를 나타내는 부분
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // 왼쪽 원소가 오른쪽 원소보다 클 경우 교환하기
                if (arrBubble[j] > arrBubble[j + 1]) {
                    // 교환하기
                    int temp = arrBubble[j];
                    arrBubble[j] = arrBubble[j + 1];
                    arrBubble[j + 1] = temp;
                }
            }
        }
        // BubbleSort Result
        System.out.println(Arrays.toString(arrBubble));
    }
}
