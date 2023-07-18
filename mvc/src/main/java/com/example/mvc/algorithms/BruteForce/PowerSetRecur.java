package com.example.mvc.algorithms.BruteForce;

import java.util.Arrays;

// 재귀함수로 부분집합 구하기
// Recur -> Recursive
public class PowerSetRecur {
    public static void main(String[] args) {
        int[] set = new int[]{2,3,5};
        new PowerSetRecur().powerSet(set, 0, new int[set.length]);
    }

    int targetSum = 10;
    public void powerSet(
            int[] set,
            // next 번째 원소를 선택할지 말지를 의미
            int next,
            int[] select) {
        // 재귀함수
        int sum = 0;
        for (int i = 0; i < next; i++) {
            if (select[i] == 1) sum += set[i];
        }
        if (sum > targetSum) return;

        // next 가 원소의 갯수가 되면 종료함
        if (next == set.length) {
            // select 배열을 보고 출력함
            for (int i = 0; i < set.length; i++) {
                if (select[i] == 1) System.out.print(set[i] + " ");
            }
            System.out.println(Arrays.toString(select));
        } else {
            // 내것 고르지 않고 다음
            select[next] = 0;
            powerSet(set, next + 1, select);

            // 내것 고르고 다음
            select[next] = 1;
            powerSet(set, next + 1, select);
        }
    }
}
