package ricardotenorio.github.com.personapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ricardotenorio.github.com.personapi.dto.request.PersonDTO;
import ricardotenorio.github.com.personapi.dto.response.MessageResponseDTO;
import ricardotenorio.github.com.personapi.entity.Person;
import ricardotenorio.github.com.personapi.repository.PersonRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static ricardotenorio.github.com.personapi.utils.PersonUtils.createFakeDTO;
import static ricardotenorio.github.com.personapi.utils.PersonUtils.createFakeEntity;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

  @Mock
  private PersonRepository personRepository;

  @InjectMocks
  private PersonService personService;

  @Test
  void testGivenPersonDTOThenReturnSavedMessage() {
    PersonDTO personDTO = createFakeDTO();
    Person expectedSavedPerson = createFakeEntity();

    when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

    MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());

    MessageResponseDTO successMessage = personService.createPerson(personDTO);

    assertEquals(expectedSuccessMessage, successMessage);
  }

  private MessageResponseDTO createExpectedMessageResponse(Long id) {
    return MessageResponseDTO
        .builder()
        .message("Created Person with ID " + id)
        .build();
  }
}
