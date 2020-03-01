package com.springmongodb.apirest.resource;

import java.util.List;
import java.util.Optional;

import com.springmongodb.apirest.model.Book;
import com.springmongodb.apirest.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * BookController
 */

@RestController
public class BookController {

    @Autowired
    private BookRepository repository;

    @PostMapping("/addBook")
    public Book saveBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks() {
        return repository.findAll();
    }

    @GetMapping("/findAllBooks/{id}")
    public Optional<Book> getOneBook(@PathVariable String id){
        return repository.findById(id);
    }

    @PutMapping("/update/{id}")
    public Book update(@PathVariable String id, @RequestBody Book updateBook){
        Book book = repository.findById(id).orElseThrow();
        book.setBookName(updateBook.getBookName());
        book.setAuthorName(updateBook.getAuthorName());
        return repository.save(book);
    }

    @DeleteMapping("delete/{id}")
    public String deleteBook(@PathVariable String id){
        repository.deleteById(id);
        return "Book deleted id: "+id;
    }
}