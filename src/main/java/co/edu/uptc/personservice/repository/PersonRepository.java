package co.edu.uptc.personservice.repository;

import co.edu.uptc.personservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}