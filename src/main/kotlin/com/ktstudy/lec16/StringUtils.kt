package com.ktstudy.lec16

import com.sun.org.apache.xpath.internal.operations.Bool

// 1. 확장함수
// java 코드위에 자연스럽게 코틀린 코드를 붙이는 방법?
// 클래스 안에 있는 메소드처럼 호출할 수 있지만, 함수는 밖에 만드는 것
fun main() {
    val str = "ABC"
    println(str.lastChar())

    val person = Person("A", "B", 100)
    person.nextYearAge()

    val train: Train = Train()
    train.isExpensive() // Train의 확장함수

    val srt1: Train = Srt()
    srt1.isExpensive() // Train의 확장함수

    val srt2: Srt = Srt()
    srt2.isExpensive() // Srt의 확장함수

    // 해당 변수의 현재 타입
    // 즉, 정적인 타입에 의해 어떤 확장함수가 호출될지 결정된다.
}

// 확장하려는클래스.함수이름 ~~~
// this를 이용해 실제 클래스 안의 값에 접근
// this -> 수신객체
// 확장하려는클래스 -> 수신객체 타입
// 확장함수는 클래스에 있는 private, protected 멤버를 가져올 수 없다.
fun String.lastChar(): Char {
    return this[this.length - 1] // 문자열을 가져올 때 [] 를 사용한다.
}

// 멤버함수와 확장함수의 시그니처가 같다면?
// 멤버함수가 우선적으로 호출된다.
// 그렇기 때문에 지금은 멤버함수가 없더라도 나중에 멤버함수가 생기면 오류가 발생할 수도 있다.
fun Person.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}

// 어떤게 먼저 불릴까?
open class Train(
    val name: String = "새마을기차",
    val price: Int = 5_000
)

fun Train.isExpensive(): Boolean {
    println("Train의 확장함수")
    return this.price >= 10000
}

class Srt : Train("SRT", 40_000)

fun Srt.isExpensive(): Boolean {
    println("Srt의 확장함수")
    return this.price >= 10000
}

// 확장 프로퍼티는
// 확장함수 + custom getter와 동일하다
val String.lastChar: Char
    get() = this[this.length - 1]