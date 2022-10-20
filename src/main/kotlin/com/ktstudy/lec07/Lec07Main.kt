package com.ktstudy.lec07

fun main() {
    // try catch finally
    // 주어진 문자열을 정수로 변경하는 예제
}

fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt() // 타입이 to 뒤에 위치함
    } catch (e: NumberFormatException) { // new 를 사용하지 않음
        throw IllegalArgumentException("주어진 ${str}는 숫자가 아닙니다.")
    }
    // 포맷팅이 간결함
}

fun parseIntOrThrow2(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
    // 하나의 expression으로 간주되기 때문에
    // return 으로 반환 가능하다.
}

//Checked Exception Unchecked Exception
// FilePrinter 확인


// try with resources
// FilePrinter 확인
// use 라는 함수를 사용한다.