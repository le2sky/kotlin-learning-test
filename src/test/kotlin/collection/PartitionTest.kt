package collection

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class PartitionTest : AnnotationSpec() {

    @Test
    fun `partition은 리스트 pair로 컬렉션을 쪼갠다`() {
        val numbers = listOf(1, -2, 3, -4, 5, -6)
        val evenOdd = numbers.partition { it % 2 == 0 }
        val (positives, negatives) = numbers.partition { it > 0 }

        evenOdd.first.size shouldBe 3
        evenOdd.second.size shouldBe 3
        positives.size shouldBe 3
        negatives.size shouldBe 3
    }
}