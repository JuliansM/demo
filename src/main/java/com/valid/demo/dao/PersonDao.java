package com.valid.demo.dao;

import com.valid.demo.model.Person;

import java.util.List;

public interface PersonDao {

    int save(Person person);

    void saveAll(List<Person> personList);

    List<Person> findAll();
}
