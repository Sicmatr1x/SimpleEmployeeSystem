package demo.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import demo.beans.Benefit;
import demo.db.DBAccess;

public class BenefitDAO {
	
	/**
	 * 返回整张Benefit表的内容
	 * @return 
	 */
	public List<Benefit> queryAllBenefit (){
//		System.out.println("开始建立数据库连接");
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
//			System.out.println("数据库连接建立完毕" + sqlSession);
			// 执行查询
//			System.out.println("执行查询");
			return sqlSession.selectList("BenefitMapper.queryAllBenefit");
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
	 * @return 查得到返回Benefit，查不到返回null
	 */
	public Benefit queryBenefitById (int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行查询
//			return sqlSession.selectList("BenefitMapper.queryBenefitById", id);
			return sqlSession.selectOne("BenefitMapper.queryBenefitById", id);
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
	public List<Benefit> queryBenefitByEmpId (int empid){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行查询
			return sqlSession.selectList("BenefitMapper.queryBenefitByEmpId", empid);
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
	 * @param Benefit
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int addBenefit(Benefit Benefit){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行插入
			int result =  sqlSession.insert("BenefitMapper.addBenefit", Benefit);
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
	 * @param Benefit
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int editBenefit(Benefit Benefit){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行插入
			int result =  sqlSession.update("BenefitMapper.editBenefit", Benefit);
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
	public int deleteBenefit(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			int result =  sqlSession.delete("BenefitMapper.deleteBenefitById", id);
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
		BenefitDAO BenefitDAO = new BenefitDAO();
		
		// 测试查询
//		Benefit emp = BenefitDAO.queryBenefitById(1);
// 		if(emp != null){
// 			System.out.println(emp.getId() + ";" + emp.getEmpid() + ";" + emp.getMounth() + ";" + emp.getOvertime());
// 		}else{
// 			System.out.println("emp=" + emp);
// 		}
		
 		// 测试添加
// 		Benefit Benefit = new Benefit();
// 		Benefit.setId(3);
// 		Benefit.setName("Zoec");
// 		Benefit.setAge(21);
// 		Benefit.setSex("M");
// 		int insert = BenefitDAO.addBenefit(Benefit);
// 		System.out.println("insert=" + insert);
		
		// 测试修改
//		Benefit Benefit = new Benefit();
// 		Benefit.setId(3);
// 		Benefit.setName("ZoeC");
// 		Benefit.setAge(20);
// 		Benefit.setSex("F");
// 		int result = BenefitDAO.editBenefit(Benefit);
// 		System.out.println("update=" + result);
		
		// 测试删除
//		int result = BenefitDAO.deleteBenefit(3);
//		System.out.println("delete=" + result);
 		
 		// 打印整表
 		List<Benefit> list = BenefitDAO.queryAllBenefit();
 		System.out.println("\n打印全表：");
 		for(Benefit e : list){
 			System.out.println(e.getId() + ";" + e.getEmpid() + ";" + e.getMounth() + ";" + e.getBene());
 		}
 		System.out.println("打印完毕");
 		

	}
}
