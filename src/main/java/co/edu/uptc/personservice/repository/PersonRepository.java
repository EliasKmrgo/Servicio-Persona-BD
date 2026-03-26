package co.edu.uptc.personservice.repository;

import co.edu.uptc.personservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; // <--- Agregar esta

@Repository // <--- Agregar esta anotación
public interface PersonRepository extends JpaRepository<Person, Long> {
}
