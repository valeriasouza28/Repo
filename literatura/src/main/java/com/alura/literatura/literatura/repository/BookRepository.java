package com.alura.literatura.literatura.repository;

//package com.example.bookcatalog.repository;

//import com.example.bookcatalog.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import com.alura.literatura.literatura.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}