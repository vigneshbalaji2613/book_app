package com.chainsys.book.dao;
import java.util.Set;
import com.chainsys.book.model.book;
public interface bookdao {
   Set<book> findAll();
   book findById(int id);
	book findByname(String name);
}
