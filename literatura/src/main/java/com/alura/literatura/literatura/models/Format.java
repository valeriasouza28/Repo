package com.alura.literatura.literatura.models;

//package com.example.bookcatalog.model;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
///import javax.persistence.GenerationType;
//import javax.persistence.Id;
import jakarta.persistence.Entity
import jakarta.persistence.IdClass;   
import jakarta.persistence.Id

@Entity
public class Book {
    
    @Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String title;
    @ElementCollection
    private List<String> subjects;
    @ElementCollection
    private List<String> languages;
    private boolean copyright;
    private String mediaType;
    private int downloadCount;
    @ElementCollection
    private List<Format> formats;
    @ElementCollection
    private List<Person> authors;
    @ElementCollection
    private List<Person> translators;
    @ElementCollection
    private List<String> bookshelves;

    // Getters and Setters
    // ...
}

@Embeddable
public static class Format {
    private String mimeType;
    private String url;

    // Getters and Setters
    // ...
}

@Embeddable
public static class Person {
    private Integer birthYear;
    private Integer deathYear;
    private String name;

    // Getters and Setters
    // ...
}    
}
