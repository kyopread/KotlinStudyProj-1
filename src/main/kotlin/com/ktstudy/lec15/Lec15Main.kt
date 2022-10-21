package com.ktstudy.lec15

// 코틀린에서 배열과 컬렉션을 다루는 방법
fun main() {
// 1. 배열
    val array = arrayOf(100, 200)

    // indices를 이용한 방법
    for (i in array.indices) {
        println("${i} ${array[i]}")
    }

    array.plus(300) // 편하게 추가할 수 있다.

    // withIndex활용 index, value 한번에 받는 방법
    for ((idx, value) in array.withIndex()) {
        println("$idx $value")
    }


    // 2. Collection
    // 가변 (Mutable) 컬렉션 : 컬렉션에 element를 추가, 삭제할 수 있다.
    // 불변 컬렉션 : 컬렉션에 element를 추가, 삭제할 수 없다.

    // Collection을 만들자마자 Collections.unmodifiableList() 등을 붙여주는거처럼
    // 불변 컬렉션이라 하더라도
    // Reference Type인 Element의 필드는 바꿀 수 있다.
    // ex) 첫번째 요소의 가격을 바꾼다던지의 행위..

    // collection - List
    val numbers = listOf(100, 200)
    val emptyList = emptyList<Int>() // 비어있는 리스트의 경우엔 타입을 명시해주어야한다.
    // 그렇지만 타입이 추론 가능하면 명시해주지 않아도 된다.
    printNumbers(emptyList())


    numbers.get(0)
    numbers[0] // 편하게 가져올 수 있다.

    for (number in numbers) {
        println(number)
    }

    for((idx, value) in numbers.withIndex()) {
        println("$idx $value")
    }

    // 가변 리스트
    // ArrayList 기본 구현체
    // 우선 불변 리스트를 만들고, 꼭 필요한 경우 가변 리스트로 바꾸자!
    val numbers2 = mutableListOf(100, 200)
    numbers2.add(300)

    // collection - Set
    // 집합은 List와 다르게 순서가 없고
    // 같은 element는 하나만 존재할 수 있다.
    val sets = setOf(100, 200)
    // 기본적인 구현체는 LinkedHashSet
    val mutSet = mutableSetOf(100, 200)
    mutSet.add(300)

    // collection - Map
    val oldMap = mutableMapOf<Int, String>()
    oldMap.put(1, "Monday")
    oldMap[1] = "Monday"

    // to를 활용하여 중의 호출 가능
    mapOf(1 to "Monday", 2 to "Tuesday")

    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries) {
        println(key)
        println(value)
    }

    // 컬렉션의 null 가능성, Java와 함께 사용하기
    // List<Int?> : 리스트에 null이 들어갈 수 있지만, 리스트는 절대 null이 아님
    // List<Int>? : 리스트에는 null이 들어갈 수 없지만, 리스트는 null일 수 있음
    // List<Int?>? : 리스트에 null이 들어갈 수도 있고, 리스트가 null일 수도 있음
    // java 에서는 읽기전용과 변경 가능을 구분하지 않는다.
    // kotlin에서 불변객체를 java에서 가져온담에 element 추가하고 반환 시 오동작 가능성
    // java 는 nullable 타입과 non-nullable 타입을 구분하지 않는다.
    // 이런 분제를 해결하려면 java 에 호출될 시 컬렉션 내용이 변할 수 있음을 감안하고
    // 방어코드를 작성한다.
    // 아니라면 코틀린쪽에서 Collections.unmodifableXXX()를 활용하면 변경 자체를 막을 수 있다!
    // java 코드를 가져오는 지점을 wrapping 하여서 영향 범위를 최소화한다.
}

private fun printNumbers(numbers: List<Int>) {

}