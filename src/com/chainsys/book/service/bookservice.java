package com.chainsys.book.service;

import java.util.Set;

import com.chainsys.book.exception.booknotfoundException;
import com.chainsys.book.model.book;


public interface bookservice {
	Set<book> findAll();
	book findById(int id) throws booknotfoundException;
	book findByname(String name) throws booknotfoundException;
}
