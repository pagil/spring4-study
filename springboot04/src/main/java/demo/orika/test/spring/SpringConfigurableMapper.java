package demo.orika.test.spring;


import demo.orika.test.mapper.PersonDtoToPersonMapper;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringConfigurableMapper extends ConfigurableMapper {

    private ApplicationContext applicationContext;
    private MapperFactory mapperFactory;
    private PersonDtoToPersonMapper personDtoToPersonMapper;

    @Autowired
    public void setPersonDtoToPersonMapper(PersonDtoToPersonMapper personDtoToPersonMapper) {
        this.personDtoToPersonMapper = personDtoToPersonMapper;
        addMapper(personDtoToPersonMapper);
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    protected void configure(MapperFactory mapperFactory) {
        super.configure(mapperFactory);
        this.mapperFactory = mapperFactory;
    }

    private void addMapper(Mapper mapper) {
        mapperFactory.registerMapper(mapper);
    }
}
