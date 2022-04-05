package com.test.controller;

import com.test.model.dept.DeptVO;
import com.test.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/v1/dept")
public class DeptController {

    @Resource
    DeptService deptService;
    
    @PostMapping("/insert")
    public void insert(DeptVO deptVO){
        deptService.addDept(deptVO);
    }

    @GetMapping("/{deptno}")
    @ResponseBody
    public DeptVO getOneDept(@PathVariable Integer deptno){
        System.out.println(deptno);
        DeptVO dept=deptService.getOneDept(deptno);
        return dept;
    }
}
