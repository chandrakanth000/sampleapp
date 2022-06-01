package com.springboot.spring.Controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.spring.maintainance.BookMain;
import com.springboot.spring.Model.BookM;

@RestController
@RequestMapping("book")
public class Book {
    @Autowired
	private BookMain bookM;
	
	
	@GetMapping(value="books", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> getBooks(){
		
		List<Book> books = new ArrayList<Book>();
		
	books = bookM.findBooks();
		
	return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getBookbyId(@PathVariable int id){
	    return null;
	
	}
	
	@PostMapping(value="/mybook",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> saveBook(@RequestBody Book book){
		 
	
		BookM.save(book);
		
		List<Book> booksresult =  BookM.findBooks();
		
		
		return new ResponseEntity<Book>(book,HttpStatus.OK);
		
	}
	
    
}
