package ricardotenorio.github.com.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ricardotenorio.github.com.personapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
