package com.example.bai2.controller;

import com.example.bai2.model.Book;
import com.example.bai2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // Lưu ý: Dùng @Controller (trả về HTML), KHÔNG dùng @RestController
@RequestMapping("/books")
public class BookWebController {

    @Autowired
    private BookService bookService;

    // 1. Hiển thị danh sách sách
    @GetMapping
    public String showBookList(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "book-list"; // Trả về file book-list.html
    }

    // 2. Hiển thị form thêm sách
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "book-add"; // Trả về file book-add.html
    }

    // 3. Xử lý khi nhấn nút "Thêm"
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/books"; // Thêm xong quay về danh sách
    }

    // 4. Hiển thị form sửa sách
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book-edit"; // Trả về file book-edit.html
    }

    // 5. Xử lý khi nhấn nút "Cập nhật"
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable int id, @ModelAttribute Book book) {
        bookService.updateBook(id, book);
        return "redirect:/books";
    }

    // 6. Xử lý xóa sách
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}