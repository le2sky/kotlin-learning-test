package collection

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class CountTest : AnnotationSpec() {

    @Test
    fun `count는 컬렉션요소의 총 수량을 구한다`() {
        val numbers = listOf(1, -2, 3, -4, 5, -6)
        val totalCount = numbers.count()
        val evenCount = numbers.count { it % 2 == 0 }

        totalCount shouldBe 6
        evenCount shouldBe 3
    }
}