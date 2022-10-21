package com.ktstudy.lec20

import com.ktstudy.lec03.Person

// scope funciton
// 일시적인 영역을 형성하는 함수
// 코드를 간결하게 만든다.
fun main() {

    // let, run : 람다의 결과
    // also, apply : 객체 그 자체
    // with
    // this : 생략이 가능한 대신, 다른 이름을 붙일 수 없다.
    // it : 생략이 불가능한 대신, 다른 이름을 붙일 수 있다.

    val person = Person("홍길동", 30)

    val value1 = person.let { // age
        it.age
    } // 일반 함수를 받는다.
    // 파라미터를 내부에서 직접 호출하기 때문에 it 사용함.

    val value2 = person.run { // age
        this.age
    } // 확장 함수를 받는다.
    // 확장함수에서는 본인 자신을 this로 호출하고 생략할 수 있었다.

    val value3 = person.also { // person
        it.age
    }

    val value4 = person.apply { // person
        this.age
    }

    with(person) {
        println(name)
        println(this.age)
    }
}

fun printPerson(person: Person) {
    // safe call을 이용해 person이 null이 아닐때
    // let : scope function의 한 종류
    person?.let {
        println(it.name)
        println(it.age)
    }
/*
    if (person != null) {
        println(person.name)
        println(person.age)
    }*/
}