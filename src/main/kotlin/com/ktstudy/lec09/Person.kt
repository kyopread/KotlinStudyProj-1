package com.ktstudy.lec09

// public 생략 가능
//class Person constructor(name: String, age: Int) {
// constructor 생략 가능
// 필드도 생략 가능
/*class Person (name: String, age: Int) {
    val name = name
    var age = age
}*/

// getter, setter는 자동으로 생성해준다.

// 최종 생략 버전
/*class Person (
    val name: String,
    var age: Int)*/

class Person (
    val name: String,
    var age: Int) { // 주 생성자 - 반드시 존재해야한다. 만약 하나도 없으면 명시하지 않아도 기본으로 만들어줌.

/*    val name = name
        get() = field.uppercase()*/
    // 4. backing field
    // 이것이 생긴 이유는  custom getter를 쓰면서인데
    // 만약, get() = name 이라면
    // 외부에서 name 호출 시 getter가 호출되게 되는데
    // get에는 name이 있고 name 은 get이 되고
    // 무한루프가 발생하기 때문에
    // 이를 막기 위한 예약어, 자기 자신을 가리키는 것으로
    // field를 쓴다.
    // 이러한 필드를 보이지 않는 필드 backing field

//    fun getUppercaseName(): String = this.name.uppercase()

//    val uppercaseName: String
//        get() = this.name.uppercase()

//    custom setter
/*    var name = name
        set(value) {
            field = value.uppercase()
        }*/

    // 무분별한 setter를 지양하기 때문에 잘 안쓴다.


    init { // 생성자가 생성되는 시점에 호출되는 초기화 블록
        // 값을 적절히 셋팅하거나 validation하는 로직을 넣는다.
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }

        println("초기화 블록")
    }

    // 추가 생성자
    constructor(name: String): this(name, 1) {
        println("첫번째 부생성자")
    }
    // body 를 만들수도 있다.
    // 부생성자에서 또 부생성자를 호출할수도 있다.
    constructor(age: Int): this("ddd", age)
    constructor(): this("홍시")

    // 코틀린에서는 default parameter를 권장한다.
    // Converting과 같은 경우 부생성자를 사용할 수 있지만
    // 웬만하면 정적 팩토리 메서드를 활용한다.

    // 함수처럼 만들기도 하고
/*    fun isAdult(): Boolean {
        return this.age >= 20
    }*/

    // 프로퍼티 처럼 만들기도 한다.
    // get() = 대신에 {} 을 사용하기도 한다.
    val isAdult: Boolean
        get() = this.age >= 20
    // 객체에 대한 속성을 확인하는 용도라면 custom getter가 활용되는 프로퍼티처럼 보이도록 한다.
    // 아니라면 함수로 구현하는 방법으로
}

fun main() {
    val person = Person("김김김", 100)

    println(person.name)
    person.age = 10
    println(person.age)
    // setter, getter .필드명 을 통해 사용한다.
    // 이는 java 클래스를 가져다 쓸 때에도 동일하게 동작한다.

    val preson2 = Person("나하나")
    val preson3 = Person(age = 1)
}