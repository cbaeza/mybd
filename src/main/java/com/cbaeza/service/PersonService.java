package com.cbaeza.service;

import java.util.List;

import org.jooq.Record;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cbaeza.dto.PersonDto;
import com.cbaeza.dto.ResponseDto;
import com.cbaeza.jooq.gradle.db.public_.tables.Person;
import com.cbaeza.util.MapperUtils;

/**
 * Service responsible to retrieve person data from DB.
 */
@Service
public class PersonService {
  private static final Logger LOG = LoggerFactory.getLogger(PersonService.class.getName());

  private final DataBaseService dataBaseService;

  public PersonService(DataBaseService dataBaseService) {
    this.dataBaseService = dataBaseService;
  }

  public List<PersonDto> getAllPersons() {
    Result<Record> result = dataBaseService.executeSelectQuery(Person.PERSON);
    return MapperUtils.mapPersons(result);
  }

  public PersonDto getPerson(int id) {
    Result<Record> result = dataBaseService.executeSelectQuery(Person.PERSON, Person.PERSON.ID.eq(id));
    return MapperUtils.mapPerson(result);
  }

  public ResponseDto updatePerson(final int id, final PersonDto personDto) {
    if (personDto != null) {
      int i = dataBaseService.executeUpdateQuery(Person.PERSON, Person.PERSON.ID.eq(id), Person.PERSON.NAME,
          personDto.getName());
      LOG.info(">>>> result update: " + i);
      if (i == -1) {
        return new ResponseDto(i + " NO row affected");
      } else {
        return new ResponseDto(i + " row affected");
      }
    }
    return new ResponseDto("personDto can not be null");
  }

}
