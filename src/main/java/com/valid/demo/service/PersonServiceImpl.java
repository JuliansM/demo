package com.valid.demo.service;

import com.valid.demo.dao.PersonDao;
import com.valid.demo.model.Person;
import com.valid.demo.service.dto.PersonDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;
    private final ModelMapper modelMapper;

    public PersonServiceImpl(PersonDao personDao, ModelMapper modelMapper) {
        this.personDao = personDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public int save(PersonDTO personDTO) {
        Person person = modelMapper.map(personDTO, Person.class);
        return personDao.save(person);
    }

    @Override
    public void saveAll(List<PersonDTO> personList) {
        List<Person> persons = personList
                .stream()
                .map(personDTO -> modelMapper.map(personDTO, Person.class))
                .collect(Collectors.toList());
        personDao.saveAll(persons);
    }

    @Override
    public List<PersonDTO> findAll() {
        return personDao.findAll()
                .stream()
                .map(person -> modelMapper.map(person, PersonDTO.class))
                .collect(Collectors.toList());
    }
}
