package demo.service;

import java.util.List;

import javax.annotation.Resource;

import demo.beans.Benefit;
import demo.dao.BenefitDAO;


public class BenefitService {

	@Resource(name = "benefitDAO")
	private BenefitDAO benefitDAO;
	
	/**
	 * 返回整张Benefit表的内容
	 * @return
	 */
	public List<Benefit> getAllBenefit() {
		return benefitDAO.queryAllBenefit();
	}
	
	/**
	 * 根据id来查询指定记录
	 * @param id
	 * @return 查得到返回Benefit，查不到返回null
	 */
	public Benefit getBenefitById(int id){
		return this.benefitDAO.queryBenefitById(id);
	}
	
	/**
	 * 根据员工id来查询指定记录
	 * @param empid
	 * @return 查得到返回Benefit，查不到返回null
	 */
	public List<Benefit> getBenefitByEmpId(int empid){
		return this.benefitDAO.queryBenefitByEmpId(empid);
	}
	
	/**
	 * 插入记录
	 * @param benefit
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int addBenefit(Benefit benefit){
		return this.benefitDAO.addBenefit(benefit);
	}
	
	/**
	 * 修改给定id的记录信息
	 * @param benefit
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int editBenefit(Benefit benefit){
		return benefitDAO.editBenefit(benefit);
	}
	
	/**
	 * 根据记录id来删除记录
	 * @param id
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int deleteBenefit(int id){
		return this.benefitDAO.deleteBenefit(id);
	}

	public static void main(String[] args) {
		BenefitService es = new BenefitService();
		// 打印整表
		System.out.println(es==null);
		List<Benefit> list = es.getAllBenefit();
		System.out.println("\n打印全表：");
		for (Benefit e : list) {
			System.out.println(e.getId() + ";" + e.getEmpid() + ";" + e.getMounth() + ";" + e.getBene());
		}
		System.out.println("打印完毕");
	}
}
