package ricardotenorio.github.com.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ricardotenorio.github.com.personapi.dto.request.PersonDTO;
import ricardotenorio.github.com.personapi.dto.response.MessageResponseDTO;
import ricardotenorio.github.com.personapi.entity.Person;
import ricardotenorio.github.com.personapi.service.PersonService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

  private PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
    return personService.createPerson(personDTO);
  }
}
