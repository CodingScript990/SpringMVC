package com.example.mvc.algorithms.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AdjacentMatrix {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer : 입력받은 문자열을 ' ' (또는 지정된 delimiter)를 기준으로 나눠서 한 단어씩 반환해주는 도구임
        StringTokenizer graphTokenizer = new StringTokenizer(reader.readLine()); // 8 10
        // StringTokenizer.nextToken : 다음 단어를 가져오기
        int maxNodes = Integer.parseInt(graphTokenizer.nextToken()); // 8
        int edges = Integer.parseInt(graphTokenizer.nextToken());    // 10

        // 인접행렬 표현 => 2차원 배열
        // 만약 노드가 1부터 N + 1 까지라면, 계산할때 매번 -1을 해주거나 인접 행렬을 한번 더 늘리거나
        int[][] adjMatrix = new int[maxNodes][maxNodes]; // 0 - 7까지 표현가능한 인접 행렬
        // for statement => edges length[간선의 갯수만큼 반복해서 입력을 받는 작업]
        for (int i = 0; i < edges; i++) {
            // 다음줄을 단어 단위로 나눠주는 Tokenizer 임
            StringTokenizer edgeTokenizer = new StringTokenizer(reader.readLine());
            // 입력 줄의 첫 번째 숫자
            int startNode = Integer.parseInt(edgeTokenizer.nextToken());
            // 입력 줄의 두번째 숫자
            int endNode = Integer.parseInt(edgeTokenizer.nextToken());
            // 유향 그래프의 경우 아래줄만[34번째]
            adjMatrix[startNode][endNode] = 1;
            // 무향 그래프의 경우 아래줄도 함께
            adjMatrix[endNode][startNode] = 1;
        }
        for (int[] row : adjMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    // main method
    public static void main(String[] args) throws IOException {
        new AdjacentMatrix().solution();
    }
}
/*
8 10
0 1
0 2
0 3
1 3
1 4
2 5
3 4
4 7
5 6
6 7
// 10개의 줄에 걸쳐서 간신의 연결한 정점들 (간선 정보)
 */
