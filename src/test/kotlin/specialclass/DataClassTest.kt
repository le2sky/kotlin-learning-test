package specialclass

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

internal class DataClassTest : AnnotationSpec() {

    @Test
    fun `data 클래스는 값을 저장하기 위한 용도로 사용할 수 있다`() {
        data class User(val name: String, val id: Int) {
            override fun equals(other: Any?): Boolean {
                return other is User && other.id == this.id
            }
        }

        val user = User("Alex", 1)
        val secondUser = User("Alex", 1)
        val thirdUser = User("Max", 2)

        (user == secondUser).shouldBeTrue()
        (user == thirdUser).shouldBeFalse()

        //data 클래스 인스턴스는 속성을 매칭해서 같은 hashCode를 반환하도록 한다
        (user.hashCode() == secondUser.hashCode()).shouldBeTrue()
        (user.hashCode() == thirdUser.hashCode()).shouldBeFalse()

        //data 클래스는 copy를 자동으로 생성한다.
        (user.copy() == user).shouldBeTrue()

        //사본의 값을 변경 가능
        val copy = user.copy(id = 3)
        (user == copy).shouldBeFalse()

        //자동생성된 componentN으로 선언된 순서에 맞는 프로퍼티의 값을 얻을 수 있다.
        val userName = user.component1()
        userName shouldBe "Alex"
    }
}