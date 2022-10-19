package com.ktstudy.lec02

fun main() {
    // null 다루기

    // Safe Call
    // null이 아니면 실행하고, null이면 실행하지 않는다 (그대로 null)
    val str: String? = "ABC"
//    val str: String? = null // 그냥 null로 출력해버림
//    str.length // 불가능
    str?.length // 가능

    println(str?.length)

    // Elvis 연산자
    // 앞의 연산 결과가 null이면 뒤의 값을 사용
    // 오른쪽 90도 회전하면 ㅋㅋ 엘비스 프레슬리 헤어스타일과 닮아서 그렇게 불림
    println(str?.length ?: 0)

    println(startWith("ABC"))

    println("------------------------------------------------------------")
//    println(startWith(null)) // runtime 시 Exception 발생
    // 그렇기 때문에 진짜 null 아닐때 확실할 때 !! 사용해야합니다.

    val person = Person("나는 개발자")
//    val person = Person(null) // annotation이 없을 경우 런타임 에서 nullpoint exception 발생한다.
    // 그렇기 때문에
    println(startsWithA(person.name))

    // kotlin 코드에서 에서 자바의 코드를 가져다 쓸 때에는 @NotNull, @Nullable 등등의 어노테이션 정보를 이해한다.
    // javax.annotation , android.support.annotation , org.jetbrains.annotation package 등등
}

// kotlin에서는 null이 가능한 타입을 완전히 다르게 취급한다.
fun startsWithA1(str: String?): Boolean {
    // 한줄로 해결해버림.. 자바의 삼항 연산자가 유사하다 생각되긴 하는데 좀 더 직관적인거같다.
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null이 들어왔습니다.")

/*    if (str == null) {
        throw IllegalArgumentException("null이 들어왔습니다.")
    }

    return str.startsWith("A")*/
}

fun startsWithA2(str: String?): Boolean? {
    // str 이 null이면 null 그대로 반환하고
    // null이 아니면 boolean 값 반환하기 때문에 여기까지만 하면 된다.
    return str?.startsWith("A")

/*    if (str == null) {
        return null
    }
    return str.startsWith("A")*/
}

// 코틀린의 경우 문맥상 위에서 null을 체크한다면 다음 호출 시 null이 아닐거라고 판단해준다.
fun startsWithA3(str: String?): Boolean {
    return str?.startsWith("A") ?: false

    /*if (str == null) {
        return false
    }

    return str.startsWith("A")*/
}

// Elvis 연산은 early return 에도 사용할 수 있다.
fun calculate(number: Long?): Long {
    number ?: return 0

    return 1
}

// null 아님 단언 !! 이렇게 표현한다.
// 파라미터에는 safe call 을 명시하여 nullable 한 상태가 되어 null에 대한 처리가 필요하지만
// str 이 null이 아님을 !! 단언 해줌으로써 null에 대한 별도의 처리가 필요하지 않다.
fun startWith(str: String?): Boolean {
    return str!!.startsWith("A")
}

fun startsWithA(str: String): Boolean {
    return str.startsWith("A")
}