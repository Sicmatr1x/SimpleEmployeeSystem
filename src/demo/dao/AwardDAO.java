package demo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import demo.beans.Award;
import demo.beans.Benefit;
import demo.beans.Employee;
import demo.beans.Salary;
import demo.db.DBAccess;

public class AwardDAO {
	
	@Resource(name = "employeeDAO")
	private EmployeeDAO employeeDAO;
	
	@Resource(name = "benefitDAO")
	private BenefitDAO benefitDAO;
	
	@Resource(name = "salaryDAO")
	private SalaryDAO salaryDAO;
	
	/**
	 * 根据员工id来查询指定记录
	 * @param id 记录id
	 * @return 查得到返回Attend，查不到返回null
	 */
	@SuppressWarnings("deprecation")
	public Award queryAwardByEmpId (int empid, Date year){
//		System.out.println("queryAwardByEmpId:year=" + year.getYear());
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行查询
			List<Salary> salaryList = sqlSession.selectList("SalaryMapper.querySalaryByEmpId", empid);
			List<Benefit> benefitList = sqlSession.selectList("BenefitMapper.queryBenefitByEmpId", empid);
			// 选出指定年份的记录
			List<Salary> salaryYearList = new ArrayList<>();
			List<Benefit> benefitYearList = new ArrayList<>();
			for(int i = 0; i < salaryList.size(); i++){
//				System.out.println("year.getYear()=" + year.getYear() + "  salaryList.get(i).getMounth().getYear()=" + salaryList.get(i).getMounth().getYear());
				if(year.getYear() == salaryList.get(i).getMounth().getYear()){
					salaryYearList.add(salaryList.get(i));
//					System.out.println("add" + salaryList.get(i).getId());
				}
			}
			for(int i = 0; i < benefitList.size(); i++){
				if(year.getYear() == benefitList.get(i).getMounth().getYear()){
					benefitYearList.add(benefitList.get(i));
				}
			}
			// 判断有没有12个月的记录
			if(salaryYearList.size() == 12 && benefitYearList.size() == 12){
				// 开始计算员工年终奖金
				// 员工的年终奖金计算公式＝（员工本年度的工资总和＋津贴的总和）/12
				int allSalary = 0;
				int allBenefit = 0;
				for(int i = 0; i < salaryYearList.size(); i++){
					allSalary += salaryYearList.get(i).getSalary();
				}
				for(int i = 0; i < benefitYearList.size(); i++){
					allBenefit += benefitYearList.get(i).getBene();
				}
				Award award = new Award();
				award.setEmpid(empid);
				award.setYear(year);
				award.setAllBenefit(allBenefit);
				award.setAllSalary(allSalary);
				award.setAward((allSalary + allBenefit) / 12);
				return award;
			}
			System.out.println("error:empid=" + empid + "salary or benefit not accord with 12 mounth");
			System.out.println("salaryYearList.size()=" + salaryYearList.size());
			System.out.println("benefitYearList.size()=" + benefitYearList.size());
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
	
	public List<Award> queryYearAwardList(Date year){
		List<Award> awardList = new ArrayList<>();
		
		List<Employee> employeeList = this.employeeDAO.queryAllEmployee();
		for(int i = 0; i < employeeList.size(); i++){
			Award award = this.queryAwardByEmpId(employeeList.get(i).getId(), year);
			if(award != null){
				awardList.add(award);
			}
		}
		
		return awardList;
	}
}
