package com.example.mvc.algorithms.BruteForce;

public class Combination {
    public static void main(String[] args) {
        System.out.println("------- n --------");
        int n = 5;
        // r == 3 이라 가정함
        // i는 0부터 n - 2까지 반복해야 나머지 두 숫자를 고를 수 있다
        for (int i = 0; i < n - 2; i++) { // 0 - 4에서 제일 큰 수 3개에서 제일 작은 수?
            // j도 최소한 하나의 숫자는 남겨둬야 나머지 한 숫자를 마저 고를 수 있다
            for (int j = i + 1; j < n - 1; j++) {
                // k는 선택할 수 있는 나머지 중 하나 선택
                for (int k = j + 1; k < n; k++) {
                    System.out.printf("%d %d %d\n", i, j, k); // 오름차순 정렬된 값이 출력됨
                }
            }
        }

        System.out.println("------- numbers --------");
        int[] numbers = new int[]{5,6,7,8,9};
        for (int i = 0; i < n - 2; i++) { // 0 - 4에서 제일 큰 수 3개에서 제일 작은 수?
            // j도 최소한 하나의 숫자는 남겨둬야 나머지 한 숫자를 마저 고를 수 있다
            for (int j = i + 1; j < n - 1; j++) {
                // k는 선택할 수 있는 나머지 중 하나 선택
                for (int k = j + 1; k < n; k++) {
                    System.out.printf("%d %d %d\n", numbers[i], numbers[j], numbers[k]); // 오름차순 정렬된 값이 출력됨
                }
            }
        }
    }
}
