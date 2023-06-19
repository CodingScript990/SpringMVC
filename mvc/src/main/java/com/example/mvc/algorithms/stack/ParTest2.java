package com.example.mvc.algorithms.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParTest2 {
    public boolean solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine(); // 괄호 입력 받는 부분
        Stack<Character> charStack = new Stack<>();// Stack 형태 Character type, charStack 참조변수

        // 소괄호, 중괄호, 대괄호를 이루어진 수식을 검사하는 코드를 작성하시오.
        for (int i = 0; i < input.length(); i++) {

            char next = input.charAt(i);

            // 1. 여는 소괄호를 만날때 push
            if (next == '(' || next == '{' || next == '[') {
                charStack.push(next);
            }
            // 2. 닫는 소괄호를 만날때 pop
            else if (next == ')' || next == '}' || next == ']') {
                // pop 할게 없으면 검사 실패를 한다
                if (charStack.empty()) return false;

                // 아니라면 pop을 한다
                char top = charStack.pop();

                // pop의 결과로 나온 값이 올바른 여는 괄호인지 확인한다
                // 들오온건 닫는 소괄호 && top은 여는 소괄호가 아닐 때 실패한다
                if (next == ')' && top != '(') return false; // 소괄호
                else if (next == '}' && top != '{') return false; // 중괄호
                else if (next == ']' && top != '[') return false; // 대괄호
            }
        }
        // 순회가 끝났다면 Stack이 비었는지 확인해준다
        return charStack.empty();
    }

    // main method => test
    public static void main(String[] args) throws IOException {
        System.out.println(new ParTest2().solution());
    }
}
