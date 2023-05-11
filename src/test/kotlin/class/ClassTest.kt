package `class`

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf

internal class ClassTest : AnnotationSpec() {

    @Test
    fun `클래스 생성`() {
        class Person {}

        val person = Person()
        person.shouldBeTypeOf<Person>()
    }

    @Test
    fun `헤더와 본문은 선택사항, 본문이 없으면 중괄호 생략 가능`() {
        class Empty

        val empty = Empty()
        empty.shouldBeTypeOf<Empty>()
    }

    @Test
    fun `클래스는 기본 생성자와 1개 이상의 secondary 생성자를 가질 수 있다`() {
        //기본 생성자는 클래스 헤더의 파트
        class Person constructor(firstName: String)

        //기본 생성자에 any annotations,  visibility modifiers가 없으면 constructor 키워드를 생략 가능
        class Person2(firstName: String)
    }

    @Test
    fun `기본 생성자는 아무 코드도 포함 못한다, 필요한 경우 초기화 블록에서 코드 작성`() {
        class InitOrderDemo(name: String) {
            //초기화 블록은 클래스 본문 순서와 동일한 순서로 실행된다
            val firstProperty = "First property : $name".also(::println)

            init {
                println("First initializer block that prints $name")
            }

            val secondProperty = "Second property : ${name.length}".also(::println)

            init {
                println("Second initializer block that prints ${name.length}")
            }
        }

        InitOrderDemo("le2sky")
    }

    @Test
    fun `기본 생성자 파라미터는 초기화 블록이나 프로퍼티 초기화 단계에서 사용 가능하다`() {
        class Customer(name: String) {
            val customerKey = name.uppercase()
        }
        Customer("le2sky").customerKey shouldBe "LE2SKY"
    }

    @Test
    fun `기본 생성자 파라미터는 자동으로 선언하고 할당한다`() {
        class Person(
            val firstName: String,
            val lastName: String,
            var age: Int, // <- var val 가능
            var isEmployed: Boolean = true, // <- trailing comma 가능
        )
        Person("lee", "sky", 25)
            .isEmployed
            .shouldBeTrue()
    }

    @Test
    fun `any annotations,  visibility modifiers가 있는 경우 constructor 키워드가 필요 `() {
        class Customer public constructor(name: String)
    }

    @Test
    fun `클래스는 secondary 생성자를 선언할 수 있다`() {
        class Pet {
            var ownerId: Int;

            constructor(ownerId: Int) {
                this.ownerId = ownerId
            }
        }

        val pet = Pet(1)
        pet.ownerId shouldBe 1
    }

    @Test
    fun `기본 생성자가 있는 경우, secondary 생성자는 직간접적으로 기본 생성자에게 위임`() {
        class Person(val name: String) {
            val children: MutableList<Person> = mutableListOf()

            constructor(name: String, parent: Person) : this(name) {
                parent.children.add(this)
            }
        }

        val parent = Person("leesky")
        val child = Person("le2sky", parent)
        parent.children.size shouldBe 1
        child.children.size shouldBe 0
    }

    @Test
    fun `기본 생성자에 대한 위임은 보조 생성자의 첫 번째 문에 액세스하는 순간에 발생`() {
        var a = 0

        class Constructors {

            init {
                a = 1
            }

            // 암시적 위임
            constructor(i: Int) {
                a = 2
            }
        }
        Constructors(2)
        a shouldBe 2
    }

    @Test
    fun `non-abstract class가 생성자를 선언하지 않으면 public 기본 생성자를 가진다`() {
        class DefaultClass

        val defaultClass = DefaultClass()
        defaultClass.shouldBeTypeOf<DefaultClass>()
    }

    @Test
    fun `클래스가 public 생성자를 포함하지 않으려면 private 기본 생성자 선언`() {
        class DontCreateMe private constructor() {
        }
    }

    @Test
    fun `기본 생성자의 모든 파라미터가 기본값이 있으면 기본 생성자 생성`() {
        class Customer(val customerName: String = "")
        Customer()
    }
}