package com.alura.literatura.literatura.service.GutendexService;

//package com.example.bookcatalog.service;

//import com.example.bookcatalog.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.alura.literatura.literatura.models.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GutendexService {
    private static final String API_URL = "https://gutendex.com/books/";

    public Book getBookById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + id;
        return restTemplate.getForObject(url, Book.class);
    }
}