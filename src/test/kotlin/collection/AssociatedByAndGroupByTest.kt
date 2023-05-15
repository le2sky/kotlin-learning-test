package collection

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.kotest.matchers.types.shouldBeTypeOf

internal class AssociatedByAndGroupByTest : AnnotationSpec() {

    data class Person(val name: String, val city: String, val phone: String)

    val people = listOf(
        Person("leesky", "Boston", "1234-4321"),
        Person("kimsky", "Munich", "1234-1234"),
        Person("parksky", "Saint-Petersburg", "1234-0011"),
        Person("chosky", "Saint-Petersburg", "1234-1100"),
    )

    @Test
    fun `associatedBy는 마지막 적합한 요소를 값으로 사용한다`() {
        val phoneBook = people.associateBy { it.phone }
        val cityBook = people.associateBy(Person::phone, Person::city)
        val lastPersonCity = people.associateBy(Person::city, Person::name)

        phoneBook.size shouldBe 4
        cityBook["1234-4321"].shouldBeTypeOf<String>()
        cityBook["1234-4321"] shouldBe "Boston"
        lastPersonCity["Saint-Petersburg"] shouldBe "chosky"
    }

    @Test
    fun `groupBy는 모든 값을 리스트에 넣는다`() {
        val peopleCities = people.groupBy(Person::city, Person::name)
        peopleCities["Saint-Petersburg"]?.size shouldBe 2
        peopleCities["Saint-Petersburg"]?.shouldBeInstanceOf<List<String>>()
    }
}