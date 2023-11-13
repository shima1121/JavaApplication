package com.example.postgresql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class PostgresqlController {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    @GetMapping("/List")
    public String index(Model model){
        String sql = "SELECT * FROM attendances";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        model.addAttribute("attend", list);
        return "index";
    }
}
