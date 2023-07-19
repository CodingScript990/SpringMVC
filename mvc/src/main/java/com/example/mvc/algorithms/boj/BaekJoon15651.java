package com.example.mvc.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N 과 M (3) => 중복 순열 구하기
public class BaekJoon15651 {

    private int n;
    private int m;
    // 실제로 만든 중복순열을 담기 위한 배열
    private int[] arr;
    // 정답을 저장함 StringBuilder
    private StringBuilder answer;

    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer infoToken = new StringTokenizer(reader.readLine());
        // n과 m 입력
        n = Integer.parseInt(infoToken.nextToken());
        m = Integer.parseInt(infoToken.nextToken());
        // 순열 저장용 배열 생성
        arr = new int[m];
        // 정답 저장용 StringBuilder 생성
        answer = new StringBuilder();

        // 재귀 시작
        dfs(0);

        System.out.println(answer);
    }

    // 몇 번째 숫자를 고르고 있느냐?
    // level : 0 ~ n-1
    private void dfs(int level) {
        if (level == m) {
            // 정답 저장
            for (int i = 0; i < m; i++) {
                // 입력이 되면 한칸 띄우기까지 추가함
                answer.append(arr[i]).append(' ');
            }
            // 입력완료되면 개행문자로 한줄 띄어줌
            answer.append('\n');
        }
        // 아직 남았음
        // 1 ~ n 까지 반복함
        else for (int i = 1; i < n + 1; i++) {
            // 이번 숫자로 i를 택함
            arr[level] = i;
            dfs(level + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        new BaekJoon15651().solution();
    }
}
