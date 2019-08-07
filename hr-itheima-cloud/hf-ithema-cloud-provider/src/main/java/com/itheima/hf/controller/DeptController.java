package com.itheima.hf.controller;

import com.itheima.hf.model.Dept;
import com.itheima.hf.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService service;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody Dept dept) {
        return service.addDept(dept);
    }

    @GetMapping(value = "/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/list")
    public List<Dept> list() {
        return service.findAll();
    }
}
