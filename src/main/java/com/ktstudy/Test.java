package com.ktstudy;

public class Test {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        long tot = 0L;
        for (long i = 0; i < 100000000; i++) {
            tot += i;
        }

        System.out.println("진행 시간 : " + (System.currentTimeMillis() - time) + "ms");
    }
}
