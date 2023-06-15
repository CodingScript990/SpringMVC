package com.example.mvc.algorithms.string;

public class IntegerToAlpha {

    public String itoa(int value) {
        StringBuilder answerBuilder = new StringBuilder();
        // 음수인지 확인을 위한 negative 변수
        boolean negative = false;
        // 음수라면 양수로 바꿔주고 negative 를 true 로 바꿔준다
        if (value < 0) {
            negative = true;
            value *= -1;
        }

        // TODO value 가 0보다 큰 동안
        while (value > 0) {
            // char type value => value % 10 에 아스키코드 '0'을 더해줌
            char digitChar = (char)(value % 10 + '0');
            // TODO value 를 10으로 나눈 나머지를 문자로 변환
            answerBuilder.append(digitChar);
            // TODO value 나누기 10
            value /= 10;
        }

        // 음수라면 - 기호를 붙여준다
        if (negative) answerBuilder.append('-');
        // 역순으로 리턴해준다
        return answerBuilder.reverse().toString();
    }

    // main method
    public static void main(String[] args) {
        IntegerToAlpha itoa = new IntegerToAlpha();
        System.out.println(itoa.itoa(1234) + itoa.itoa(56789));
        System.out.println(itoa.itoa(1234) + itoa.itoa(-56789));
    }
}
