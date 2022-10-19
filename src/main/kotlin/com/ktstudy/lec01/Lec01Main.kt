package com.ktstudy.lec01

fun main() {

//    kt 에서는 타입을 컴파일러가 추론해서 적용해준다
//    var number1 = 10L // 바꿀 수 있는 변수

    var number1: Long = 10L
    number1 = 5L

    val number2 = 10L // 바꿀 수 없는 변수
    // number2 = 5L 빨간줄 뜬다 수정 불가능


    var number3: Long
    number3 = 5
    println(number3) // 값이 초기화 전에 프린트 하려하면 밑줄 에러 발생


    val number4: Long
    number4 = 5  // 아직 초기화 하지 않았기 때문에 초기화 가능하다. 단 딱 첫번째에만 가능
    println(number4)

    // 간단한 TIP
    // 모든 변수는 우선 val로 만들고 꼭 필요한 경우 var로 변경한다.



    var number5 = 10L
    var number6 = 1_000L

    // java 에서 연산 시 reference type 대신 primitive type을 사용해야하는데
    // boxing unboxing이 일어나면서 성능상 문제가 발생할 수 있다.

    // 하지만 우리 갓틀린은 프로그래머가 boxing, unboxing을 고려하지 않아도 되도록 kotlin이 알아서 처리 해준다.

    // 숫자, 문자, 불리언과 같은 몇몇 타입은 내부적으로 특별한 표현을 갖는다.
    // 이 타입들은 실행시에 Primitive Value로 표현되지만, 코드에서는 평범한 클래스 처럼 보인다.


    // nullable 변수
    var number7 = 10L

    var number8 = 1_000L
//    number8 = null // 기본적으로는 모든 타입에 null이 들어갈 수 없도록 한다.

    // null을 넣고 싶다면 ?

    var number9: Long? = 1_000L
    number9 = null


    var person = Person("교래")
}