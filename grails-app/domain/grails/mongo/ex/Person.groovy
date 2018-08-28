package grails.mongo.ex

import grails.mongodb.*
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Person implements MongoEntity<Person> {

    String name
    String surname
    String email

    static constraints = {
        name blank: false
        surname blank: false
        email blank: false
    }
}
