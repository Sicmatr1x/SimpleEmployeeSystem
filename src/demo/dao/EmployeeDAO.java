package demo.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;

import demo.beans.Employee;

import demo.db.DBAccess;

public class EmployeeDAO {
	
	/**
	 * 返回整张Employee表的内容
	 * @return 
	 */
	public List<Employee> queryAllEmployee (){
//		System.out.println("开始建立数据库连接");
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
//			System.out.println("数据库连接建立完毕" + sqlSession);
			// 执行查询
//			System.out.println("执行查询");
			return sqlSession.selectList("EmployeeMapper.queryAllEmployee");
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
	 * @return 查得到返回Employee，查不到返回null
	 */
	public Employee queryEmployeeById (int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行查询
//			return sqlSession.selectList("EmployeeMapper.queryEmployeeById", id);
			return sqlSession.selectOne("EmployeeMapper.queryEmployeeById", id);
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
	 * @param employee
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int addEmployee(Employee employee){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行插入
			int result =  sqlSession.insert("EmployeeMapper.addEmployee", employee);
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
	 * @param employee
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int editEmployee(Employee employee){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行修改
			int result =  sqlSession.update("EmployeeMapper.editEmployee", employee);
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
	public int deleteEmployee(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			int result =  sqlSession.delete("EmployeeMapper.deleteEmployeeById", id);
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
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		// 测试查询
//		Employee emp = employeeDAO.queryEmployeeById(2);
// 		if(emp != null){
// 			System.out.println(emp.getId() + ":" + emp.getName() + ":" + emp.getAge() + ":" + emp.getSex());
// 		}else{
// 			System.out.println("emp=" + emp);
// 		}
		
 		// 测试添加
// 		Employee employee = new Employee();
// 		employee.setId(3);
// 		employee.setName("Zoec");
// 		employee.setAge(21);
// 		employee.setSex("M");
// 		int insert = employeeDAO.addEmployee(employee);
// 		System.out.println("insert=" + insert);
		
		// 测试修改
//		Employee employee = new Employee();
// 		employee.setId(3);
// 		employee.setName("ZoeC");
// 		employee.setAge(20);
// 		employee.setSex("F");
// 		int result = employeeDAO.editEmployee(employee);
// 		System.out.println("update=" + result);
		
		// 测试删除
//		int result = employeeDAO.deleteEmployee(3);
//		System.out.println("delete=" + result);
 		
 		// 打印整表
 		List<Employee> list = employeeDAO.queryAllEmployee();
 		System.out.println("\n打印全表：");
 		for(Employee e : list){
 			System.out.println(e.getId() + ":" + e.getName() + ":" + e.getAge() + ":" + e.getSex());
 		}
 		System.out.println("打印完毕");
 		

	}
}
