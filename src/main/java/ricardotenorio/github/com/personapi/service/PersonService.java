package ricardotenorio.github.com.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ricardotenorio.github.com.personapi.dto.response.MessageResponseDTO;
import ricardotenorio.github.com.personapi.entity.Person;
import ricardotenorio.github.com.personapi.repository.PersonRepository;

@Service
public class PersonService {

  private PersonRepository personRepository;

  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public MessageResponseDTO createPerson(Person person) {
    Person savedPerson = personRepository.save(person);

    return MessageResponseDTO
        .builder()
        .message("Created Person with ID " + savedPerson.getId())
        .build();
  }
}
