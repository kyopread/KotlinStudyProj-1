package com.ktstudy.lec14

// 코틀린에서 다양한 클래스를 다루는 방법
// data class
// enum class
// Sealed Class, Sealed Interface
fun main() {
    val dto1 = PersonDto(name="홍길동", 100)
    val dto2 = PersonDto("홍길동", 200)
    println(dto1 == dto2)

    println(dto1)
}

data class PersonDto(
    val name: String,
    val age: Int,
)
// data 키워드를 붙여주면 equals, hashCode, toString을 자동으로 만들어준다.
// 생성자에 named argument 까지 사용가능하다.
// 사실상 builder 까지도 사용 가능한 것
// java에서는 jdk16부터 kotlin의 data class 같은 record class를 도입했다.


// Enum Class
enum class Country(
    private val code: String
){
    KOREA("KO"),
    AMERICA("US"),
    JAPAN("JP")
    ;
}

// when과 사용할 때 진가를 발휘한다.
fun handleCountry(country: Country) {
    when (country) { // enum class에 새로운 값이 추가되면 추가되지 않은 값이 있다고 알려준다. return 하는 경우~~
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
        // else -> TODO() 추가적으로 작성해줄 필요가 없다.
    }
}


// Sealed Class, Sealed Interface
// 상속이 가능하도록 추상클래스를 만드는데
// 외부에서는 이 클래스를 상속받지 않도록 구현
// 하위 클래스를 봉인하는 방법!!
// 컴파일 타임 때 하위 클래스의 타입을 모두 기억하고
// 즉, 런타임때 클래스 타입이 추가될 수 없다.
// 하위 클래스는 같은 패키지에 있어야하며
// Enum과 다른점으로는
// 클래스를 상속받을 수 있다.
// 하위 클래스는 멀티 인스턴스가 가능하다.
// 추상화가 필요한 Entity or DTO 에 활용할 수 있다.
// jdk17에서도 Sealed Class가 추가되었다.
sealed class HyundaiCar(
    val name: String,
    val price: Long
)

class Avante : HyundaiCar("아반떼", 1_000L)
class Sonata : HyundaiCar("소나타", 2_000L)
class Grandeur : HyundaiCar("그렌저", 3_000L)

private fun handleCar(car: HyundaiCar) {
    when (car) { // sealed class 타입을 확인하고 when에서 처리한다.
        // sealed class에 추가가 되어도 확인 가능하다.
        is Avante -> TODO()
        is Grandeur -> TODO()
        is Sonata -> TODO()
    }
}