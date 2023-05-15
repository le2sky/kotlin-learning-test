package collection

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class FindTest : AnnotationSpec() {

    @Test
    fun `find, find Last - 매치되는 첫번째 요소를 반환한다`() {
        val words = listOf("Lets", "find", "something", "in", "collection", "somehow")
        (words.find { it.startsWith("some") }) shouldBe "something"
        (words.findLast { it.startsWith("some") }) shouldBe "somehow"
    }
}