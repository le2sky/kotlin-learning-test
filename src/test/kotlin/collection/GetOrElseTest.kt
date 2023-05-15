package collection

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class GetOrElseTest : AnnotationSpec() {

    @Test
    fun `list의 인덱스 범위 초과시 기본값 설정 가능`() {
        val list = listOf(0, 10, 20)
        val actual1 = list.getOrElse(1) { it }
        val actual2 = list.getOrElse(10) { it * 2 }
        actual1 shouldBe 10
        actual2 shouldBe 20
    }

    @Test
    fun `map에도 적용 가능`() {
        val map = mutableMapOf<String, Int?>()
        val actual1 = map.getOrElse("x") { 1 }
        actual1 shouldBe 1

        map["x"] = 3
        val actual2 = map.getOrElse("x") { 1 }
        actual2 shouldBe 3

        map["x"] = null
        val actual3 = map.getOrElse("x") { 10 }
        actual3 shouldBe 10
    }
}