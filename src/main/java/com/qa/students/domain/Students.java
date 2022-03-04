package com.qa.students.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // marks this class as the table
@Data
@NoArgsConstructor
public class Students {

	// columns for the table
	@Id // mark it as the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Long id;

	private String name;
	private int age;
	private String phoneNumber;

	// one with everything except id
	public Students(String name, int age, String phoneNumber) {
		super();
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

}
