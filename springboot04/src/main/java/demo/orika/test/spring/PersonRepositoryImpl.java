package demo.orika.test.spring;

import demo.orika.test.dto.PersonDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class PersonRepositoryImpl implements PersonRepository {


    @Override
    public PersonDTO obtainPerson() {
        return createPersonDTO();
    }

    private PersonDTO createPersonDTO() {
        PersonDTO dto = new PersonDTO();
        dto.setId(RandomUtils.nextLong(0, 100));
        dto.setName(RandomStringUtils.random(4));
        dto.setLastNames(Arrays.asList(RandomStringUtils.random(7), RandomStringUtils.random(8)));
        dto.setCity(RandomStringUtils.random(5));
        dto.setPostalCode(RandomStringUtils.random(6));
        dto.setStreetAddress(RandomStringUtils.random(10));
        return dto;
    }
}
