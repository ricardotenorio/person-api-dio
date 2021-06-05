package ricardotenorio.github.com.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ricardotenorio.github.com.personapi.dto.request.PersonDTO;
import ricardotenorio.github.com.personapi.dto.response.MessageResponseDTO;
import ricardotenorio.github.com.personapi.entity.Person;
import ricardotenorio.github.com.personapi.exception.PersonNotFoundException;
import ricardotenorio.github.com.personapi.mapper.PersonMapper;
import ricardotenorio.github.com.personapi.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

  private PersonRepository personRepository;

  private final PersonMapper personMapper = PersonMapper.INSTANCE;

  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public MessageResponseDTO createPerson(PersonDTO personDTO) {
    Person personToSave = personMapper.toModel(personDTO);

    Person savedPerson = personRepository.save(personToSave);

    return MessageResponseDTO
        .builder()
        .message("Created Person with ID " + savedPerson.getId())
        .build();
  }

  public List<PersonDTO> listAll() {
    List<Person> people = personRepository.findAll();

    return people.stream()
        .map(personMapper::toDTO)
        .collect(Collectors.toList());
  }

  public PersonDTO findById(Long id) throws PersonNotFoundException {
    Person person = personRepository.findById(id)
        .orElseThrow(() -> new PersonNotFoundException(id));

    return personMapper.toDTO(person);
  }
}
