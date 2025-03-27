package com.project.DigitalLibrary.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.DigitalLibrary.dto.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	List<Book> findByTitleContainingIgnoreCase(String title);
}
