package com.example.mvc.algorithms.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AdjacentList {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer: 입력받은 문자열을 ' ' (또는 지정된 delimiter) 를 기준으로 나누어서
        // 한 단어씩 반환해주는 도구
        StringTokenizer graphTokenizer = new StringTokenizer(reader.readLine()); // 8 10
        // StringTokenizer.nextToken(): 다음 단어를 가져오기
        int maxNodes = Integer.parseInt(graphTokenizer.nextToken());  // 8
        int edges = Integer.parseInt(graphTokenizer.nextToken());     // 10

        // List type adjList object add
        // 안쪽의 List<Integer> 가 maxNodes 의 길이를 반드시 가지지는 않을 것임
        List<List<Integer>> adjList = new ArrayList<>();

        // 먼저 list 의 내용물을 초기화 해줌 => List 형태로 반환받고 시작!
        for (int i = 0; i < maxNodes; i++) {
            adjList.add(new ArrayList<>());
        }

        // 간선의 갯수만큼 반복해서 입력을 받는다.
        for (int i = 0; i < edges; i++) {
            // 다음줄을 단어 단위로 나눠주는 Tokenizer
            StringTokenizer edgeTokenizer = new StringTokenizer(reader.readLine());
            // 입력 줄의 첫 숫자
            int startNode = Integer.parseInt(edgeTokenizer.nextToken());
            // 입력 줄의 두번째 숫자
            int endNode = Integer.parseInt(edgeTokenizer.nextToken());
            // adjList 의 startNode 번째 List 에 endNode 를 첨부함
            // 유향 그래프일 경우 아래 줄만
            adjList.get(startNode).add(endNode);
            // 무향 그래프의 경우 아래줄도 함께
            adjList.get(endNode).add(startNode);
        }
        // 선택사항 : DFS 나 BFS 를 할때 방문순서를 작은 숫자부터 와 같은 조건을 붙이고 싶을 때 정렬해야함
        for(List<Integer> adRow : adjList) {
            // 정렬해주는 Collections.sort method
            Collections.sort(adRow);
        }
        // output : List type
        for (List<Integer> adjRow : adjList) {
            System.out.println(adjRow);
        }
    }

    // main method
    public static void main(String[] args) throws IOException {
        new AdjacentList().solution();
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
