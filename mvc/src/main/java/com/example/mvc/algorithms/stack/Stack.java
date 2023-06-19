package com.example.mvc.algorithms.stack;

// Stack
public class Stack {
    // Stack에 실제 Data가 지정되는 곳[Field]
    private final int[] arr = new int[16]; // final : 주소를 바꿀 수 있는가 없는가, 어디서 시작되는가를 말하는 것
    // 현재 Statck의 최고점 파악하기 위한 top[Field]
    private int top = -1;
    // Empty Constructor
    public Stack() { }

    // push : Data를 Stack의 제일 위에 넣는 Method
    public void push(int data) {
        // 0. arr가 가득 찾는지를 판단한다
        if (arr.length - 1 == top) {
            throw new RuntimeException("Stack is full");
        }

        // 1. top을 하나 증가 시킵니다.
        top++;

        // 2. arr[top]를 할당한다.
        arr[top] = data;

        // 3. Done!
        // arr[++top] = data;
    }

    // pop : Data를 Stack의 제일 위에서 회수하는 Method
    public int pop() {
        // 0. Arr가 비어있는지 판단합니다 [기준 => top]
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }

        // 1. Arr[top]의 값을 반환합니다
        int  temp = arr[top];

        // 2. top의 값을 하나 감소합니다
        top--;

        // 3. Return temporary value
        return temp;

        // 4. Done!
        // return arr[top--];
    }

    // Peek : Return the top of stack without removing
    // without removing => do not change too
    public int peek() {
        // 0. Check if stack not empty
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }

        // 1. return arr top
        return arr[top];
    }

    // Empty : Check if stack is empty
    public boolean empty() {
        // stack is empty when top == -1
        return top == -1;
    }

    // main method => Test
    public static void main(String[] args) {
        // Stack 3개의 Data를 넣었다가 빼보기
        Stack stack = new Stack();

        // push
        stack.push(3);
        stack.push(5);
        stack.push(7);

        // stack => 3(0), 5(1), 7(2)
        System.out.printf("Stack Pop : %d\n", stack.pop());
        System.out.printf("Stack Pop : %d\n", stack.pop());
        System.out.printf("Stack Empty : %b\n", stack.empty());
        System.out.printf("Stack Peek : %d\n", stack.peek());
        System.out.printf("Stack Pop : %d\n", stack.pop());
    }
}
