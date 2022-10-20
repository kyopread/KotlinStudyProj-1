package com.ktstudy.lec08

import sun.rmi.rmic.iiop.StaticStringsHash

fun main() {
    // default parameter에 따라 나머지 파라미터를 넣지 않더라도 호출 가능하다.
    repeat("Hello World")

    // named argument
    repeat("Hi World", useNewLine = false)
    // builder를 만들지 않고도 builder의 장점을 가지게 된다.

    printNameAndGender(gender = "FEMALE", name = "가가가")
    // 다만 kotlin에서 java 함수를 가져다 쓸 때에는 named argument를 활용할 수 없다.
    // jvm에서 java가 바이트 코드로 변환 됐을 때 파라미터 이름을 가지고 있지 않기 때문에 못씀.


    // 같은 타입의 여러 파라미터 받기
    printAll("A", "B", "C")

    val array = arrayOf("A", "B", "C")
    // spread 연산자 - 배열에 있는 것들을 , 로 꺼내준다 구분해준다
    printAll(*array)
}

fun max(a: Int, b: Int) = if (a > b) a else b

// = 을 쓰게 되면 return type 도 생략 가능하다
// {} 을 쓴다면 명시적으로 타입을 작성해야한다.


// default parameter
// 주어진 문자열을 N번 출력하는 예제
fun repeat(
    str: String,
    num: Int = 3,
    useNewLine: Boolean = true
) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}


// 같은 타입의 여러 파라미터 받기
fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}