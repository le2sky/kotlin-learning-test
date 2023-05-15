package collection

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

internal class MapElementAccessTest : AnnotationSpec() {

    val map = mapOf("key" to 42)

    @Test
    fun `대괄호로 접근하면 null or value 반환`() {
        val v1 = map["key"]
        val v2 = map["key2"]
        v1 shouldBe 42
        v2.shouldBeNull()
    }

    @Test
    fun `getValue로 접근하면 value 반환 or 예외 발생`() {
        val v1 = map.getValue("key")
        v1 shouldBe 42
        shouldThrow<NoSuchElementException> {
            map.getValue("key2")
        }
    }

    @Test
    fun `withDefault로 만든 map은 getValue로 접근해도 예외 발생하지 않음`() {
        val withDefault = map.withDefault { it.length }
        val v1 = withDefault.getValue("key2")
        v1 shouldBe 4
    }
}