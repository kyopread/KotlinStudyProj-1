package com.ktstudy.lec10

class Penguin(
    species: String
) : Animal(species, 2), Swimable, Flyable {
    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직인다~ 꿱꿲")
    }

    // 상속받은 get을 custom getter로 바꿈
    override val legCount: Int
        get() = super.legCount + this.wingCount

    // java 와 코틀린 모두 추상 클래스는 인스턴스화 할 수 없다.
    // 인터페이스도 마찬가지다.

    // 중복되는 인터페이스를 특정할 때 super<타입>.함수 사용한다.
    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }

    override fun fly() {
        TODO("Not yet implemented")
    }

    override val swimAbility: Int
        get() = 3
}