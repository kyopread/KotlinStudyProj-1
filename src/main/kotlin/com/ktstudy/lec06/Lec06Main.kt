package com.ktstudy.lec06

fun main() {
    // for each
    val numbers = listOf(1L, 2L, 3L)
    for (number in numbers) { // in 뒤의 것은 iterable이 구현된 타입이라면 모두 들어갈 수 있다.
        println(number)
    }

    for (i in 1..3) {
        println(i)
    }

    // 내려가는 경우
    for (i in 3 downTo 1) {
        println(i)
    }
    // 시작 값 : 3 , 끝 값 : 1 , 공차 : -1

    // 2칸씩 올라가는 경우
    for (i in 1..5 step 2) {
        println(i)
    }
    // 시작 값 : 1 , 끝 값 : 5 , 공차 : 2
    // step , dewnTo 는 함수이다.

    // .. 연산자 : 범위를 만들어내는 연산자
    // 범위 Range 클래스가 있는데
    // 이는 Progression (등차수열) 을 상속받고 있는 클래스다.
    // 등차수열은 시작 값, 끝 값, 공차 세가지의 변수가 필요한데
    // 이를 받아서 처리하는 것

    // 원래는 변수.함수(arg) 이런식으로 되지만
    // 변수 함수 arg 이렇게도 활용 가능하다.


    // while
    // java 와 똑같다
    var i = 1
    while (i <= 3) {
        println(i)
        i++
    }
}

