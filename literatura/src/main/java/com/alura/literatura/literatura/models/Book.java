package com.alura.literatura.literatura.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Getters
@Setters
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
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<String> getSubjects() {
        return subjects;
    }
    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
    public List<String> getLanguages() {
        return languages;
    }
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
    public boolean isCopyright() {
        return copyright;
    }
    public void setCopyright(boolean copyright) {
        this.copyright = copyright;
    }
    public String getMediaType() {
        return mediaType;
    }
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
    public int getDownloadCount() {
        return downloadCount;
    }
    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }
    public List<Format> getFormats() {
        return formats;
    }
    public void setFormats(List<Format> formats) {
        this.formats = formats;
    }
    public List<Person> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Person> authors) {
        this.authors = authors;
    }
    public List<Person> getTranslators() {
        return translators;
    }
    public void setTranslators(List<Person> translators) {
        this.translators = translators;
    }
    public List<String> getBookshelves() {
        return bookshelves;
    }
    public void setBookshelves(List<String> bookshelves) {
        this.bookshelves = bookshelves;
    }

    // Getters and Setters
    // ...
}

/*@Embeddable
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

*/