package com.springmongodb.apirest.repository;

import com.springmongodb.apirest.model.Book;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * BookRepository
 */
public interface BookRepository extends MongoRepository<Book, String>{

    
}