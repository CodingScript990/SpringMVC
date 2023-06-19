package com.example.mvc.algorithms.queueEx;

// 선형 Queue
class MyQueueTest {
    public static void main(String[] args) {
        // 인스턴스화 => MyQueue 타입 intQueue 객체화[이용하기 위한 작업]
        MyQueue intQueue = new MyQueue();

        // 1,2,3 의 값을 넣어줌
        intQueue.enQueue(1);
        intQueue.enQueue(2);
        intQueue.enQueue(3);

        // output => 1,2,3 순으로 결과를 보여줌
        System.out.println("선형 Queue1 : " + intQueue.deQueue());
        System.out.println("선형 Queue2 : " + intQueue.deQueue());
        System.out.println("선형 Queue3 : " + intQueue.deQueue());

        // full 이상의 상태면 Error 가 나옴! => 원형 Queue 와 다른점을 보여주기 위함임
        intQueue.enQueue(4);
    }
}