package com.project.DigitalLibrary.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.DigitalLibrary.dto.Book;
import com.project.DigitalLibrary.repo.BookRepository;

@Repository
public class BookDao {
	@Autowired
    private BookRepository repo;

    // 1. Add a New Book
    public Book addBook(Book book) {
        return repo.save(book);
    }

    // 2. View All Books
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    // 3. Search Book by ID
    public Optional<Book> getBookById(int id) {
        return repo.findById(id);
    }

    // 4. Search Books by Title
    public List<Book> getBooksByTitle(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }

    // 5. Update Book Details
    public Book updateBook(int id, Book updatedBook) {
        Optional<Book> existingBook = repo.findById(id);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setGenre(updatedBook.getGenre());
            book.setAvailability(updatedBook.getAvailability());
            return repo.save(book);
        } else {
            throw new RuntimeException("Book not found with ID: " + id);
        }
    }

    // 6. Delete a Book
    public Book deleteBook(int id) {
		Optional<Book> db = repo.findById(id);
		if(db.isPresent()) {
			repo.deleteById(id);
			return db.get();
		}
		else {
			return null;
		}
	}

}
