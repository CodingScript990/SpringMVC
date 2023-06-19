package com.example.mvc.algorithms.postifix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// Reverse Polish Notation -> Postfix Notation
// 후위 표기법
public class PostfixCalculation {

    // solution method
    public void solution() throws IOException {
        // 입력 처리
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받기
        String input = reader.readLine();
        // Stack 형태 Integer type
        Stack<Integer> digitStack = new Stack<>();

        // for statement
        for (int i = 0; i < input.length(); i++) {
            // token char type
            char token = input.charAt(i);

            // 1. 숫자라면, Stack 에 push 한다
            // Character.isDigit(token) // token 의 숫자가 표현된 글자인지 판단하는 Method
            // Token 을 int 로 변환 => token - '0'
            if (Character.isDigit(token)) { // token 의 숫자가 표현된 글자인지 판단하는 Method
                // 숫자니깐 변환 후 push
                digitStack.push(Character.digit(token, 10));
            }

            // 2. 숫자가 아니라면,
            else {
                // (연산자) Stack 에서 2번 pop 하고 계산한다
                int numRight = digitStack.pop();
                int numLeft = digitStack.pop();

                // switch statement
                switch (token) {
                    case '+' -> digitStack.push(numLeft + numRight);
                    case '-' -> digitStack.push(numLeft - numRight);
                    case '*' -> digitStack.push(numLeft * numRight);
                    case '/' -> digitStack.push(numLeft / numRight);
                    default -> throw new IllegalArgumentException("invalid operator");
                }
            }
        }
        // 마지막 연산 결과
//        System.out.println(digitStack.pop());
        // answer value => pop[Result Value == last value]
        int answer = digitStack.pop();
        // if statement => true 이면 answer
        if(digitStack.empty())
            System.out.println(answer);
        // else statement => false 이면 error message
        else System.out.println("error");
    }
    public static void main(String[] args) throws IOException {
        new PostfixCalculation().solution();
    }
}
