package com.itheima.hf.controller;

import com.itheima.hf.model.Dept;
import com.itheima.hf.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/provider")
    public Object discovery(){
        List<String> list = discoveryClient.getServices();//获得服务
        System.out.println(list);
        List<ServiceInstance> insList = discoveryClient.getInstances("HF-ITHEIMA-CLOUD-PROVIDER");//服务名称
        for (ServiceInstance si:insList) {
            System.out.println(si.getHost() +"," + si.getServiceId() +"," +si.getPort()
                    +"," +si.getUri() +"," +si.getMetadata());
        }
        return this.discoveryClient;
    }
}
