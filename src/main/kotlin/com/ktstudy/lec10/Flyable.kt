package com.ktstudy.lec10

interface Flyable {

    // default를 쓰지 않고도 default 함수를 만들 수 있다.
    fun act() {
        println("파닥 파닥")
    }

    fun fly() // 추상 메서드가 된다.
}