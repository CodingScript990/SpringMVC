package com.example.mvc.algorithms.dp;

// 피보나치 수열
public class FiboTab {
    // n을 입력받고 n번째 피보나치 수열 출력
    private int fiboSimple(int n) {
        // k == 0, 1, 2
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        // F(K) == F(K - 1) + F(K - 2)
        return fiboSimple(n - 1) + fiboSimple(n - 2);
    }

    // 외부에서 호출하기 위한 메서드[기록용도]
    public int fiboMemo(int n) {
        return fiboMemoRe(n, new int[n + 1]);
    }

    // Memoization method
    private int fiboMemoRe(int n, int[] memo) {
        // k == 0, 1, 2
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        // F(K) == F(K - 1) + F(K - 2)
        // 만약에 이미 구해본 결과가 있다면 memo 에 저장이 되어 있음
        // 그것을 확인함
        else if (memo[n] == 0) { // 만약 아직 있다면?
            // 이번에 구해서 기록하기
            memo[n] = fiboMemoRe(n - 1, memo) + fiboMemoRe(n - 2, memo);
        }
        // memo[n] 이 있다면, 해당 값이 지금 구하고 있는 n 번째 피보나치 수열 값
        return memo[n];
    }

    // fiboTab method => 기록 결과물을 바로 출력
    public int fiboTab(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // 계산 결과 기록용 배열
        int[] fib = new int[n + 1];
        // 알고 있는 결과는 미리 기록
        fib[1] = 1;
        fib[2] = 1;

        for (int i = 3; i <= n; i++) {
            // 피보나치 수열 구하기
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        // fib[n] 만큼의 결과 값을 반환함
        return fib[n];
    }

    public static void main(String[] args) {
        FiboTab memo = new FiboTab();
        int n = 20;
        // fiboSimple 계산
        long start = System.nanoTime();
        System.out.println("simple");
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            // 0 부터 20까지 피보나치 수열
            builder.append(memo.fiboSimple(i)).append(' ');
        }
        System.out.println(builder);
        System.out.println(System.nanoTime() - start);
        System.out.println();

        // fiboMemo 계산
        start = System.nanoTime();
        System.out.println("memo");
        builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(memo.fiboMemo(i)).append(' ');
        }
        System.out.println(builder);
        System.out.println(System.nanoTime() - start);
        System.out.println();

        // fibTab 계산
        start = System.nanoTime();
        System.out.println("fibTab");
        builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(memo.fiboTab(i)).append(' ');
        }
        System.out.println(builder);
        System.out.println(System.nanoTime() - start);
        System.out.println();
    }
}
