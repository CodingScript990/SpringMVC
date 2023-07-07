package com.example.mvc.algorithms.sort;

import java.util.Arrays;

// SelectionSortRecursive => Sort[재귀함수]
public class SelectionSortRecursive {
    public static void main(String[] args) {
        // 25 12 18 24 2 21
        // result : 2 12 18 21 24 25
        int[] arrSelection = new int[]{25, 12, 18, 24, 2, 21};
        new SelectionSortRecursive().sort(arrSelection, 0);
        // SelectionSort Result
        System.out.println(Arrays.toString(arrSelection));
    }
    // 재귀함수
    private void sort(int[] arr, int start) {
        // 모든 원소를 확인함
        if (!(start < arr.length)) return;
        // 제일 앞에 원소를 현재 제일 작다고 설정
        int minIdx = 0;
        // start + 1부터 끝 원소까지 차근차근 비교함
        for (int i = minIdx; i < arr.length; i++) {
            // 제일 작은 숫자를 찾음
            if (arr[i] < arr[minIdx]) minIdx = i;
        }

        // 제일 앞의 원소와 제일 작은 원소를 교환함
        int temp = arr[0];
        arr[0] = arr[minIdx];
        arr[minIdx] = temp;

        // 남은 영역에 대해서 똑같은 작업을 진행함
        sort(arr, start + 1);
    }
}
