package com.example.mvc.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Moo 게임
public class BaekJoon5904 {

    public char solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받았다 가정
        int n = Integer.parseInt(reader.readLine());
        // 최초의 수열의 길이는 3
        int length = 3;
        // 목표는 반복해서 수열을 만들어 length 가 n 보다 커지게 만들면서 length 가 moo 수열의 길이 만한 값으로 유지되기

        // reps == k
        int reps = 0;

        // while 무의 조건도 동일하게 가져감
        while (length < n) {
            // 처음 만드는 수열은 S(1) 이니 증가시키고 시작함
            reps++;
            // len(S(k - 1)) * 2 + ((k + 2) * 'o' + 'm')
            length = length * 2 + (reps + 3);
//            System.out.println(length);
        }
        // 인덱스 기준으로 찾을거니, n 의 값을 사전 조정 해줌
        n--;
        // reps(k)와 length 의 정보가 있다면, moo 수열의 구역을 3단위로 나눌 수 있다
        // 좌우대칭 앞과 뒤 + reps + 3 으로 이뤄진 moo...0 가운데, 구간에 n이 위치한다면 정확하게 어떤 글자인지 판달 할 수 있다
        // 반복해서 가운데에 위치할 때까지 진행됨
        while (true) {
            // 먼저 가운데 인덳의 위치를 찾음
            int midIdx = (length - (reps + 3)) / 2;
            // 그리고 끝 구간의 시작 인덱스를 찾는다
            // 가운데 시작 인덱스 부터 가운데 구간 길이 합
            int lastIdx = (length - (reps + 3)) / 2 + (reps + 3);
            // 만약 n == midIdx 라면, 가운데 구간의 시작
            // 구간의 시작이면 m 이다
            if (n == midIdx) return 'm';
            // 시작은 아니지만, 가운데 구간이면 'o' 다
            else if (midIdx < n && n < lastIdx) return 'o';
            // 아니라면, 길이를 줄여서 다시 풀어봄
            else if (n >= lastIdx) {
                // 버리는 길이만큼 n 과 length 초점
                n -= lastIdx;
                length -= lastIdx;
            } else {
                // 가운데 구간의 길이와
                length -= reps + 3;
                // 가운데 구간까지의 길이를 둘다 뺌
                length -= midIdx;
                // n 은 조정 불필요
            }
            reps--;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new BaekJoon5904().solution());
    }
}
