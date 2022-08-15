package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;

@Service 
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	// ========== Create / Update ===============

	public Book save(Book book) {
		return bookRepo.save(book);
	}

	// ========== Read ==========================

	public List<Book> getAll() {
		return bookRepo.findAll();
	}
	
	// Main written out version of getOne()
//	public Toy getOne(Long id) {
//		Optional<Toy> toy = toyRepo.findById(id);
//		
//		if (toy.isPresent()) {
//			return toy.get();
//		} else {
//			return null;
//		}
//	}
	
	// Shorthand version
	public Book getOne(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	// retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
            }
    }
    
	// returns all the books
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }

	// ========== Delete ========================
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}

	
}
