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

    @Test
    fun `vararg는 여러 파라미터를 받을 수 있다`() {
        val allMessages = getAllMessages("temp", "le2sky", "hello", prefix = "test")
        val allMessages2 = getAllMessages(*allMessages, prefix = "test")
        allMessages shouldBe allMessages2
        allMessages.size shouldBe 3
    }

    private fun getAllMessages(vararg messages: String, prefix: String): Array<out String> {
        return messages
    }

    private fun unitFun() {
    }

    private fun getMessageWithPrefix(message: String, prefix: String = "Info") =
        "[$prefix] $message"
}