package collection

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class MappingTest : AnnotationSpec() {

    @Test
    fun `map 확장 함수를 이용해서 요소를 변환 시킬 수 있다`() {
        val numbers = listOf(1, -2, 3, -4, 5, -6)
        val doubled = numbers.map { x -> x * 2 }
        val tripled = numbers.map { it * 3 }

        numbers.sum() shouldBe doubled.sum() / 2
        numbers.sum() shouldBe tripled.sum() / 3
    }
}