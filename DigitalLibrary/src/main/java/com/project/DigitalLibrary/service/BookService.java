package com.project.DigitalLibrary.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;


import com.jsp.Agro.exception.DataNotFound;
import com.jsp.Agro.exception.DataNotUpdate;
import com.jsp.Agro.util.ResponseStructure;
import com.project.DigitalLibrary.dao.BookDao;
import com.project.DigitalLibrary.dto.Book;

@Service
public class BookService {
	@Autowired
	private BookDao dao;
	
	//to add book
	public ResponseEntity<ResponseStructure<Book>> addBook(Book book){
		ResponseStructure<Book> r=new ResponseStructure<Book>();
		r.setData(dao.addBook(book));
		r.setMessage("Book added successfully");
		r.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Book>>(r,HttpStatus.CREATED);
	}
	
	//to get all books
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBooks(){
		List<Book> list = dao.getAllBooks();
		if(list!=null) {
			ResponseStructure<List<Book>> r=new ResponseStructure<List<Book>>();
			r.setData(list);
			r.setMessage("All books fetched successfully");
			r.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Book>>>(r,HttpStatus.OK);
		}else {
			throw new DataNotFound();
		}
	}
	
	
	//to get book by id
	public ResponseEntity<ResponseStructure<Book>> getBookById(int id){
		Book book = dao.getBookById(id).get();
		if(book!=null) {
			ResponseStructure<Book> r=new ResponseStructure<Book>();
			r.setData(book);
			r.setMessage("book is fetched successfully");
			r.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Book>>(r,HttpStatus.OK);
		}else {
			throw new DataNotFound();
		}
	}
	
	//to get books by title
	public ResponseEntity<ResponseStructure<List<Book>>> getBooksByTitle(String title){
		List<Book> db = dao.getBooksByTitle(title);
		ResponseStructure<List<Book>> m = new ResponseStructure<List<Book>>();
		if(db!=null) {
			m.setData(db);
			m.setMessage("equipment is fetched successfully");
			m.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Book>>>(m,HttpStatus.OK) ;
		}
		throw new DataNotFound("Data not found");
	}
	//to update book details
	public ResponseEntity<ResponseStructure<Book>> updateBook(int id,Book book){
		Book optional = dao.getBookById(id).get();
		if(optional!=null) {
			ResponseStructure<Book> r=new ResponseStructure<Book>();
			r.setData(dao.updateBook(id,book));
			r.setMessage("equipment data is updated");
			r.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Book>>(r,HttpStatus.OK);
		}else
			throw new DataNotUpdate();
	}
	//to delete book
	public ResponseEntity<ResponseStructure<Book>> deleteBook(int id){
		Book book = dao.getBookById(id).get();
		if(book!=null) {
			ResponseStructure<Book> r=new ResponseStructure<Book>();
			r.setData(dao.deleteBook(id));
			r.setMessage("equipment data is deleted");
			r.setStatus(HttpStatus.GONE.value());
			return new ResponseEntity<ResponseStructure<Book>>(r,HttpStatus.GONE);
		}else
			throw new DataNotFound();
	}
}
