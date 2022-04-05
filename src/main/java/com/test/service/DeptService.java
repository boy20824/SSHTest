package com.test.service;

import com.test.model.dept.DeptVO;

public interface DeptService {

    public DeptVO getOneDept(Integer deptno);

    public DeptVO addDept(DeptVO deptVO);
}
