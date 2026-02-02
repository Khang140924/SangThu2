package com.example.bai2.service;

import com.example.bai2.model.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    // Tạo một danh sách giả lập Database
    private List<Book> books = new ArrayList<>();

    // Constructor thêm sẵn vài cuốn sách để test
    public BookService() {
        books.add(new Book(1, "Lap trinh Java", "Nguyen Van A"));
        books.add(new Book(2, "Spring Boot Co Ban", "Tran Van B"));
    }

    // 1. Lấy tất cả sách
    public List<Book> getAllBooks() {
        return books;
    }

    // 2. Lấy sách theo ID
    public Book getBookById(int id) {
        Optional<Book> foundBook = books.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
        return foundBook.orElse(null);
    }

    // 3. Thêm sách mới
    public void addBook(Book book) {
        books.add(book);
    }

    // 4. Cập nhật sách
    public void updateBook(int id, Book updatedBook) {
        Book book = getBookById(id);
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
        }
    }

    // 5. Xóa sách
    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}