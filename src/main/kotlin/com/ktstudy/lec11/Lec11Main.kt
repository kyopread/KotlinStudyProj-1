package com.ktstudy.lec11

// 코틀린에서 접근 제어를 다루는 방법
// public : 모든 곳에서 접근 가능
// protected : 선언된 클래스 또는 하위 클래스에서만 접근 가능
// internal : 같은 모듈에서만 접근 가능 (자바 default 사라짐)
// private : 선언된 클래스 내에서만 접근 가능
// 모듈 : 한 번에 컴파일 되는 kotlin 코드
// 코틀린으로 호출한 컴파일 파일의 집합

// java의 기본 접근 지시어는 default
// kotlin의 기본 접근 지시어는 public

// .kt 파일내에 여러개의 함수, 변수, 클래스를 만들 수 있다.
val a = 3

fun add(a: Int, b: Int): Int {
    return a + b
}

private val number = 3

// 코틀린 파일에서의 접근 제어
// public : 기본값이다. 어디서든 접근할 수 있다.
// protected : 파일(최상단)에는 사용 불가능하다.
// 선정된 클래스 혹은 하위 클래스에서 작동하는 것인데
// 클래스가 아닌 파일이기 때문에 사용 못함
// internal : 같은 모듈에서만 접근 가능
// private : 같은 파일 내에서만 접근 가능


// 클래스에서 접근 지시어를 붙이는 방법
// constructor를 명시해줘야한다.
class Cat private constructor(

)


// 프로퍼티에 접근 제어 하는 방법
class Car(
    internal val name: String,
    private var owner: String,
    _price: Int
) {
    var price = _price // 현재 getter 는 publice 이다
        private set // setter에만 가시성을 부여하여 따로 설정한다.
}

// 4. java 와 kotline을 함께 사용할 때 주의할
// internal은 바이트 코드 상 public이 된다.
// 때문에 Java코드에서는 kotlin모듈의 internal코드를 가져올 수 있다.

// kotlin의 protected와 java의 protected는 다르다.
// java는 같은 패키지의 protected에 접근 할 수 있다.