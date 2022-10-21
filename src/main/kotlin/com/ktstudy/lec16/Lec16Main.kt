package com.ktstudy.lec16

// 다양한 함수를 다루는 방법
fun main() {
    // 1. 확장함수
    // java 코드위에 자연스럽게 코틀린 코드를 붙이는 방법?
    // 클래스 안에 있는 메소드처럼 호출할 수 있지만, 함수는 밖에 만드는 것

    3.add(4)

    3.add2(4)
    3 add2 4

    3.add3(4)
}

// 2. infix 함수
// 함수를 호출하는 새로운 방법 6강 참조
// 변수.함수이름(arg) 대신
// 변수 함수이름 arg
// 멤버함수에도 붙일 수 있다.
fun Int.add(other: Int): Int {
    return this + other
}

infix fun Int.add2(other: Int): Int {
    return this + other
}

// 3. inline 함수
// 함수가 호출되는 대신 호출한 지점에 함수 전체를 복사하는 함수
// 함수를 파라미터로 전달할 때에 오버헤드를 줄일 수 있다.
inline fun Int.add3(other: Int): Int {
    return this + other
}

// 4. 지역함수
// 함수안에 함수를 선언한다.
// 이 함수를 지금 함수내에서만 쓰고 싶을때?
// depth가 깊어지기도 하고 이런 코드가 깔끔하진 않다.
// 실무에서는 잘 안쓴다.
fun createPerson(firstName: String, lastName: String): Person {
/*
    if (firstName.isEmpty()) {
        throw IllegalArgumentException("firstName은 비어있을 수 없습니다! 현재 값 : $firstName")
    }

    if (lastName.isEmpty()) {
        throw IllegalArgumentException("lastName은 비어있을 수 없습니다! 현재 값 : $lastName")
    }
    */
    fun validateName(name: String, fieldName: String) {
        if(name.isEmpty()) {
            throw IllegalArgumentException("${fieldName}은 비어있을 수 없습니다! 현재 값 : $name")
        }
    }

    validateName(firstName, "firstName")
    validateName(lastName, "lastName")

    return Person(firstName, lastName, 1)
}