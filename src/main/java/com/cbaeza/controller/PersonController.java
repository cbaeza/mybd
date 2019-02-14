package com.cbaeza.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cbaeza.dto.PersonDto;
import com.cbaeza.service.PersonService;

/**
 * Person controller responsible of CRUD on table Person
 */
@RestController
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Get all persons
   *
   * @return a list of all persons
   */
  @GetMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseEntity<?> get() {
    return new ResponseEntity<>(
        personService.getAllPersons(),
        HttpStatus.OK);
  }

  /**
   * Get person by ID if exist, otherwise empty person
   *
   * @param id the perosn ID
   * @return Person if exist, otherwise empty person
   */
  @GetMapping(value = "/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseEntity<?> get(@PathVariable int id) {
    return new ResponseEntity<>(
        personService.getPerson(id),
        HttpStatus.OK);
  }

  @PutMapping(value = "/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseEntity<?> put(@PathVariable int id, @RequestBody PersonDto personDto) {
    return new ResponseEntity<>(
        personService.updatePerson(id, personDto),
        HttpStatus.OK);
  }
}
