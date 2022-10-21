package com.ktstudy.lec10

// 상속 받을때에는 : 한칸 띄우고 붙여준다
class Cat(
    species: String
) : Animal(species, 4) { // 상위 클래스의 생성자를 바로 호출해야한다. 필수!!
    // override 는 지시어로 사용한다. 자바처럼 어노테이션이 아님
    override fun move() {
        println("고양이가 사뿐 사뿐 걸어가~")
    }
}