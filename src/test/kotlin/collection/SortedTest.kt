package collection

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.collections.shouldBeSortedWith
import kotlin.math.abs

internal class SortedTest : AnnotationSpec() {

    val shuffled = listOf(5, 4, 2, 1, 3, -10)

    @Test
    fun `sorted - 오름차순 정렬된 리스트를 반환`() {
        val natural = shuffled.sorted()
        val descending = shuffled.sortedDescending()
        natural shouldBeSortedWith { a, b -> a - b }
        descending shouldBeSortedWith { a, b -> b - a }
    }

    @Test
    fun `sortedBy - 커스터마이징 하기`() {
        val inverted = shuffled.sortedBy { -it }
        val descending = shuffled.sortedByDescending { abs(it) }

        inverted shouldBeSortedWith { a, b -> -a - -b }
        descending shouldBeSortedWith { a, b -> abs(b) - abs(a) }
    }
}
