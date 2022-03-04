package com.qa.students.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.students.domain.Students;
import com.qa.students.service.StudentsService;

@RestController
public class StudentsController {

	private List<Students> stud = new ArrayList<>();

	private StudentsService service;

	public StudentsController(StudentsService service) {
		super();
		this.service = service;
	}

	// create - post request
	@PostMapping("/createStudent")
	public ResponseEntity<Students> createStudent(@RequestBody Students s) {
		return new ResponseEntity<>(this.service.create(s), HttpStatus.CREATED);
	}

	// readAll - get request - list
	// Read - GET
	@GetMapping("/getStudents")
	public ResponseEntity<List<Students>> readAll() {
		return new ResponseEntity<List<Students>>(this.service.readAll(), HttpStatus.FOUND);
	}

	// readById - get request - 1 record
	@GetMapping("/getById/{id}")
	public ResponseEntity<Students> readById(@PathVariable Long id) {
		return new ResponseEntity<Students>(this.service.readOne(id), HttpStatus.FOUND);
	}

	// update - put request - need id (path parameter or path variable) and a body
	@PutMapping("/update/{id}")
	public ResponseEntity<Students> update(@PathVariable Long id, @RequestBody Students stud) {
		return new ResponseEntity<Students>(this.service.update(id, stud), HttpStatus.ACCEPTED);
	}

	// delete - delete request - need id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return (this.service.delete(id)) != null ? new ResponseEntity<Boolean>(HttpStatus.OK)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}