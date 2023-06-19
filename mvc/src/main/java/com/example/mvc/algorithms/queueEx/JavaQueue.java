package com.example.mvc.algorithms.queueEx;

import java.util.LinkedList;
import java.util.Queue;

public class JavaQueue {
    public static void main(String[] args) {
        
        // 인스턴스화 => LinkedList
        Queue<Integer> queue = new LinkedList<>();
        
        // enQueue
        // offer, add - enQueue 에 해당하는 method
        // Queue 가 가득 차있다면?
        // offer - false 를 반환함, add - 예외를 발생시킴
        queue.offer(1);
        queue.add(1);

        // deQueue
        // remove, poll - deQueue 에 해당하는 method
        // Queue 가 비어있다면?
        // poll - null 을 반환, remove - 예외를 발생시킴
        System.out.println("Queue Remove : " + queue.remove());
        System.out.println("Queue Poll : " + queue.poll());

        // peek
        // element, peek - peek 에 해당되는 method
        // Queue 가 비어있다면?
        // peek - null 을 반환하고, element - 예외를 발생시킴
        System.out.println("Queue Peek : " + queue.peek());
        System.out.println("Queue Element : " + queue.element());
    }
}
