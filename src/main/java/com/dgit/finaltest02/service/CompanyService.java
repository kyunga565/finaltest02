package com.dgit.finaltest02.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.dgit.finaltest02.dto.Department;
import com.dgit.finaltest02.dto.Employee;
import com.dgit.finaltest02.dto.Employee22;
import com.dgit.finaltest02.dto.Title;
import com.dgit.finaltest02.mappers.DepartmentMapper;
import com.dgit.finaltest02.mappers.EmployeeMapper;
import com.dgit.finaltest02.mappers.TitleMapper;
import com.dgit.finaltest02.util.MybatisSqlSessionFactory;

public class CompanyService {
	private static final CompanyService instance = new CompanyService();

	public static CompanyService getInstance() {
		return instance;
	}
	private CompanyService(){}
	
	private static final Logger logger = Logger.getLogger(CompanyService.class);
	
	public List<Title> selectAll(){
		logger.debug("selectAll()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			TitleMapper em = sqlSession.getMapper(TitleMapper.class);
			return em.selectAll();
		}finally{
			sqlSession.close();
		}
	}
	
	public List<Employee> selectEmployee(){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
			return em.selectEmployee();
		}finally{
			sqlSession.close();
		}
	}
	public List<Employee> selectEmployeeTitle(){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
			return em.selectEmployeeTitle();
		}finally{
			sqlSession.close();
		}
	}
	public Title selectTitle(int no){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			TitleMapper tm = sqlSession.getMapper(TitleMapper.class);
			return tm.selectTitle(no);
		}finally{
			sqlSession.close();
		}
	}
	public List<Department> selectPart(){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			DepartmentMapper tm = sqlSession.getMapper(DepartmentMapper.class);
			return tm.selectPart();
		}finally{
			sqlSession.close();
		}
	}
	public List<Department> selectAllPart(){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			DepartmentMapper tm = sqlSession.getMapper(DepartmentMapper.class);
			return tm.selectAllPart();
		}finally{
			sqlSession.close();
		}
	}
	public int getEno(){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
			return em.getEno();
		}finally{
			sqlSession.close();
		}
	}
	public int getDno(){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			DepartmentMapper em = sqlSession.getMapper(DepartmentMapper.class);
			return em.getDno();
		}finally{
			sqlSession.close();
		}
	}
	public int getTno() {
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			TitleMapper tm = sqlSession.getMapper(TitleMapper.class);
			return tm.getTno();
		}finally{
			sqlSession.close();
		}
	}
	public void insertItem(Department dObj){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			DepartmentMapper dm = sqlSession.getMapper(DepartmentMapper.class);
			dm.insertItem(dObj);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}
	public void insertEmployee(Employee dObj) {
			SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
			em.insertEmployee(dObj);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}
	public void insertTitle(Title dObj){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			TitleMapper dm = sqlSession.getMapper(TitleMapper.class);
			dm.insertTitle(dObj);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}
	public void updateItem(Department dObj) {
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			DepartmentMapper dm = sqlSession.getMapper(DepartmentMapper.class);
			dm.updateItem(dObj);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}
	public void deleteItem(String no) {
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			DepartmentMapper dm = sqlSession.getMapper(DepartmentMapper.class);
			dm.deleteItem(no);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}
	public void updateTitle(Title dObj) {
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			TitleMapper dm = sqlSession.getMapper(TitleMapper.class);
			dm.updateTitle(dObj);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}
	public void deleteTitle(String no) {
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			TitleMapper dm = sqlSession.getMapper(TitleMapper.class);
			dm.deleteTitle(no);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	public Department getDcode(int no){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			DepartmentMapper tm = sqlSession.getMapper(DepartmentMapper.class);
			return tm.getDcode(no);
		}finally{
			sqlSession.close();
		}
	}
}
