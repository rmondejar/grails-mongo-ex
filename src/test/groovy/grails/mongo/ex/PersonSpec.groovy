package grails.mongo.ex

import grails.test.mongodb.MongoSpec
import grails.testing.gorm.DomainUnitTest
import com.github.fakemongo.Fongo
import com.mongodb.MongoClient

@SuppressWarnings(['MethodName', 'DuplicateNumberLiteral', 'TrailingWhitespace'])
class PersonSpec extends MongoSpec
        implements DomainUnitTest<Person> {

    @Override
    MongoClient createMongoClient() {
        new Fongo(getClass().name).mongo
    }

    void 'a blank name is not save'() {
        given:
        domain.name = ''

        expect:
        !domain.validate(['name'])
    }

    void 'A valid domain is saved'() {
        given:
        domain.name = 'Bart'
        domain.surname = 'Simpson'
        domain.email = 'bsimpson@mail.com'

        when:
        domain.save()

        then:
        Person.count() == old(Person.count()) + 1
    }
}
