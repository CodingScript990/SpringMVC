package com.example.mvc.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

// LottoService => Service
@Service
public class LottoService {
    // Member Field
    private int hits = 0;

    private final List<List<Integer>> history = new ArrayList<>();

    // 누군가가 방문했을 때 호출하는 메서드
    // addHit method
    public int addHit() {
        hits++;
        return hits;
    }

    // lotto method 만들기
    public List<Integer> nextWinningNumber() {
        List<Integer> winningNums = new ArrayList<>();
        RandomGenerator generator = new Random();

        for (int i = 0; i < 6; i++) {
            winningNums.add(generator.nextInt(1, 6));
        }

        history.add(winningNums);

        return winningNums;
    }
}
