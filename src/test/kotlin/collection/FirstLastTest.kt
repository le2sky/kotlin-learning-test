package collection

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

internal class FirstLastTest : AnnotationSpec() {

    @Test
    fun `first, last - 요소 하나를 반환하는데, 조건을 줄 수 있다`() {
        val numbers = listOf(1, -2, 3, -4, 5, -6)
        val first = numbers.first()
        val last = numbers.last()
        first shouldBe 1
        last shouldBe -6

        val firstEven = numbers.first { it % 2 == 0 }
        val lastOdd = numbers.last { it % 2 != 0 }
        firstEven shouldBe -2
        lastOdd shouldBe 5

        val words = emptyList<String>()
        shouldThrow<NoSuchElementException> {
            words.first()
        }
    }

    @Test
    fun `firstOrNull, lastOrNull - 존재하지 않으면 null을 반환한다`() {
        val empty = emptyList<String>()
        val first = empty.firstOrNull()
        first.isNullOrEmpty().shouldBeTrue()
    }
}