package com.ktstudy.lec03

// Type 다루기
fun main() {
    // 코틀린에서는 선언된 기본값을 보고 타입을 추론한다.
//    val number1 = 3 // Int
//    val number2 = 3L // Long
//    val number3 = 3.0f // Flot
//    val number4 = 3.0 // double

    // type 변환이 java 에서는 암시적으로 되지만 kotlin에서는 명시적으로 변환해줘야한다.
    val number1 = 4
//    val number2: Long = number1 // Type mismatch
    // 이런 문제가 있기 때문에
    // to~~() 변환 타입을 사용해야한다.
    val number2: Long = number1.toLong()

    // 나눌 때 실수의 결과를 얻고 싶을 때
    val number3 = 3
    val number4 = 5
    val result = number3 / number4.toDouble()

    println(result)


    // 변수에도 nullable 처리를 해야한다
    val number5: Int? = 3
    val number6: Long = number5?.toLong() ?: 0L

    printAgeIfPerson2(null)
    printAgeIfPerson2(Person("", 100))


    // Any -> java 의 Object 역할
    // primitive Type의 최상위 타입도 Any
    // Any 자체로는 null을 포함할 수 없어 null을 포함하고 싶다면 Any? 로 표현
    // Any에 equals / hashCode / toString 존재

    // Unit -> java void와 동일한 역할
    // void와 다르게 Unit은 그 자체로 타입 인자로 사용 가능하다.
    // 함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입을 의미
    // 즉, 코틀린의 Unit은 실제 존재하는 타입이라는 것을 표현한다.

    // Nothing 은 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
    // 무조건 예외를 반환한느 함수 / 무한 루프 함수 등


//    String interpolation / String indexing
    val person = Person("김김김", 100)
    val log = "사람의 이름은 ${person.name}이고 나이는 ${person.age}세 입니다."
    val name = "라라라"

    println(log)
    println("사람 이름은 $name")

    // $변수 를 쓸 수 있지만
    // 가독성, 일괄 변환, 정규식 활용하는데 편하기 위해서
    // ${변수} 를 사용하도록 하자~~~


    // 여러 줄 작성할 때
    val trim = """
        ㅇ라아아
        아루아루미
        미으랑ㄹ
        ${name}
    """.trimIndent()

    println(trim)

    // 문자열의 특정 문자 가져오기
    val str = "ABCDE"
    val ch = str[1]

    println(ch)
}

// 타입 캐스팅은 as 를 활용한다.
fun printAgeIfPerson(obj: Any) {
    if (obj is Person) {  // obj 가 Person 이면 true
//        val person = obj as Person
        // 꼭 타입 캐스팅을 하지 않아도 가능하다
        // 갓틀린이기 때문에
        // 스마트 캐스트가 가능하다.
        println(obj.age)
    }
    if (obj !is Person) {
        println("나는 person이 아니다")
    }
}

// null이 들어오는 경우에 이렇게 처리를 한다.
fun printAgeIfPerson2(obj: Any?) {
    val person = obj as? Person
    println(person?.age)
}