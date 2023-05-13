package specialclass

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

internal class EnumClassTest : AnnotationSpec() {
    enum class State {
        IDLE, RUNNING, FINISHED
    }

    @Test
    fun `고유한 값의 유한 집합을 나타내는 모델 타입을 표현하는데 enum을 사용`() {
        val state = State.RUNNING
        //컴파일러가 when expression이 철저한지 여부를 추론하기 때문에 else case가 필요 없음
        val actual = when (state) {
            State.IDLE -> "idle"
            State.FINISHED -> "finished"
            State.RUNNING -> "running"
        }
        actual shouldBe "running"
    }

    enum class Color(val rgb: Int) {
        RED(0xFF0000),
        GREEN(0x00FF00),
        BLUE(0x0000FF),
        YELLOW(0xFFFF00);

        fun containsRed() = (this.rgb and 0xFF0000 != 0)
    }

    @Test
    fun `enum 클래스는 프로퍼티를 포함할 수 있다`() {
        val red = Color.RED
        red.containsRed() shouldBe true
        Color.BLUE.containsRed().shouldBeFalse()
        Color.YELLOW.containsRed().shouldBeTrue()
        red.toString() shouldBe "RED"
    }
}