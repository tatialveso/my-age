package foo.myage.controller

import foo.myage.model.Person
import java.time.LocalDate

class PersonController(person: Person) {
    var person: Person = person

    fun showResult(): String {
        return "${this.person.firstName}, ${this.person.birthYear}"
    }

    fun calcAgeInYears(thisYear: Int): Int {
        return thisYear - this.person.birthYear
    }

    fun calcAgeInYears(): Int {
        val thisYear = LocalDate.now().year

        return thisYear - this.person.birthYear
    }
}