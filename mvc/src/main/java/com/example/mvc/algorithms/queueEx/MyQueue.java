package com.example.mvc.algorithms.queueEx;

// 선형 Queue
public class MyQueue {
    // Member Field
    private final int[] arr = new int[4];
    // Queue 에서 data 꺼내는 위치
    private int front = -1;
    // Queue 에서 dat 추가하는 위치
    private int rear = -1;

    // Constructor
    public MyQueue() {}

    // Data Add => enQueue method
    public void enQueue(int x) { // parameter => x
        // if statement => rear + 1이 Array 의 크기만해질 때?
        if (rear == arr.length - 1) {
            // Queue 의 값이 full 로 있다면 RuntimeException 을 통해서 Queue 의 값이 full 이라고 알려줌
            throw new RuntimeException("Queue is full");
        }
        // 증감식 => rear 를 하나 증가시킴
        rear++;
        // 증감식 => arr[rear] 에 data 를 할당함
        arr[rear] = x;
    }

    // data 를 회수하는 작업
    public int deQueue() {
        // front == rear 일때 Queue 가 비어있음
        if (front == rear) {
            // 비어있다면 RuntimeException 을 통해서 Queue 가 비어있음을 알려줌
            throw new RuntimeException("Queue is empty");
        }

        // front 를 하나 증가시킴
        front++;
        // arr[front]의 값을 반환함
        return arr[front];
    }
    
    // Queue 가 비어있는지 확인하는 method
    public boolean isEmpty() {
        // front value 와 rear value 의 값을 비교
        // true 이면 값이 동일 => 동일한 크기이거나 둘다 빈 값이거나
        return front == rear;
    }

    // 다음에 나올 data 가 무엇인지 확인 (Queue 에서 빼내지 않음)
    public int peek() {
        // isEmpty 를 이용하여 data 의 값이 비어있는가 없는가를 판별하는 과정
        if (isEmpty()) {
            // 비어있다면 RuntimeException 을 통해서 Queue 가 비어있음을 알려줌
            throw new RuntimeException("Queue is empty");
        }
        // 비어있지 않다면 front + 1 의 값을 반환함
        return arr[front + 1];
    }
}
