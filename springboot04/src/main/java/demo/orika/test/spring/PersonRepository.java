package demo.orika.test.spring;

import demo.orika.test.dto.PersonDTO;

public interface PersonRepository {
    public PersonDTO obtainPerson();
}
