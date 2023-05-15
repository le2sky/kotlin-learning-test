package collection

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class SetTest : AnnotationSpec() {

    @Test
    fun `mutableSetOf와 setOf로 set을 만들 수 있다`() {
        val openIssues: MutableSet<String> = mutableSetOf("a", "b", "c")
        fun addIssues(uniqueDesc: String): Boolean {
            return openIssues.add(uniqueDesc)
        }

        fun getStatusLog(isAdded: Boolean): String {
            return if (isAdded) "registered correctly" else "marked as duplicate and rejected"
        }

        val aNewIssue = "d"
        val anIssueAlreadyIn = "b"

        getStatusLog(addIssues(aNewIssue)) shouldBe "registered correctly"
        getStatusLog(addIssues(anIssueAlreadyIn)) shouldBe "marked as duplicate and rejected"
    }
}