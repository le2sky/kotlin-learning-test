package functional

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class ExtensionTest : AnnotationSpec() {
    data class Item(val name: String, val price: Float)
    data class Order(val items: Collection<Item>)

    // local에서는 안되나봄
    val Order.commaDelimitedItemNames: String
        get() = items.joinToString { it.name }

    @Test
    fun `코틀린은 extensions 메커니즘으로 모든 클래스에 새로운 맴버를 추가할 수 있도록 한다`() {
        // 확장 함수와 확장 프로퍼티는 확장 타입을 지정해야한다는 점에서 일반 함수와 일반 프로퍼티와는 다르다
        fun Order.maxPricedItemValue(): Float = this.items.maxByOrNull { it.price }?.price ?: 0F
        fun Order.maxPricedItemName() = this.items.maxByOrNull { it.price }?.name ?: "NO_PRODUCTS"

        val order = Order(listOf(Item("A", 21.0F), Item("B", 29.0F)))
        order.maxPricedItemValue() shouldBe 29.0F
        order.maxPricedItemName() shouldBe "B"
        order.commaDelimitedItemNames shouldBe "A, B"
    }
}