package co.edu.uptc.personservice.service;

import co.edu.uptc.personservice.dto.*;
import co.edu.uptc.personservice.model.Person;
import co.edu.uptc.personservice.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    // 🔹 Obtener todos
    public List<PersonDto> getAll() {

        return repository.findAll()
                .stream()
                .map(person -> {
                    PersonDto dto = new PersonDto();
                    dto.setName(person.getName());
                    dto.setLastName(person.getLastName());
                    dto.setAge(person.getAge());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // 🔹 Guardar persona
    public PersonResponse save(PersonRequest request) {

        Person person = new Person();
        person.setName(request.getName());
        person.setLastName(request.getLastName());
        person.setAge(request.getAge());

        Person saved = repository.save(person);

        PersonResponse response = new PersonResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setLastName(saved.getLastName());
        response.setAge(saved.getAge());
        response.setMessage("Persona Registrada en BD");

        return response;
    }
}