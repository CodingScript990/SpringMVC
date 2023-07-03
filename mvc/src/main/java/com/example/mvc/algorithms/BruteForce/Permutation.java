package com.example.mvc.algorithms.BruteForce;

public class Permutation {
    public static void main(String[] args) {
        System.out.println("--- 3! ---");
        // 0 - 2 까지 3개의 숫자가 있다 => 3! [6]
        // 겹치지 않도록 3개를 골라 나열한 모든 경우의 수를 출력해보기
        // 1. 첫번째 숫자를 for 반복으로 구함
        for (int i = 0; i < 3; i++) { // i가 고른 첫번째 숫자
            // 2. 두번째 숫자를 for 반복문으로 구함
            for (int j = 0; j < 3; j++) { // j가 고른 두번째 숫자
                // 만약 이미 고른 숫자라면 스킵
                if (i == j) continue;
                // 3. 세번째 숫자를 for 반복문으로 구함
                for (int k = 0; k < 3; k++) { // k가 고른 세번째 숫자
                    // 만약 이미 고른 숫자라면 스킵
                    if (k == i || k == j) continue;
                    System.out.printf("%d %d %d\n", i, j, k);
                }
            }
        }
        System.out.println("--- 5! ---");
        // 0 - 4 사이 숫자 중 3개를 골라 나열해보기 => 5! [120]
        // 겹치지 않도록 3개를 골라 나열한 모든 경우의 수를 출력해보기
        // 1. 첫번째 숫자를 for 반복으로 구함
        for (int i = 0; i < 5; i++) { // i가 고른 첫번째 숫자
            // 2. 두번째 숫자를 for 반복문으로 구함
            for (int j = 0; j < 5; j++) { // j가 고른 두번째 숫자
                // 만약 이미 고른 숫자라면 스킵
                if (i == j) continue;
                // 3. 세번째 숫자를 for 반복문으로 구함
                for (int k = 0; k < 5; k++) { // k가 고른 세번째 숫자
                    // 만약 이미 고른 숫자라면 스킵
                    if (k == i || k == j) continue;
                    System.out.printf("%d %d %d\n", i, j, k);
                }
            }
        }
        System.out.println("--- 순열 ---");
        // 5개의 숫자를 담은 int[] 에서 3개를 골라 나열하기
        int[] numbers = new int[]{10, 12, 14, 16, 18};
        // 겹치지 않도록 3개를 골라 나열한 모든 경우의 수를 출력해보기
        // 1. 첫번째 숫자를 for 반복으로 구함
        for (int i = 0; i < numbers.length; i++) { // i가 고른 첫번째 숫자
            // 2. 두번째 숫자를 for 반복문으로 구함
            for (int j = 0; j < numbers.length; j++) { // j가 고른 두번째 숫자
                // 만약 이미 고른 숫자라면 스킵
                if (i == j) continue;
                // 3. 세번째 숫자를 for 반복문으로 구함
                for (int k = 0; k < numbers.length; k++) { // k가 고른 세번째 숫자
                    // 만약 이미 고른 숫자라면 스킵
                    if (k == i || k == j) continue;
                    System.out.printf("%d %d %d\n", numbers[i], numbers[j], numbers[k]);
                }
            }
        }
        System.out.println("--- 재귀함수 ---");
        // 숫자 야구 용 순열 생성기 => 재귀함수
        for (int i = 1; i < 10; i++) { // 1부터 9까지
            for (int j = 1; j < 10; j++) {
                if (i == j) continue;
                for (int k = 1; k < 10; k++) {
                    if (k == i || k == j) continue;
                    System.out.printf("%d %d %d\n", i, j, k);
                }
            }
        }
    }
}
