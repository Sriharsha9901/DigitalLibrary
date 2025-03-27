package com.project.DigitalLibrary.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Agro.dto.Equipments;
import com.jsp.Agro.dto.User;
import com.jsp.Agro.util.ResponseStructure;
import com.project.DigitalLibrary.dao.BookDao;
import com.project.DigitalLibrary.dto.Book;
import com.project.DigitalLibrary.service.BookService;

import jakarta.validation.Valid;


@RestController
public class BookController {
	@Autowired
	private BookService service;
	//to add book
	@PostMapping("/library")
	public ResponseEntity<ResponseStructure<Book>> saveUser(@RequestBody Book book){
		return service.addBook(book);
	}
	
	//to get all books
	@GetMapping("/library")
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBooks(){
		return service.getAllBooks();
	}
	
	//to get book by id
	@GetMapping("/library/{id}")
	public ResponseEntity<ResponseStructure<Book>> getBookById(@PathVariable  int id){	
		return service.getBookById(id);
	}
	
	//to get book by title
	 @GetMapping("/library/title")
	 public ResponseEntity<ResponseStructure<List<Book>>> searchBooksByTitle(@RequestParam String title) {   
	     return service.getBooksByTitle(title);
	 }
	 
	// 5. Update Book Details
	 @PutMapping("/library/{id}")
	 public ResponseEntity<ResponseStructure<Book>> updateBook(@PathVariable int id, @Valid @RequestBody Book book) {
	     try {
	         return service.updateBook(id,book);
	     } catch (RuntimeException e) {
	          return ResponseEntity.notFound().build();
	     }
	 }
	 
	// 6. Delete a Book
	    @DeleteMapping("/library/{id}")
	    public ResponseEntity<ResponseStructure<Book>> deleteBook(@PathVariable int id) {
	        
	        return service.deleteBook(id);
	    }
	 
	
	
}
