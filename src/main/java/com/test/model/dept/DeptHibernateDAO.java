package com.test.model.dept;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository
public class DeptHibernateDAO implements DeptDAO_interface {

    @Resource
    SessionFactory sessionFactory;

    @Override
    public void insert(DeptVO deptVO) {
        sessionFactory.getCurrentSession().saveOrUpdate(deptVO);
    }

    @Override
    public void update(DeptVO deptVO) {
        sessionFactory.getCurrentSession().update(deptVO);
    }

    @Override
    public void delete(Integer deptno) {
        DeptVO deptVO = (DeptVO) sessionFactory.getCurrentSession().get(DeptVO.class, deptno);
        sessionFactory.getCurrentSession().delete(deptVO);
    }

    @Override
    public DeptVO findByPrimaryKey(Integer deptno) {
        DeptVO deptVO = (DeptVO) sessionFactory.getCurrentSession().get(DeptVO.class, deptno);
        System.out.println(deptVO);
        return deptVO;
    }

//    @Override
//    public List<DeptVO> getAll() {
//        //【警告廢棄: WARN deprecation:1874 - HHH90000022: Hibernate's legacy org.hibernate.Criteria API is deprecated; use the JPA javax.persistence.criteria.CriteriaQuery instead】
//        // List<DeptVO> list = (List<DeptVO>)hibernateTemplate.loadAll(DeptVO.class);
//
//        //【轉回 Hibernate session】:
//        Query<DeptVO> query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(GET_ALL_STMT, DeptVO.class);
//        List<DeptVO> list = query.getResultList();
//        return list;
//    }

    public static void main(String[] args) {

        //DeptHibernateDAO dao = new DeptHibernateDAO();
        ApplicationContext context = new ClassPathXmlApplicationContext("model-config1-DriverManagerDataSource.xml");

        DeptDAO_interface dao = (DeptDAO_interface) context.getBean("deptDAO");

//		DeptVO deptVO = new DeptVO(); // ���POJO
//		deptVO.setDname("會計部");
//		deptVO.setLoc("天津");
//		dao.insert(deptVO);

		DeptVO deptVO1 = dao.findByPrimaryKey(10);
		System.out.print(deptVO1.getDeptno() + ",");
		System.out.print(deptVO1.getDname() + ",");
		System.out.print(deptVO1.getLoc());

        ((ClassPathXmlApplicationContext) context).close();


    }

}
