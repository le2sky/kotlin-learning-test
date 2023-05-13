package specialclass

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class ObjectKeywordTest : AnnotationSpec() {

    @Test
    fun `object expression를 이용해서 단일 구현으로 데이터 유형을 얻을 수 있다`() {
        fun rentPrice(standardDays: Int, festivityDays: Int, spectialDays: Int): Int {
            val dayRates = object {
                var standard: Int = 30 * standardDays
                var festivity: Int = 50 * festivityDays
                var special: Int = 100 * spectialDays
            }
            val total = dayRates.standard + dayRates.festivity + dayRates.special
            return total
        }

        // lazy instance -> 함수가 호출될 경우에 생성되는 object
        val actual = rentPrice(10, 2, 1)
        actual shouldBe 500
    }

    object DoAuth {
        fun takeParams(userName: String, password: String): String {
            return "input Auth parameters = $userName : $password"
        }
    }

    @Test
    fun `object declaration는 expression이 아니라 할당은 불가하지만, 직접 접근은 가능하다`() {
        //메서드가 실행되는 시점에 object가 생성된다
        val actual = DoAuth.takeParams("foo", "qwerty")
        actual shouldBe "input Auth parameters = foo : qwerty"
    }

    class BigBen {
        // 이름은 생략 가능하다
        companion object Bonger {
            fun getBongs(nTimes: Int) {
                for (i in 1..nTimes) {
                    print("BONG ")
                }
            }
        }
    }

    @Test
    fun `클래스 내부의 객체 선언은 companion 객체를 정의하면 유용하다 `() {
        // 자바의 정적 메서드와 비슷하다.
        BigBen.getBongs(12)
    }
}