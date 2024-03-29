package ricardotenorio.github.com.personapi.utils;

import ricardotenorio.github.com.personapi.dto.request.PersonDTO;
import ricardotenorio.github.com.personapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

  private static final String FIRST_NAME = "Ricardo";
  private static final String LAST_NAME = "Tenório";
  private static final String CPF_NUMBER = "497.241.785-44";
  private static final long PERSON_ID = 1L;
  public static final LocalDate BIRTH_DATE = LocalDate.of(2020, 01, 01);

  public static PersonDTO createFakeDTO() {
    return PersonDTO.builder()
            .firstName(FIRST_NAME)
            .lastName(LAST_NAME)
            .cpf(CPF_NUMBER)
            .birthDate("01-01-2020")
            .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
            .build();
  }

  public static Person createFakeEntity() {
    return Person.builder()
            .id(PERSON_ID)
            .firstName(FIRST_NAME)
            .lastName(LAST_NAME)
            .cpf(CPF_NUMBER)
            .birthDate(BIRTH_DATE)
            .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
            .build();
  }
}
