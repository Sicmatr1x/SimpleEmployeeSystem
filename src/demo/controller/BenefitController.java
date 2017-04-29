package demo.controller;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demo.beans.Benefit;
import demo.service.BenefitService;
import demo.service.DateFactory;

@Controller
public class BenefitController {

	@Resource(name = "benefitService")
	private BenefitService benefitService;

	/**
	 * http://localhost:8080/SimpleEmployeeSystem/getBenefitList
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getBenefitList")
	public String getBenefitList(HttpServletRequest request) {
		List<Benefit> list = benefitService.getAllBenefit();
		request.getSession().setAttribute("list", list);
		return "BenefitList";
	}

	/**
	 * http://localhost:8080/SimpleEmployeeSystem/addBenefit?id=?&empid=?&mounth=?&bene=?
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addBenefit", method = RequestMethod.GET)
	public ModelAndView addBenefit(HttpServletRequest request) {
		Benefit benefit = new Benefit();
		benefit.setId(Integer.valueOf(request.getParameter("id")));
		benefit.setEmpid(Integer.valueOf(request.getParameter("empid")));
		try {
			benefit.setMounth(DateFactory.getDate(request.getParameter("mounth")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		benefit.setBene(Integer.valueOf(request.getParameter("bene")));
		this.benefitService.addBenefit(benefit);
		return new ModelAndView("redirect:/getBenefitList");
	}

	/**
	 * http://localhost:8080/SimpleEmployeeSystem/editBenefit?id=?&empid=?&mounth=?&bene=?
	 * @param benefit
	 * @return
	 */
	@RequestMapping("/editBenefit")
	public ModelAndView editBenefitList(HttpServletRequest request) {
		Benefit benefit = new Benefit();
		benefit.setId(Integer.valueOf(request.getParameter("id")));
		benefit.setEmpid(Integer.valueOf(request.getParameter("empid")));
		try {
			benefit.setMounth(DateFactory.getDate(request.getParameter("mounth")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		benefit.setBene(Integer.valueOf(request.getParameter("bene")));
		this.benefitService.editBenefit(benefit);
		return new ModelAndView("redirect:/getBenefitList");
	}
	
	/**
	 * http://localhost:8080/SimpleEmployeeSystem/deleteBenefit?id=?
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteBenefit")
	public ModelAndView testedit(int id){
		this.benefitService.deleteBenefit(id);
		return new ModelAndView("redirect:/getBenefitList");
	}
}
