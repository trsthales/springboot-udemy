package com.thales.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thales.dto.PersonDTO;
import com.thales.exception.ResourceNotFoundException;
import static com.thales.mapper.ObjectMapper.parseListObjects;
import static com.thales.mapper.ObjectMapper.parseObject;
import com.thales.model.Person;
import com.thales.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

	public PersonDTO create(PersonDTO personDTO) {
		logger.info("salvando person!");
		Person person = parseObject(personDTO, Person.class);
		return parseObject(repository.save(person),PersonDTO.class);
	}

	public List<PersonDTO> findAll() {
		logger.info("buscando todas person!");
		return parseListObjects(repository.findAll(), PersonDTO.class) ;
	}

	public PersonDTO findById(Long id) {
		logger.info("buscando person especifica!");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return parseObject(entity, PersonDTO.class);
	}

	public PersonDTO update(PersonDTO person) {
		logger.info("atualizando person!");
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return parseObject(repository.save(entity), PersonDTO.class);
	}

	public void delete(Long id) {
		logger.info("deletando person!");
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
}
