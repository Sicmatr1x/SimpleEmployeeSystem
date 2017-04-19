package demo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;

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
	 * http://localhost:8080/SimpleBenefitSystem/getBenefitList
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
	 * http://localhost:8080/SimpleBenefitSystem/addBenefit
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
		benefit.setOvertime(Integer.valueOf(request.getParameter("overtime")));
		this.benefitService.addBenefit(benefit);
		return new ModelAndView("redirect:/getBenefitList");
	}

	/**
	 * http://localhost:8080/SimpleBenefitSystem/editBenefit
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
		benefit.setOvertime(Integer.valueOf(request.getParameter("overtime")));
		this.benefitService.editBenefit(benefit);
		return new ModelAndView("redirect:/getBenefitList");
	}
	
	/**
	 * http://localhost:8080/SimpleBenefitSystem/deleteBenefit
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteBenefit")
	public ModelAndView testedit(int id){
		this.benefitService.deleteBenefit(id);
		return new ModelAndView("redirect:/getBenefitList");
	}
}
