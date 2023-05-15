package collection

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe


internal class MapTest() : AnnotationSpec() {

    @Test
    fun `map은 key, value pair의 컬렉션이다`() {
        val pointsXPass: Int = 15
        val EZPassAccounts: MutableMap<Int, Int> = mutableMapOf(1 to 100, 2 to 100, 3 to 100)
        val EZPassReport: Map<Int, Int> = EZPassAccounts

        fun updatePointsCredit(accountId: Int) {
            if (EZPassAccounts.containsKey(accountId)) {
                println("update")
                EZPassAccounts[accountId] = EZPassAccounts.getValue(accountId) + pointsXPass
            } else {
                println("not found")
            }
        }

        updatePointsCredit(1)
        EZPassReport[1] shouldBe 115
    }
}