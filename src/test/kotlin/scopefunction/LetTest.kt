package scopefunction

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.shouldBe

internal class LetTest : AnnotationSpec() {

    fun customPrint(s: String) {
        println(s.uppercase())
    }

    @Test
    fun `let은 매개변수화된 타입 T의 확장 함수이며, 자기 자신을 받아서 R을 반환(마지막 표현식 결과)`() {
        val empty = "test".let {
            customPrint(it)
            it.isEmpty()
        }
        empty.shouldBeFalse()
    }

    @Test
    fun `중첩해서 사용하기도 한다`() {
        val strOne: String? = "string"
        val strTwo: String? = "str"
        val result = strOne?.let {
            strTwo?.let {
                strOne + it
            }
        }
        result shouldBe "stringstr"
    }
}