package com.ktstudy.lec04

// 코틀린에서 연산자를 다루는 방법

fun main() {

    // 단항 연산자 / 산술 연산자 -> java 와 동일하다
    val money1 = JavaMoney(2_000L)
    val money2 = JavaMoney(1_000L)

    if (money1 > money2) { // 비교 할 때 자동으로 compareTo를 호출한다.
        println("Money1이 Money2보다 금액이 큽니다.")
    }

    // 비교 연산자와 동등성, 동일성
    // 동등성 : 두 객체의 값이 같은가
    // 동일성 : 완전히 동일한 객체인가?! 즉 주소가 같은가 ?!
    // java 동일성 == 동등성 equals
    // kotlin 동일성 === 동등성 ==
    // ==를 사용하면 간접적으로 equals를 호출해준다.

    val money3 = JavaMoney(1_000L)
    val money4 = money1
    val money5 = JavaMoney(1_000L)

    println(money3 === money4)
    println(money3 === money5)
    println(money3 == money5)

    // 논리 연산자 java 와 완전히 동일하다
    // java 처럼 Lazy 연산을 수행한다.

    // 앞에가 true 라면 앞에 함수만 실행하고 if문 내부로 진행된다.
    // fun1() 만 실행
    if (fun1() || fun2()) {
        println("본문")
    }

    // fun1() 만 실행 어차피 false 라 필요 없으니까
    if (fun2() && fun1()) {
        println("본문")
    }


    // 논리 연산자와 코틀린에 있는 특이한 연산자
    // in / !in
    // 컬렉션이나 범위에 포함되어 있다, 포함되어 있지 않다.
    // println(1 in numbers)

    // a..b
    // a부터 b 까지의 범위 객체를 생성한다~~

    // a[i]
    // a에서 특정 index i로 값을 가져온다.
    // a[i] = b 값을 넣기



    // 연산자 오버로딩
    // kotlin에서는 객체마다 연산자를 직접 지정할 수 있다.
    // data class 에 operator를 이용하여 연산자 선언함.
    val money6 = Money(1_000L)
    val money7 = Money(2_000L)

    println(money6 + money7)



}

fun fun1(): Boolean {
    println("fun 1")
    return true
}

fun fun2(): Boolean {
    println("fun 2")
    return false
}