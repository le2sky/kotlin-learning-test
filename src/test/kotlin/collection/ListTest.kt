package collection

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class ListTest : AnnotationSpec() {

    @Test
    fun `list는 imutable이고 mutable은 따로 만들어야한다`() {
        val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)
        val sudoers: List<Int> = systemUsers

        fun addSystemUser(newUser: Int) {
            systemUsers.add(newUser)
        }

        fun getSysSudoers(): List<Int> {
            return sudoers
        }
        addSystemUser(4)
        getSysSudoers().size shouldBe 4
    }
}