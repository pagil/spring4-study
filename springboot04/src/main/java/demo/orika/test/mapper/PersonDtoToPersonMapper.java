package demo.orika.test.mapper;

import demo.orika.test.domain.Address;
import demo.orika.test.domain.Person;
import demo.orika.test.dto.PersonDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonDtoToPersonMapper extends CustomMapper<PersonDTO, Person> {

    @Override
    public void mapAtoB(PersonDTO a, Person b, MappingContext mappingContext) {
//        // Let the Orika framework map fields having the same names - This plan failed: it will end up in infinite recursion
//        b = mapperFacade.map(a, b.getClass());

        // I could use the protected mapperFacade if I need to map a particular field
        // this.mapperFacade.map(sourceObject, destinationClass); - this will work for complex types having their own mappers

        b.setId(a.getId());
        b.setName(a.getName());
        b.setSurnames(a.getLastNames());
        Address address = new Address();
        address.setStreet(a.getStreetAddress());
        address.setCity(a.getCity());
        address.setZipCode(a.getPostalCode());
        b.setAddress(address);
    }


    @Override
    public void mapBtoA(Person b, PersonDTO a, MappingContext mappingContext) {
//        // Let the Orika framework map fields having the same names - This plan failed: it will end up in infinite recursion
//        b = mapperFacade.map(a, b.getClass());

        // I could use the protected mapperFacade if I need to map a particular field
        // this.mapperFacade.map(sourceObject, destinationClass); - this will work for complex types having their own mappers

        a.setId(b.getId());
        a.setName(b.getName());
        a.setLastNames(b.getSurnames());
        Optional<Address> address = Optional.ofNullable(b.getAddress());
        address.ifPresent(v -> {
            a.setStreetAddress(v.getStreet());
            a.setCity(v.getCity());
            a.setPostalCode(v.getZipCode());
        });
    }

}
