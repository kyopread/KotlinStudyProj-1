package com.ktstudy.lec05

fun main() {

}

// if문
fun validateScoreIsNotNegative(score: Int) {  // 함수에서 Unit(void)가 생략됨
    if (score < 0) {
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.") // new 생략됨
    }
}

// Expression & Statement
// Statement : 프로그램의 문장, 하나의 값으로 도출되지 않는다.
// Expression : 하나의 값으로 도출되는 문장
// java에서 if-else는 Statement이지만
// Kotlin에서는 Expression입니다.
// 그렇기 때문에 return 도 가능하고 삼항 연산자가 필요없다.
fun getPassOrFail(score: Int): String {
    return if (score >= 50) {
        "P"
    } else {
        "F"
    }
}

fun getGrade(score: Int): String {
    return if (score >= 90) {
        "A"
    } else if (score >= 80) {
        "B"
    } else if (score >= 70) {
        "C"
    } else {
        "D"
    }
}

// java -> if(0 <= score && score <= 100)

// kotlin -> if(score in 0..100)

fun validateScoreIsNotNegative2(score: Int) {  // 함수에서 Unit(void)가 생략됨
    if (score  !in 0..100) {
        throw IllegalArgumentException("score의 범위는 0부터 100입니다.") // new 생략됨
    }

    if (score  in 0..100) {
        // 1 ~ 100 에 포함되는
    }
}

// switch와 when
fun getGradeWithSwitch(score: Int): String {
    return when (score / 10) { // switch 대신
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
}

fun getGradeWithSwitch2(score: Int): String {
    return when (score) { // switch 대신
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

// when 에는 어떤 조건이라도 들어갈 수 있다.
fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

// 동시에 여러개도 체크 할 수 있다.
fun judgeNumber(number: Int) {
    when (number) {
        1, 0, -1 -> println("어디서 많이 본 숫자입니다.")
        else -> println("1, 0, -1이 아닙니다.")
    }
}

fun judgeNumber2(number: Int) {
    when {
        number == 0 -> println("주어진 숫자는 0입니다.")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어지는 숫자는 홀수입니다.")
    }
}