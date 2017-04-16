package demo.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;

import demo.beans.Salary;

import demo.db.DBAccess;

public class SalaryDAO {
	
	/**
	 * 返回整张Salary表的内容
	 * @return 
	 */
	public List<Salary> queryAllSalary (){
//		System.out.println("开始建立数据库连接");
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
//			System.out.println("数据库连接建立完毕" + sqlSession);
			// 执行查询
//			System.out.println("执行查询");
			return sqlSession.selectList("SalaryMapper.queryAllSalary");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
			
		}
		return null;
	}

	/**
	 * 根据id来查询指定员工
	 * @param id 员工id
	 * @return 查得到返回Salary，查不到返回null
	 */
	public Salary querySalaryById (int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行查询
//			return sqlSession.selectList("SalaryMapper.querySalaryById", id);
			return sqlSession.selectOne("SalaryMapper.querySalaryById", id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
			
		}
		return null;
	}
	
	/**
	 * 插入员工
	 * @param Salary
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int addSalary(Salary Salary){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行插入
			int result =  sqlSession.insert("SalaryMapper.addSalary", Salary);
			sqlSession.commit(); // 提交，不提交不会保存的
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		
		}
		return -1;
	}
	
	/**
	 * 修改给定id的员工信息
	 * @param Salary
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int editSalary(Salary Salary){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行插入
			int result =  sqlSession.update("SalaryMapper.editSalary", Salary);
			sqlSession.commit(); // 提交，不提交不会保存的
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		
		}
		return -1;
	}
	
	/**
	 * 根据员工id来删除员工
	 * @param id
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int deleteSalary(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			int result =  sqlSession.delete("SalaryMapper.deleteSalaryById", id);
			sqlSession.commit(); // 提交，不提交不会保存的
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
			
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		SalaryDAO SalaryDAO = new SalaryDAO();
		
		// 测试查询
//		Salary emp = SalaryDAO.querySalaryById(1);
// 		if(emp != null){
// 			System.out.println(emp.getId() + ";" + emp.getEmpid() + ";" + emp.getMounth() + ";" + emp.getSalary());
// 		}else{
// 			System.out.println("emp=" + emp);
// 		}
		
 		// 测试添加
// 		Salary Salary = new Salary();
// 		Salary.setId(3);
// 		Salary.setName("Zoec");
// 		Salary.setAge(21);
// 		Salary.setSex("M");
// 		int insert = SalaryDAO.addSalary(Salary);
// 		System.out.println("insert=" + insert);
		
		// 测试修改
//		Salary Salary = new Salary();
// 		Salary.setId(3);
// 		Salary.setName("ZoeC");
// 		Salary.setAge(20);
// 		Salary.setSex("F");
// 		int result = SalaryDAO.editSalary(Salary);
// 		System.out.println("update=" + result);
		
		// 测试删除
//		int result = SalaryDAO.deleteSalary(3);
//		System.out.println("delete=" + result);
 		
 		// 打印整表
 		List<Salary> list = SalaryDAO.queryAllSalary();
 		System.out.println("\n打印全表：");
 		for(Salary e : list){
 			System.out.println(e.getId() + ";" + e.getEmpid() + ";" + e.getMounth() + ";" + e.getSalary());
 		}
 		System.out.println("打印完毕");
 		

	}
}
