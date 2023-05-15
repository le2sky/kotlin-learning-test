package collection

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class FlatMapTest : AnnotationSpec() {

    @Test
    fun `flatMap은 단일 리스트로 결과를 반환한다`() {
        val fruitsBag = listOf("apple", "orange", "banana", "grapes")
        val clothesBag = listOf("shirts", "pants", "jeans")
        val cart = listOf(fruitsBag, clothesBag)
        val mapBag = cart.map { it }
        val flatMapBag = cart.flatMap { it }

        mapBag.size shouldBe 2
        flatMapBag.size shouldBe (fruitsBag.size + clothesBag.size)
    }
}