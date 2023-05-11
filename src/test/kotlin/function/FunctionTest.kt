package function

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe


internal class FunctionTest : AnnotationSpec() {
    @Test
    fun `default parameter`() {
        val actual = getMessageWithPrefix("message")
        actual shouldBe "[Info] message"
    }

    @Test
    fun `named arguments`() {
        val actual = getMessageWithPrefix(prefix = "named", message = "hello, world")
        actual shouldBe "[named] hello, world"
    }

    @Test
    fun `Unit은 반환값이 없을때 사용`() {
        val unit = unitFun()
        unit shouldBe Unit
    }

    private fun unitFun() {
    }

    private fun getMessageWithPrefix(message: String, prefix: String = "Info") =
        "[$prefix] $message"
}