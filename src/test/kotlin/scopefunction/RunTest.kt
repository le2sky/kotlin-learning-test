package scopefunction

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class RunTest : AnnotationSpec() {

    @Test
    fun `let과 비슷하지만, T의 확장함수 꼴 (this 참조 가능)`() {
        val str : String? = "str"
        val length = str?.run {
            this.length
            length
        }
        length shouldBe 3
    }
}