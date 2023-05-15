package collection

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class FilterTest : AnnotationSpec() {

    @Test
    fun `filter function을 사용해서 컬렉션을 필터링 할 수 있다`() {
        val numbers = listOf(1, -2, 3, -4, 5, -6)
        val positives = numbers.filter { x -> x > 0 }
        val negatives = numbers.filter { it < 0 }
        positives.size shouldBe 3
        negatives.size shouldBe 3
    }
}