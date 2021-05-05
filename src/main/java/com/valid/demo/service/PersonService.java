package com.valid.demo.service;

import com.valid.demo.service.dto.PersonDTO;

import java.util.List;

public interface PersonService {

    int save(PersonDTO person);

    void saveAll(List<PersonDTO> personList);

    List<PersonDTO> findAll();
}
