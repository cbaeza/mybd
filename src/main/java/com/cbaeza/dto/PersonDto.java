package com.cbaeza.dto;

/**
 * Simple PersonDto
 */
public class PersonDto {

  private int ID;
  private String name;

  public PersonDto() {
  }

  public PersonDto(int ID, String name) {
    this.ID = ID;
    this.name = name;
  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static PersonDto empty() {
    return new PersonDto(-1, "");
  }

  @Override
  public String toString() {
    return "PersonDto{" +
        "ID='" + ID + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
