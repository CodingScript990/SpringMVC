package com.example.mvc.algorithms.dp;

// 피보나치 수열
public class Fibo {
    // n을 입력받고 n번째 피보나치 수열 출력
    private int fiboSimple(int n) {
        // k == 0, 1, 2
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        // F(K) == F(K - 1) + F(K - 2)
        return fiboSimple(n - 1) + fiboSimple(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(new Fibo().fiboSimple(10));
    }
}
