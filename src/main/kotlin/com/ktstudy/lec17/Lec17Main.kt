package com.ktstudy.lec17

import java.io.BufferedReader
import java.io.FileReader

// 람다를 다루는 방법
// java 에서 함수는 2급시민으로 취급되어
// 변수에 할당되거나 파라미터로 전달할 수 없다.
// 코틀린에서는 함수가 변수에 할당될수도 파라미터로 넘길 수도 있다.
fun main() {
    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_200),
        Fruit("사과", 1_200),
        Fruit("사과", 1_500),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 2_500),
        Fruit("수박", 10_000)
    )

    // 람다를 만드는 방법 1
    // 이름 없는 함수 = 람다
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    // 람다를 만드는 방법 2
    // 두번째 방법을 많이 사용하는듯?
    val isApple2: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" }
    // 함수의 타입
    // (파라미터 타입...) -> 반환타입
    // 명시 안해줘도 되긴 하는듯?
    // 람다를 직접 호출하는 방법
    isApple(fruits[0])
    isApple.invoke(fruits[0])


    filterFruits(fruits, isApple)
    filterFruits(fruits, fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    })

    filterFruits(fruits, isApple2)
//    filterFruits(fruits, { fruit: Fruit -> fruit.name == "사과" })
    // 마지막 파라미터가 함수인 경우, 소괄호 밖에 람다를 사용 가능하다.

//    filterFruits(fruits) { fruit: Fruit -> fruit.name == "사과" }
//    filterFruits(fruits) { fruit -> fruit.name == "사과" }
    // 파라미터가 하나면 it으로 지칭가능하다.
    // 그러나 it 보다는 지칭해서 시각적으로 알 수 있도록 하는게 좋다고 한다.
    // 코틀린에서는 함수가 1급 시민이다.

    // 람다는 여러줄 작성 가능하고
    // 마지막 줄의 결과가 람다의 반환값이다.
    filterFruits(fruits) { it.name == "사과" }


    // Closure
    // 자바는 람다에 final 변수만 사용 가능하지만
    // 코틀린에서는 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 가지고 있다.


}

private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
    val results = mutableListOf<Fruit>()

    for (fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }

    return results
}

// 4. try with resources
fun readFile(path: String) {
    BufferedReader(FileReader(path)).use {
        reader -> println(reader.readLine())
    }
}