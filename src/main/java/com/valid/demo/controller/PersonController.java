package com.valid.demo.controller;

import com.valid.demo.service.PersonService;
import com.valid.demo.service.dto.PersonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody PersonDTO personDTO) {
        Integer result = personService.save(personDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody List<PersonDTO> personDTOS) {
        personService.saveAll(personDTOS);
        return ResponseEntity.ok("Transaccion realizada.");
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> findAll() {
        List<PersonDTO> personDTOS = personService.findAll();
        return ResponseEntity.ok(personDTOS);
    }
}
