package com.ktstudy.lec18

val List<Fruit>.samePriceFilter: List<Fruit>
    get() = this.filter(Fruit::isSamePrice)

// 코틀린에서 컬렉션을 함수형으로 다루는 방법
fun main() {
    // 필터와 맵
    val fruits = listOf(
        Fruit(1,"사과", 1_000, 1_200),
        Fruit(2,"사과", 1_200, 1_500),
        Fruit(3,"사과", 1_200, 1_500),
        Fruit(4,"사과", 1_500, 1_700),
        Fruit(5,"바나나",  3_000, 3_200),
        Fruit(6,"바나나",  3_200, 3_500),
        Fruit(7,"바나나",  2_500, 2_900),
        Fruit(8,"수박", 10_000, 12_000)
    )

    // filter
    val apples = fruits.filter { fruit -> fruit.name == "사과" }

    // filter index
    val apples2 = fruits.filterIndexed { index, fruit ->
        println(index)
        fruit.name == "사과"
    }

    // map
    val apples3 = fruits.filter { fruit -> fruit.name == "사과" }
        .map{ fruit -> fruit.currentPrice }

    // map index
    val apples4 = apples.mapIndexed { index, fruit ->
        println(index)
        fruit.currentPrice
    }

    // map not null
    val apples5 = fruits.filter { fruit -> fruit.name == "사과" }
        .mapNotNull { fruit -> fruit.currentPrice }

    println(apples4)

    filterFruits(fruits) { fruit ->  fruit.name == "사과"}


    // 다양한 컬렉션 처리 기능
    // all : 조건을 모두 만족하면 true, 그렇지 않으면 false
    val isAllApple = fruits.all { fruit -> fruit.name == "사과" }

    // none : 조건을 모두 불만족하면 true, 그렇지 않으면 false
    val isNoApple = fruits.none { fruit -> fruit.name == "사과" }

    // any : 조건을 하나라도 만족하면 true, 그렇지 않으면 false
    val isAnyApple = fruits.any { fruit -> fruit.factoryPrice >= 10_000 }

    // count : 갯수를 센다 lise size()
    val fruitCount = fruits.count()

    // sortedBy : 기본 오름차순 정렬
    val fruitCount2 = fruits.sortedBy { fruit -> fruit.currentPrice }
    // sortedByDescending : 내림차순 정렬
    val fruitCount3 = fruits.sortedByDescending { fruit -> fruit.currentPrice }

    // distinctBy : 변형된 값을 기준으로 중복을 제거한다.
    // 아래 경우에는 이름을 기준으로 중복 제거
    val distinctFruitNames = fruits.distinctBy { fruit -> fruit.name }
        .map { fruit -> fruit.name }

    // first : 첫번째 값을 가져온다 (무조건 null이 아니어야함)
    // firstOrNull : 첫번째 값 또는 null을 가져온다
    fruits.first() // 만약 null이면 exception 발생
    fruits.firstOrNull()

    // last : 마지막 값을 가져온다 (무조건 null이 아니어야함)
    // lastOrNull : 마지막 값 또는 null을 가져온다
    fruits.last()
    fruits.lastOrNull()


    // 3. List to Map
    // 이름을 기준으로 그룹핑이 된다.
    val map: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }

    // id를 통해서 뭔가를 매핑해야할 때 중복되지 않는 키를 갖고 처리한다.
    val map2: Map<Long, Fruit> = fruits.associateBy { fruit -> fruit.id }

    // 과일 이름 기준 리스트 출고가 map이 필요하다
    val map3: Map<String, List<Long>> = fruits.groupBy(
        { fruit -> fruit.name }, { fruit -> fruit.factoryPrice })

    // id to 출고가
    val map4: Map<Long, Long> = fruits.associateBy(
        { fruit -> fruit.id }, { fruit -> fruit.factoryPrice }
    )

    // filter
    val map5: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
        .filter { (key, value) -> key == "사과" }


    // 중첩된 컬렉션 처리
    val fruitsInList: List<List<Fruit>> = listOf(
        listOf(
            Fruit(1L, "사과", 1_000, 1_500),
            Fruit(2L, "사과", 1_200, 1_500),
            Fruit(3L, "사과", 1_200, 1_500),
            Fruit(4L, "사과", 1_500, 1_500)
        ),
        listOf(
            Fruit(5L, "바나나", 3_000, 3_200),
            Fruit(6L, "바나나", 3_200, 3_200),
            Fruit(7L, "바나나", 2_500, 3_200),
        ),
        listOf(
            Fruit(8L, "수박", 10_000, 10_000),
        ),
    )

    // 출고가와 현재가가 동일한 과일
    val samePriceFruits = fruitsInList.flatMap { list ->
        list.filter { fruit -> fruit.factoryPrice == fruit.currentPrice }
    }

    // 개선한다면 samePrice 를 data class안에 만들고
    val samePriceFruits2 = fruitsInList.flatMap { list -> list.samePriceFilter }

    // 중복 리스트를 그냥 List로 바꿔주세요
    fruitsInList.flatten()
    // 평탄화 되는것이다.
}

private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
    return fruits.filter(filter)
}
