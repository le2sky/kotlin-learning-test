package collection

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class ZipTest : AnnotationSpec() {

    val A = listOf("a", "b", "c")
    val B = listOf(1, 2, 3, 4)

    @Test
    fun `기본값으로 같은 인덱스의 값들로 pair를 만든다`() {
        val resultPairs = A zip B
        resultPairs[2].first shouldBe "c"
        resultPairs[2].second shouldBe 3
    }

    @Test
    fun `쌍을 만들지 못하면 버린다`() {
        val resultPairs = A zip B
        resultPairs.size shouldBe 3
    }

    @Test
    fun `커스터 마이징 가능`() {
        val resultReduce = A.zip(B) { a, b -> "$a$b" }
        resultReduce[2] shouldBe "c3"
    }
}