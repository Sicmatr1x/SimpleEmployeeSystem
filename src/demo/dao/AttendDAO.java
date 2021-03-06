package demo.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import demo.beans.Attend;
import demo.db.DBAccess;

public class AttendDAO {
	
	/**
	 * 返回整张Attend表的内容
	 * @return 
	 */
	public List<Attend> queryAllAttend (){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();;
			// 执行查询
			return sqlSession.selectList("AttendMapper.queryAllAttend");
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
	 * 根据id来查询指定记录
	 * @param id 记录id
	 * @return 查得到返回Attend，查不到返回null
	 */
	public Attend queryAttendById (int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行查询
//			return sqlSession.selectList("AttendMapper.queryAttendById", id);
			return sqlSession.selectOne("AttendMapper.queryAttendById", id);
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
	public List<Attend> queryAttendByEmpId (int empid){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行查询
			return sqlSession.selectList("AttendMapper.queryAttendByEmpId", empid);
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
	 * 插入记录
	 * @param Attend
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int addAttend(Attend Attend){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行插入
			int result =  sqlSession.insert("AttendMapper.addAttend", Attend);
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
	 * 修改给定id的记录
	 * @param Attend
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int editAttend(Attend Attend){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行插入
			int result =  sqlSession.update("AttendMapper.editAttend", Attend);
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
	 * 根据记录id来删除记录
	 * @param id
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int deleteAttend(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			int result =  sqlSession.delete("AttendMapper.deleteAttendById", id);
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
		AttendDAO AttendDAO = new AttendDAO();
		
		// 测试查询
//		Attend emp = AttendDAO.queryAttendById(1);
// 		if(emp != null){
// 			System.out.println(emp.getId() + ";" + emp.getEmpid() + ";" + emp.getAttendDate() + ";" + emp.getAttendType());
// 		}else{
// 			System.out.println("emp=" + emp);
// 		}
		
 		// 测试添加
// 		Attend Attend = new Attend();
// 		Attend.setId(3);
// 		Attend.setName("Zoec");
// 		Attend.setAge(21);
// 		Attend.setSex("M");
// 		int insert = AttendDAO.addAttend(Attend);
// 		System.out.println("insert=" + insert);
		
		// 测试修改
//		Attend Attend = new Attend();
// 		Attend.setId(3);
// 		Attend.setName("ZoeC");
// 		Attend.setAge(20);
// 		Attend.setSex("F");
// 		int result = AttendDAO.editAttend(Attend);
// 		System.out.println("update=" + result);
		
		// 测试删除
//		int result = AttendDAO.deleteAttend(3);
//		System.out.println("delete=" + result);
 		
 		// 打印整表
 		List<Attend> list = AttendDAO.queryAllAttend();
 		System.out.println("\n打印全表：");
 		for(Attend e : list){
 			System.out.println(e.getId() + ";" + e.getEmpid() + ";" + e.getAttendDate() + ";" + e.getOvertime() + ";" + e.getDayoff());
 		}
 		System.out.println("打印完毕");
 		

	}
}
