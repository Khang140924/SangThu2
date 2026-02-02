package com.example.bai2.controller;

import com.example.bai2.model.Book;
import com.example.bai2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Lưu ý: Dùng RestController để trả về dữ liệu JSON
@RequestMapping("/api/books") // Đường dẫn gốc
public class BookController {

    @Autowired
    private BookService bookService;

    // Lấy danh sách (GET)
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Lấy 1 cuốn theo ID (GET)
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    // Thêm sách mới (POST)
    @PostMapping
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "Book added successfully!";
    }

    // Cập nhật sách (PUT)
    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book book) {
        bookService.updateBook(id, book);
        return "Book updated successfully!";
    }

    // Xóa sách (DELETE)
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "Book deleted successfully!";
    }
}