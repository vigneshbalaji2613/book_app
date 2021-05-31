package com.chainsys.book.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.book.exception.booknotfoundException;
import com.chainsys.book.model.book;
import com.chainsys.book.service.bookservice;
import com.chainsys.book.service.bookserviceimpl;
import com.chainsys.book.exception.booknotfoundException;



public class bookclient {
public static void main(String[] args) {
	Set<book> bookSet;
	bookserviceimpl service = new bookserviceimpl();
	String date;
	DateTimeFormatter dateFormat;
	int id;
	System.out.println("Enter the choice");
	Scanner scanner = new Scanner(System.in);
	int choice = scanner.nextInt();
	List<String> nameList;
	switch (choice) {
	case 1:
		System.out.println("Find All books");
		bookSet = service.findAll();
		char[] bookSet1 = null;
		System.out.println(bookSet1);
		break;
		
	
     case 2:
	       System.out.println("Find the Product By Id");
	       System.out.println("Enter the Product Id");
	id = scanner.nextInt();
	try {
		book book = service.findById(id);
		System.out.println(book);
	} catch (booknotfoundException e) {
		
	}
	
	break;
	
     case 3:
			System.out.println("Find the Product By name");
			System.out.println("Enter the Product name");
			 String name = scanner.next();
			try {
				book book = service.findByname(name);
				System.out.println(book);
			} catch (booknotfoundException e) {
			}
			break;
  }
 }
}

