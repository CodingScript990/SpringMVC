package com.example.mvc.algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 회의실 배정 => 백준 문제
public class BaekJoon176962 {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int meetingCount = Integer.parseInt(reader.readLine());
        int[][] meetings = new int[meetingCount][2];
        for (int i = 0; i < meetingCount; i++) {
            // 입력받아주는 작업
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            // 두가지 정수형 받아주는 작업
            meetings[i][0] = Integer.parseInt(tokenizer.nextToken());
            meetings[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        // Arrays.sort : 배열을 정렬해주는 작업
        // Comparator : 두 객체를 비교하고 그 관계를 나타내는 정수를 반환하는 함수
        // comparingInt : 두 정수의 값을 비교해주는 함수
        // 회의 정보를 종료시간 기준으로 정렬함
        // 종료시간이 같으면, 시작시간을 기준으로 정렬함
        // 비교하는 방법을 함수(Arrays.sort)를 사용하여 인자(o1, o2)로 결과물 표현!
        Arrays.sort(meetings,
                //Comparator.comparingInt(o -> o[1])
                (o1, o2) -> { // 익명함수[Object1, Object2]
                    // o1 : {시작시간, 종료시간}
                    // o2 : {시작시간, 종료시간}

                    // 종료시간이 다르면 종료시간 기준 비교
                    // o1[1] 이 o2[1] 과 다르면 o1[1] - o2[1] 의 값을 반환해줘라!
                    if (o1[1] != o2[1]) return o1[1] - o2[1]; // [종료시간을 반환]

                    // 아니라면 시작 시간 기준 비교
                    return o1[0] - o2[0]; // [시작시간을 반환]
                }
        );

        // 답안을 저장하기 위한 용도
        int answer = 0;
        // 마지막 종료시간을 저장하기 위한 용도
        int lastEnd = 0;

        for (int i = 0; i < meetingCount; i++) {
            // i번째 미팅이 선택이 가능한지 판단하기 위해 i번째 미팅의 i번째 미팅의 시작시간과
            // 현재의 lastEnd 를 비교함
            if (meetings[i][0] >= lastEnd) {
                answer++;
                lastEnd = meetings[i][1];
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new BaekJoon176962().solution());
    }
}
