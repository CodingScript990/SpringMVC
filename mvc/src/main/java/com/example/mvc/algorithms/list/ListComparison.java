package com.example.mvc.algorithms.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListComparison {
    // ArrayList 와 LinkedList 의 성능비교 [목표]

    public static void main(String[] args) {
        // ArrayList instance
        List<Object> arrayList = new ArrayList<>();
        // LinkedList instance
        List<Object> linkedList = new LinkedList<>();

        // output => ArrayList, LinkedList
        System.out.println("--- ArrayList ---");

        ListComparison.rearInsert(arrayList);
        ListComparison.frontInsert(arrayList);
        ListComparison.getElements(arrayList);

        System.out.println("--- LinkedList ---");

        ListComparison.rearInsert(linkedList);
        ListComparison.frontInsert(linkedList);
        ListComparison.getElements(linkedList);
    }

    // 1. 10000개의 데이터를 리스트에 순차적으로 삽입
    // rearInsert method
    public static void rearInsert(List<Object> list) {
        // start value => nanoTime
        long start = System.nanoTime();
        // for statement => 10000 data add
        for (int i = 0; i < 10000; i++) {
            list.add("world");
        }
        // 실제 작업 end value => nanoTime
        long end = System.nanoTime();
        // output => 결과값 15d 자리수 만큼 표현
        System.out.println(String.format("순차적 추가 소요시간: %15d ns", end - start));
    }

    // 2. 10000개의 데이터를 리스트의 앞에 삽입
    // frontInsert method
    public static void frontInsert(List<Object> list) {
        // start value => nanoTime
        long start = System.nanoTime();
        // for statement => 0 번째 list 앞에 추가
        for (int i = 0; i < 10000; i++) {
            list.add(0, "hello");
        }
        // 실제 작업 end value => nanoTime
        long end = System.nanoTime();
        // output => 결과값 15d 자리수 만큼 표현
        System.out.println(String.format("앞쪽에 추가 소요시간: %15d ns", end - start));
    }

    // 3. 리스트의 모든 원소를 순서(idx)를 바탕으로 조회
    // getElements method
    public static void getElements(List<Object> list) {
        // start value => nanoTime
        long start = System.nanoTime();
        // for statement => Element size 만큼 확인
        for (int i = 0; i < list.size(); i++){
            list.get(i);
        }
        // 실제 작업 end value => nanoTime
        long end = System.nanoTime();
        // output => 결과값 15d 자리수 만큼 표현
        System.out.println(String.format("아이템 조회 소요시간: %15d ns", end - start));
    }
}
