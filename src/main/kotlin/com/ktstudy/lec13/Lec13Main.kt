package com.ktstudy.lec13

// 코틀린에서 중첩 클래스를 다루는 방법
fun main() {

}

// java의 static 중첩 클래스 작성 (권장되는 클래스 안의 클래스)
/*
class JavaHouse(
    private val address: String,
    private val livingRoom: LivingRoom
){
    class LivingRoom(
        private val area: Double
    )
}*/

// 권장되지 않는 클래스 안의 클래스
class House(
    private val address: String,
    private val livingRoom: LivingRoom
){
    inner class LivingRoom(
        private val area: Double
    ) {
        val address: String
            get() = this@House.address
        // 바깥 클래스 참조를 위해 this@바깥클래스를 사용한다.
    }
}

// 기본적으로 바깥 클래스를 참조하지 않으며 바깥 클래스를 참조하고 싶다면 inner 키워드를 추가한다.