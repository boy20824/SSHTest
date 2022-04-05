package com.test.service.serviceImpl;

import com.test.model.dept.DeptDAO_interface;
import com.test.model.dept.DeptHibernateDAO;
import com.test.model.dept.DeptVO;
import com.test.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    DeptDAO_interface deptHibernateDAO;

    @Override
    public DeptVO getOneDept(Integer deptno) {
        return deptHibernateDAO.findByPrimaryKey(deptno);
    }

    @Override
    public DeptVO addDept(DeptVO deptVO) {
        deptHibernateDAO.insert(deptVO);
        return deptVO;
    }
}
