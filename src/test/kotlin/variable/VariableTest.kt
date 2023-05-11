package variable

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf

internal class VariableTest : AnnotationSpec() {

    @Test
    fun `타입 추론이 가능하다`() {
        val a = 3
        a.shouldBeTypeOf<Int>()
    }

    @Test
    fun `var은 mutable이다`() {
        var a = "initial"
        a = "le2sky"
        a shouldBe "le2sky"
    }

    @Test
    fun `val은 immutable이다`() {
        val a = "le2sky"
        //a = "2" <- can't be reassigned
    }

    @Test
    fun `선언 대입 분할 - 초기화된 변수에만 접근 가능하다`() {
        val a: Int
        a = 1
        a shouldBe 1

        var b: Int
        // println(b) <- Variable 'b' must be initialized
    }

    @Test
    fun `condition별 초기화할 때, 초기화 추적 가능`() {
        fun someCondition() = true
        val d: Int
        if (someCondition()) {
            d = 1
        }
        else {
            d = 2
        }
        d shouldBe 1
    }
}