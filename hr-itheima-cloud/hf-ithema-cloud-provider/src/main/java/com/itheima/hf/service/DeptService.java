package com.itheima.hf.service;

import com.itheima.hf.model.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
