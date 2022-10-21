package com.ktstudy.lec12

// 코틀린에서 object 키워드를 다루는 방법

fun main() {
    Person.newBaby("아앙아")

    // companion object에 이름이 없다면.
//    Person.Companion.newBaby("AAA")

    // newBaby 위에 @JvmStatic 이라는 어노테이션을 붙이면
    // Person.newBaby("RER")
    // 가능하다.

    Person.Factory.newBaby("hahaha")

    println(Singleton.a)
    Singleton.a += 10
    println(Singleton.a)

    moveSomething(object : Movable { // 익명 클래스
        // java 에서는 new 타입이름()
        // kotlin 에서는 object : 타입이름
        override fun move() {
            println("무브 무브")
        }

        override fun fly() {
            println("날다 날다")
        }

    })
}

class Person private constructor(
    var name: String,
    var age: Int
) {
    // 동행 객체 static 대신
    // static : 클래스가 인스턴스화 될 때 새로운 값이 복제되는게 아니라
    // 정적으로 인스턴스끼리의 값을 공유
    // companion object : 클래스와 동행하는 유일한 오브젝트
    // 이 객체에 이름도 붙이고, 인터페이스도 구현 가능하다.
    companion object Factory : Log{
        private const val MIN_AGE = 1
        // const 컴파일 시 변수가 할당된다.
        // 일반 val 일 경우 런타임에 할당된다.
        // 진짜 상수라는 의미인데 기본 타입과 String에 붙일 수 있다.
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("나는 Person 클래스의 동행객체 Factory에요.")
        }
    }
}

// 싱글톤
// object Singleton 끝 간단하다.
object Singleton {
    var a: Int = 0
}

// 익명 클래스
// 인터페이스나 클래스를 상속받은 구현체를 일회성으로 사용하는 클래스
private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}