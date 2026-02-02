package com.example.bai2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 1. Đánh dấu đây là nơi nhận yêu cầu từ trình duyệt
public class HomeController {

    @GetMapping("/") // 2. Khi người dùng vào địa chỉ gốc (localhost:8080)
    public String hienThiTrangChu() {
        // 3. Trả về tên file HTML giao diện (không cần đuôi .html)
        return "hello"; 
    }
}