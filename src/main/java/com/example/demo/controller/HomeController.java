package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class HomeController {
    // Bên trong controller sẽ có nhiều method, mỗi cái sẽ bắt request cụ thể

    // Bắt GET /home request và trả về view
    @GetMapping("/home")
    public String home() {
        return "deptrai";  // Return tên của View, model sẽ tự động pass vào view
    }
}
