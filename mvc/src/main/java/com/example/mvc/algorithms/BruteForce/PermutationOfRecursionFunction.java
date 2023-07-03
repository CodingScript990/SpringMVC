package com.example.mvc.algorithms.BruteForce;

import java.util.Arrays;

// 재귀함수로 순열 생성
public class PermutationOfRecursionFunction {
    // permNumbers 메서드
    // n : 순열할 자연수의 수
    // r : 생성할 순열의 수
    // k : 현재 순열의 인덱스
    // perm : 현재 순열
    // used : 사용된 자연수를 나타내는 불리언 배열
    private void permNumbers(int n, int r, int k, int[] perm, boolean[] used) {
        // k의 값이 r의 값과 같은지를 확인합니다
        if (k == r) {
            // 동일하다면 perm 배열의 값을 콘솔에 출력합니다
            System.out.println(Arrays.toString(perm));
        } else { // k 변수 값이 r 의 값과 같지 않다면 실행합니다
            for (int i = 0; i < n; i++) { // i가 0부터 n-1까지 증가하면서 반복되는 것을 말합니다
                if (used[i]) continue; // used 배열의 i번째 요소가 true 이면 반복을 건너뜁니다
                perm[k] = i; // perm 배열의 k번째 요소를 i로 설정합니다
                used[i] = true; // used 배열의 i번째 요소를 true 로 설정합니다
                this.permNumbers(n, r, k + 1, perm, used); // permNumbers 함수는 재귀적으로 호출되는데, k+1번째 자연수를 순열에 추가하고, k+1을 새로운 k의 값으로 사용하여 순열을 생성하겠다는 의미입니다
                used[i] = false; // used 배열의 i번째 요소를 false 로 설정합니다
            }
        }
    }

    // permArray 메서드
    // numbers : 순열을 생성할 자연수의 배열
    // r : 생성할 순열의 수
    // k : 현재 순열의 인덱스
    // perm : 현재 생성되는 순열
    // used : 자연수의 사용 여부를 나타내는 불리언 배열
    private void permArray(int[] numbers, int r, int k, int[] perm, boolean[] used) {
        // k의 값이 r의 값과 같은지를 확인합니다
        if (k == r) {
            // 동일하다면 perm 배열의 값을 콘솔에 출력합니다
            System.out.println(Arrays.toString(perm));
        } else { // k 변수 값이 r 의 값과 같지 않다면 실행합니다
            for (int i = 0; i < numbers.length; i++) { // i가 0부터 numbers 배열의 길이 -1까지 증가시면서 반복되는 것을 말합니다
                if (used[i]) continue; // used 배열의 i번째 요소가 true 이면 반복을 건너뜁니다
                perm[k] = numbers[i]; // perm 배열의 k번째 요소를 numbers 배열의 i 번째로 설정합니다
                used[i] = true; // used 배열의 i번째 요소를 true 로 설정합니다
                this.permArray(numbers, r, k + 1, perm, used); // permArray 함수를 재귀적으로 호출하는데, numbers, r, k + 1번째 자연수를 순열에 추가하고 k + 1 을 새로운 k의 값으로 사용하여 순열을 생성하겠다는 의미입니다
                used[i] = false; // used 배열의 i번째 요소를 false 로 설정합니다
            }
        }
    }

    public static void main(String[] args) {
        PermutationOfRecursionFunction permutation = new PermutationOfRecursionFunction();


    }
}
