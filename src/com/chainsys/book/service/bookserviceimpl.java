package com.chainsys.book.service;

import java.util.Set;

import com.chainsys.book.dao.bookdaoimpl;
import com.chainsys.book.exception.booknotfoundException;
import com.chainsys.book.model.book;

public class bookserviceimpl {
	
	public bookserviceimpl() {
		bookdaoimpl dao = new bookdaoimpl();
	}
	
	public Set<book> findAll() {
		bookdaoimpl dao = null;
		return dao.findAll();
			
     }
	
	public book findById(int id) throws booknotfoundException {
		bookdaoimpl dao = null;
		book Product = dao.findById(id);
		if (Product == null) {
			throw new booknotfoundException("Product Id Not Found");
		} else {
			book book = null;
			return book;
		}
	}
	public book findByname(String name) throws booknotfoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
