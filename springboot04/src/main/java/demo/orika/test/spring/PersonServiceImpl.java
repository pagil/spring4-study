package demo.orika.test.spring;

import demo.orika.test.domain.Person;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    private MapperFacade mapperFacade;

//    @Autowired
//    public void setPersonRepository(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }
//
//    @Autowired
//    public void setMapperFacade(MapperFacade mapperFacade) {
//        this.mapperFacade = mapperFacade;
//    }
    // TODO - Fix the Bug: probably requires Default constructor
    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, MapperFacade mapperFacade) {
        this.personRepository = personRepository;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public Person obtainPersion() {
        return mapperFacade.map(personRepository.obtainPerson(), Person.class);
    }
}
