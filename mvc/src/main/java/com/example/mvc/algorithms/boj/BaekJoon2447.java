package com.example.mvc.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 별찍기
public class BaekJoon2447 {
    private char[][] starboard; // char type 2차원 배열
    public void solution() throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        starboard = new char[n][n]; // n X n 배열
        // starboard 의 각 줄이 반환
        for (char[] row : starboard) {
            Arrays.fill(row, ' ');
        }
        setStar(n, 0, 0);
        StringBuilder drawStar = new StringBuilder();
        for (int i = 0; i < n; i++) {
            drawStar.append(starboard[i]).append('\n'); // 문자열을 한줄씩 추가 그리고 줄바꿈
        }
        // output
        System.out.println(drawStar.toString());
    }

    // 정보 3가지 => setStar method
    public void setStar(int n, int x, int y) {
        // n == 3 이라면 실제로 별을 그리기 시작
        if (n == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // 가운데 지점에서는 별을 skip 하기
                    if (i == 1 && j == 1) continue;
                    starboard[y + i][x + j] = '*'; // * 별찍기
                }
            }
        }
        // 아니라면 n == 3 일때까지 재귀호출
        else {
            int offset = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // 가운데 삭가형이면 굳이 재귀호출을 하지 않음
                    if (i == 1 && j == 1) continue;
                    setStar(offset, x + offset * i, y + offset * j); // 재귀호출
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new BaekJoon2447().solution();
    }
}
