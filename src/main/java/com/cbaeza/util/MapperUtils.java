package com.cbaeza.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;
import org.springframework.util.CollectionUtils;

import com.cbaeza.dto.PersonDto;
import com.cbaeza.jooq.gradle.db.public_.tables.Person;

/**
 * Utility to perform mapping of Record's to Dto's
 */
public class MapperUtils {

  public static List<PersonDto> mapPersons(Result<Record> result) {
    if (CollectionUtils.isEmpty(result)) {
      return Collections.emptyList();
    }
    List<PersonDto> allPersons = new ArrayList<>();
    for (Record r : result) {
      int id = r.getValue(Person.PERSON.ID);
      String name = r.getValue(Person.PERSON.NAME);
      allPersons.add(new PersonDto(id, name));
    }
    return allPersons;
  }

  public static PersonDto mapPerson(Result<Record> result) {
    if (CollectionUtils.isEmpty(result)) {
      return PersonDto.empty();
    }
    for (Record r : result) {
      int id = r.getValue(Person.PERSON.ID);
      String name = r.getValue(Person.PERSON.NAME);
      return new PersonDto(id, name);
    }
    return null;
  }
}
