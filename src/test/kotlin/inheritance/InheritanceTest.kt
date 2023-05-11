package inheritance

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class InheritanceTest : AnnotationSpec() {

    @Test
    fun `코틀린의 클래스, 메서드는 기본적으로 final, 상속을 허용할려면 open 키워드 사용`() {
        open class Dog {
            open fun getHelloMessage(): String {
                return "wow wow!"
            }
        }

        class Yorkshire : Dog() {
            override fun getHelloMessage(): String {
                return "wif wif!"
            }
        }

        val dog: Dog = Yorkshire()
        val actual = dog.getHelloMessage()
        actual shouldBe "wif wif!"
    }

    @Test
    fun `parameterized constructor`() {
        open class Tiger(val origin: String) {
            fun getHelloMessage(): String {
                return "A tiger from $origin"
            }
        }

        class SiberianTiger : Tiger("Siberia")

        val tiger: Tiger = SiberianTiger()
        tiger.getHelloMessage() shouldBe "A tiger from Siberia"
    }

    @Test
    fun `passing constructor arguments to superclass`() {
        open class Lion(val name: String, val origin: String) {
            fun getHelloMessage(): String {
                return "$name, the lion from $origin"
            }
        }

        class Asiatic(name: String) : Lion(name = name, origin = "India")

        val lion: Lion = Asiatic("foo")
        lion.getHelloMessage() shouldBe "foo, the lion from India"
    }
}
