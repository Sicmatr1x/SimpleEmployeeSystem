package demo.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;

import demo.beans.Benefit;
import demo.beans.Job;
import demo.db.DBAccess;

public class JobDAO {
	
	/**
	 * 返回整张Job表的内容
	 * @return 
	 */
	public List<Job> queryAllJob (){
//		System.out.println("开始建立数据库连接");
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
//			System.out.println("数据库连接建立完毕" + sqlSession);
			// 执行查询
//			System.out.println("执行查询");
			return sqlSession.selectList("JobMapper.queryAllJob");
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
	 * @return 查得到返回Job，查不到返回null
	 */
	public Job queryJobById (int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行查询
//			return sqlSession.selectList("JobMapper.queryJobById", id);
			return sqlSession.selectOne("JobMapper.queryJobById", id);
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
	 * 根据员工id来查询指定记录
	 * @param id 记录id
	 * @return 查得到返回Attend，查不到返回null
	 */
	public List<Job> queryJobByEmpId (int empid){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行查询
			return sqlSession.selectList("JobMapper.queryJobByEmpId", empid);
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
	 * @param Job
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int addJob(Job Job){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行插入
			int result =  sqlSession.insert("JobMapper.addJob", Job);
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
	 * @param Job
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int editJob(Job Job){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行插入
			int result =  sqlSession.update("JobMapper.editJob", Job);
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
	public int deleteJob(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			int result =  sqlSession.delete("JobMapper.deleteJobById", id);
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
		JobDAO JobDAO = new JobDAO();
		
		// 测试查询
//		Job emp = JobDAO.queryJobById(1);
// 		if(emp != null){
// 			System.out.println(emp.getId() + ";" + emp.getEmpid() + ";" + emp.getJobType() + ";" + emp.getJobLevel()
//			+ ";" + emp.getBaseSalary()+ ";" + emp.getBaseSalary());
// 		}else{
// 			System.out.println("emp=" + emp);
// 		}
		
 		// 测试添加
// 		Job Job = new Job();
// 		Job.setId(3);
// 		Job.setName("Zoec");
// 		Job.setAge(21);
// 		Job.setSex("M");
// 		int insert = JobDAO.addJob(Job);
// 		System.out.println("insert=" + insert);
		
		// 测试修改
//		Job Job = new Job();
// 		Job.setId(3);
// 		Job.setName("ZoeC");
// 		Job.setAge(20);
// 		Job.setSex("F");
// 		int result = JobDAO.editJob(Job);
// 		System.out.println("update=" + result);
		
		// 测试删除
//		int result = JobDAO.deleteJob(3);
//		System.out.println("delete=" + result);
 		
 		// 打印整表
 		List<Job> list = JobDAO.queryAllJob();
 		System.out.println("\n打印全表：");
 		for(Job e : list){
 			System.out.println(e.getId() + ";" + e.getEmpid() + ";" + e.getJobType() + ";" + e.getJobLevel()
 					+ ";" + e.getBaseSalary()+ ";" + e.getBaseSalary());
 		}
 		System.out.println("打印完毕");
 		

	}
}
