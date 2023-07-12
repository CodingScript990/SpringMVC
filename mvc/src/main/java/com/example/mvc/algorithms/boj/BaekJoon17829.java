package com.example.mvc.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 풀링
public class BaekJoon17829 {
    private int[][] matrix; // 2차원 배열

    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        matrix = new int[n][n]; // n X n 을 받아온다는 의미
        for (int i = 0; i < n; i++) {
            StringTokenizer row = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(row.nextToken()); // 한줄의 정보를 바꿔주는 역할
            }
        }
        return pooling(n, 0, 0);
    }

    // pooling method
    public int pooling(int n, int x, int y) { // 범위를 한정시켜서 해야지 시간복잡도에서 유리함
        // 재귀호출하지 않고 계산한 결과를 반환
        if (n == 2) {
            // 4가지 시점
            int[] four = new int[] {
                    matrix[y][x],
                    matrix[y + 1][x],
                    matrix[y][x + 1],
                    matrix[y + 1][x + 1]
            };
            // 4가지 시점을 받고 (배열로)정렬함
            Arrays.sort(four);
            return four[2];
        }
        // 재귀호출 후 그 결과를 수집 후 자신의 결과로 반환
        else {
            int half = n / 2;
            int[] four = new int[] {
                    pooling(half, x, y),
                    pooling(half, x + half, y),
                    pooling(half, x, y + half),
                    pooling(half, x + half, y + half)
            };
            Arrays.sort(four);
            return four[2];
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new BaekJoon17829().solution());
    }
}
