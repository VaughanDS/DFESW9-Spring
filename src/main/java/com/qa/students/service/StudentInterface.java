package com.qa.students.service;

import java.util.List;

public interface StudentInterface<T> {

	T create(T createI);

	List<T> read();

	T update(int id, T updateI);

	T delete(int id);// boolean delete(Long id);

	T readOne(int id);
}
