package com.alura.literatura.literatura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.bookcatalog.model.Book;
import com.example.bookcatalog.service.BookService;
import com.example.bookcatalog.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class BookCatalogApplication {

    @Autowired
    private BookService bookService;

    @Autowired
    private GutendexService gutendexService;

    public static void main(String[] args) {
        SpringApplication.run(BookCatalogApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Catálogo de Livros");
                System.out.println("1. Listar livros");
                System.out.println("2. Buscar livro por ID (API externa)");
                System.out.println("3. Adicionar livro");
                System.out.println("4. Atualizar livro");
                System.out.println("5. Remover livro");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        List<Book> books = bookService.findAll();
                        books.forEach(book -> System.out.println(book.getTitle() + " by " + book.getAuthors().stream().map(author -> author.getName()).reduce((a, b) -> a + ", " + b).orElse("Unknown Author")));
                        break;
                    case 2:
                        System.out.print("Digite o ID do livro: ");
                        Long id = scanner.nextLong();
                        scanner.nextLine(); // consume newline
                        Book externalBook = gutendexService.getBookById(id);
                        if (externalBook != null) {
                            System.out.println("Título: " + externalBook.getTitle());
                            System.out.println("Autores: " + externalBook.getAuthors().stream().map(author -> author.getName()).reduce((a, b) -> a + ", " + b).orElse("Unknown Author"));
                            // Exibir outras informações conforme necessário
                        } else {
                            System.out.println("Livro não encontrado.");
                        }
                        break;
                    case 3:
                        System.out.print("Digite o título do livro: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Digite o autor do livro: ");
                        String newAuthor = scanner.nextLine();
                        Book newBook = new Book();
                        newBook.setTitle(newTitle);
                        newBook.setAuthors(List.of(new Person(null, null, newAuthor)));
                        bookService.save(newBook);
                        System.out.println("Livro adicionado.");
                        break;
                    case 4:
                        System.out.print("Digite o ID do livro a ser atualizado: ");
                        Long updateId = scanner.nextLong();
                        scanner.nextLine(); // consume newline
                        Optional<Book> bookToUpdate = bookService.findById(updateId);
                        if (bookToUpdate.isPresent()) {
                            System.out.print("Digite o novo título do livro: ");
                            String updatedTitle = scanner.nextLine();
                            System.out.print("Digite o novo autor do livro: ");
                            String updatedAuthor = scanner.nextLine();
                            Book book = bookToUpdate.get();
                            book.setTitle(updatedTitle);
                            book.setAuthors(List.of(new Person(null, null, updatedAuthor)));
                            bookService.save(book);
                            System.out.println("Livro atualizado.");
                        } else {
                            System.out.println("Livro não encontrado.");
                        }
                        break;
                    case 5:
                        System.out.print("Digite o ID do livro a ser removido: ");
                        Long deleteId = scanner.nextLong();
                        scanner.nextLine(); // consume newline
                        bookService.deleteById(deleteId);
                        System.out.println("Livro removido.");
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
        };
    }
}