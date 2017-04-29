package demo.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.beans.Award;
import demo.service.AwardService;
import demo.service.DateFactory;

@Controller
public class AwardController {
	
	@Resource(name = "awardService")
	private AwardService awardService;
	
	/**
	 * http://localhost:8080/SimpleEmployeeSystem/getAwardList?year=
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAwardList")
	public String getAwardList(HttpServletRequest request) {
		Date year;
		try {
			year = DateFactory.getDate(request.getParameter("year"));
			System.out.println("request.getParameter=" + request.getParameter("year"));
			System.out.println("year=" + year);
			List<Award> list = awardService.queryYearAwardList(year);
			request.getSession().setAttribute("list", list);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "AwardList";
	}
}
