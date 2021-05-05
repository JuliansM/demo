package com.valid.demo.dao;

import com.valid.demo.model.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    private final JdbcTemplate template;

    public PersonDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public int save(Person person) {
        String sql = "INSERT INTO persons (name, last_name, processed) " +
                "VALUES ('" + person.getName() + "', '" + person.getLastName() + "', '" + person.getProcessed() + "') ";
        return template.update(sql);
    }

    @Override
    public void saveAll(List<Person> personList) {
        personList.forEach(person -> {
            String sql = "UPDATE persons SET name='" + person.getName() + "', last_name='" + person.getLastName() + "', processed='" + person.getProcessed() + "' " +
                    " WHERE id='" + person.getId() + "' ";
            template.update(sql);
        });
    }

    @Override
    public List<Person> findAll() {
        String sql = "SELECT * FROM persons";
        return template.query(sql, new BeanPropertyRowMapper<>(Person.class));
    }
}
