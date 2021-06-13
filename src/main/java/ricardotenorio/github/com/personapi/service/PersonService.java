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

    return createMessageResponse(savedPerson.getId(), "Created Person with ID ");
  }

  public List<PersonDTO> listAll() {
    List<Person> people = personRepository.findAll();

    return people.stream()
        .map(personMapper::toDTO)
        .collect(Collectors.toList());
  }

  public PersonDTO findById(Long id) throws PersonNotFoundException {
    Person person = verifyIfExists(id);

    return personMapper.toDTO(person);
  }

  public void delete(Long id) throws PersonNotFoundException {
    verifyIfExists(id);

    personRepository.deleteById(id);
  }

  public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
    verifyIfExists(id);

    Person personToUpdate = personMapper.toModel(personDTO);

    Person updatedPerson = personRepository.save(personToUpdate);

    return createMessageResponse(updatedPerson.getId(), "Updated Person with ID ");
  }

  private Person verifyIfExists(Long id) throws PersonNotFoundException {
    return personRepository.findById(id)
        .orElseThrow(() -> new PersonNotFoundException(id));
  }

  private MessageResponseDTO createMessageResponse(Long id, String message) {
    return MessageResponseDTO
        .builder()
        .message(message + id)
        .build();
  }
}
