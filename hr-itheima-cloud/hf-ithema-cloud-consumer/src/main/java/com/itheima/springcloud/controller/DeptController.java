package com.itheima.springcloud.controller;

import com.itheima.hf.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @PostMapping(value = "/add")
    public boolean add(@RequestBody Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @GetMapping(value = "/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @GetMapping(value = "/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

    @GetMapping("/provider")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/provider", Object.class);
    }
}
