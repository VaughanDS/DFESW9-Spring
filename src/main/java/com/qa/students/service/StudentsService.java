package com.qa.students.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.students.domain.Students;
import com.qa.students.repo.StudentsRepo;

@Service
public class StudentsService {

	private StudentsRepo repo;

	public StudentsService(StudentsRepo repo) {
		super();
		this.repo = repo;
	}

	// create - logic
	public Students create(Students createI) {
		return this.repo.save(createI);
	}

	// read - findAll, findById
	public List<Students> readAll() {
		return this.repo.findAll();
	}

	public Students readOne(Long id) {
		Optional<Students> optionalC = this.repo.findById(id);
		return optionalC.orElse(null);
	}

	// update - getters & setters to update each field individually
	public Students update(Long id, Students updateI) {
		Optional<Students> toFind = this.repo.findById(id);
		Students found = toFind.get();
		// set all the individual attributes
		found.setName(updateI.getName());
		found.setAge(updateI.getAge());
		found.setPhoneNumber(updateI.getPhoneNumber());
		return this.repo.save(found);
	}

	// delete - deleteById
	public Students delete(Long id) {
		Optional<Students> toDelete = this.repo.findById(id);
		this.repo.deleteById(id);
		return toDelete.orElse(null);
	}

}